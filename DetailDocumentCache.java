package DayFive;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class DetailDocumentCache {
    // ConcurrentHashMap is used for thread-safe access
    private final ConcurrentHashMap<String, Document> cache;
    private final String diskStoragePath;
    private final int maxCacheSize;

    // Atomic counters for cache hits and misses
    private final AtomicInteger cacheHits = new AtomicInteger(0);
    private final AtomicInteger cacheMisses = new AtomicInteger(0);

    public DetailDocumentCache(int maxCacheSize, String diskStoragePath) {
        this.maxCacheSize = maxCacheSize;
        this.diskStoragePath = diskStoragePath;
        this.cache = new ConcurrentHashMap<>(maxCacheSize);

        try {
            Files.createDirectories(Paths.get(diskStoragePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Retrieves a document from cache if exists, else saves a new document
    public Document getDocumentIfExistElseSave(String documentId) throws IOException, ClassNotFoundException {
        // First, check in cache
        Document cachedDocument = cache.get(documentId);
        if (cachedDocument != null) {
            cacheHits.incrementAndGet(); // Increment cache hit count
            return cachedDocument;
        } else {
            cacheMisses.incrementAndGet(); // Increment cache miss count
            // Check on disk storage
            Document document = loadDocumentFromDisk(documentId);
            if (document == null) {
                // Document doesn't exist, create and save a new one
                document = new Document(documentId, "Content for " + documentId, System.currentTimeMillis(), System.currentTimeMillis());
                saveDocument(document); // Save to cache and disk
                System.out.println("Saved new document: " + documentId);
            } else {
                // If document exists on disk, add it to cache
                addToCache(documentId, document);
            }
            return document;
        }
    }

    // Saves the document both to disk and cache
    public void saveDocument(Document document) throws IOException {
        evictCacheIfNecessary(); // Make space in cache if necessary
        saveToDisk(document); // Save document to disk
        addToCache(document.getDocumentId(), document); // Add to cache
    }

    private void saveToDisk(Document document) throws IOException {
        Path filePath = Paths.get(diskStoragePath, document.getDocumentId());
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(filePath))) {
            out.writeObject(document);
        }
    }

    private void addToCache(String documentId, Document document) {
        cache.put(documentId, document); // Simply add document to cache
    }

    // Load document from disk
    private Document loadDocumentFromDisk(String documentId) throws IOException, ClassNotFoundException {
        Path filePath = Paths.get(diskStoragePath, documentId);
        if (Files.exists(filePath)) {
            try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(filePath))) {
                return (Document) in.readObject();
            }
        }
        return null;
    }

    // Evicts older documents if cache exceeds max size
    private void evictCacheIfNecessary() {
        while (cache.size() > maxCacheSize) {
            String oldestDocument = cache.keySet().iterator().next();
            cache.remove(oldestDocument);
        }
    }

    // Print cache statistics
    public void printCacheStatistics() {
        System.out.println("Cache Hits: " + cacheHits.get());
        System.out.println("Cache Misses: " + cacheMisses.get());
        System.out.println("Cache Size: " + cache.size());
        System.out.println("Cache Capacity: " + maxCacheSize);
    }

    public static class Document implements Serializable {
        private final String documentId;
        private final String content;
        private final long timestamp;
        private final long lastModifiedTime;

        public Document(String documentId, String content, long timestamp, long lastModifiedTime) {
            this.documentId = documentId;
            this.content = content;
            this.timestamp = timestamp;
            this.lastModifiedTime = lastModifiedTime;
        }

        public String getDocumentId() {
            return documentId;
        }

        @Override
        public String toString() {
            return "Document{" +
                    "documentId='" + documentId + '\'' +
                    ", content='" + content + '\'' +
                    ", timestamp=" + timestamp +
                    ", lastModifiedTime=" + lastModifiedTime +
                    '}';
        }
    }

    public static void main(String[] args) {
        DetailDocumentCache cache = new DetailDocumentCache(200, "C:\\Codebase\\my-caching-project\\diskStorage");

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            final int index = i; // Using final for lambda function
            executor.execute(() -> {
                try {
                    String documentId = "Document" + (index % 4); // Modulo to simulate existing IDs
                    Document doc = cache.getDocumentIfExistElseSave(documentId);
                    System.out.println("Retrieved or Saved Document: " + doc);
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cache.printCacheStatistics();
    }
}
