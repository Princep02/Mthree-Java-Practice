package DayFive;

import java.util.HashMap;
import java.util.Map;

public class BookLibraryCache {
    // Book database (simulates a database of books)
    private final Map<String, Book> bookDatabase = new HashMap<>();
    
    // Cache to store the most recently accessed books
    private final Map<String, Book> cache = new HashMap<>();
    
    // Maximum size of the cache
    private final int MAX_CACHE_SIZE = 5;

    private int cacheHits = 0;
    private int cacheMisses = 0;

    public BookLibraryCache() {
        // Initializing the book database
        bookDatabase.put("1", new Book("1", "Book 1", "Author 1"));
        bookDatabase.put("2", new Book("2", "Book 2", "Author 2"));
        bookDatabase.put("3", new Book("3", "Book 3", "Author 3"));
        bookDatabase.put("4", new Book("4", "Book 4", "Author 4"));
        bookDatabase.put("5", new Book("5", "Book 5", "Author 5"));
        bookDatabase.put("6", new Book("6", "Book 6", "Author 6"));
    }

    // Method to get a book either from the cache or database
    public Book fetchBook(String bookId) {
        Book book = cache.get(bookId); // Try to get the book from the cache
        if (book != null) {
            cacheHits++; // Cache hit
            System.out.println("Cache Hit for bookId: " + bookId);
            return book;
        } else {
            cacheMisses++; // Cache miss
            System.out.println("Cache Miss for bookId: " + bookId);
            book = bookDatabase.get(bookId); // Fetch from the database
            if (book != null) {
                addToCache(bookId, book); // Add to cache if found in the database
            }
            return book;
        }
    }

    // Method to add a book to the cache and handle cache size limit
    private void addToCache(String bookId, Book book) {
        if (cache.size() >= MAX_CACHE_SIZE) {
            String keyToRemove = cache.keySet().iterator().next(); // Get the first inserted book
            cache.remove(keyToRemove); // Remove least recently used book
            System.out.println("Cache is full. Removing least recently used bookId: " + keyToRemove);
        }
        cache.put(bookId, book); // Add the new book to the cache
        System.out.println("Added to cache: " + bookId);
    }

    // Print cache statistics (cache hit ratio, size, etc.)
    public void printCacheStatistics() {
        System.out.println("Cache Hits: " + cacheHits);
        System.out.println("Cache Misses: " + cacheMisses);
        System.out.println("Cache Hit Ratio: " + ((double) cacheHits / (cacheHits + cacheMisses)));
        System.out.println("Current Cache Size: " + cache.size());
        System.out.println("Books in Cache: " + cache.keySet());
    }

    // Book class to represent a book entity
    private static class Book {
        private String id;
        private String title;
        private String author;

        public Book(String id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
        }

        @Override
        public String toString() {
            return "Book{id='" + id + "', title='" + title + "', author='" + author + "'}";
        }
    }

    // Main method to run the cache simulation
    public static void main(String[] args) {
        BookLibraryCache libraryCache = new BookLibraryCache();
        
        // List of book requests
        String[] requestedBooks = { "1", "2", "3", "4", "5", "6", "1", "2", "3", "4", "5", "6", "5", "4", "3", "9" };
        
        // Process each book request
        for (String bookId : requestedBooks) {
            Book book = libraryCache.fetchBook(bookId);
            if (book != null) {
                System.out.println("Retrieved book: " + book);
            } else {
                System.out.println("Book not found with bookId: " + bookId);
            }
            System.out.println("-----------------------------------");
        }

        // Print cache statistics at the end
        libraryCache.printCacheStatistics();
    }
}
