package ThirdDay;

import java.util.*;

public class MovieRecommendationCache {
    /**
     * Cache for storing recent movie recommendations.
     * This cache uses a LinkedHashMap with the following characteristics:
     * 
     * @param initialCapacity 100 - The initial capacity of the map.
     * @param loadFactor 0.75f - The load factor used to determine when to resize the map.
     * @param accessOrder true - Enables access-order iteration (least recently used order).
     * 
     * How it works:
     * 1. The cache stores movie recommendations as key-value pairs (String, String).
     * 2. It has a fixed capacity of 100 entries.
     * 3. When the cache reaches capacity and a new entry is added, the least recently accessed
     *    entry is automatically removed.
     * 4. The load factor of 0.75 means the map will resize when it's 75% full, improving performance.
     * 5. Access-order iteration ensures that entries are ordered based on their access time,
     *    with the least recently used entry at the beginning and the most recently used at the end.
     */
    // L1 Cache Implementation
    private static final int MAX_ENTRIES = 100;
    private final Map<String, String> recentMovieCache =
        new LinkedHashMap<String, String>(100, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > MAX_ENTRIES;
            }
        };

    // L2 Cache Implementation
    private static final int MAX_ENTRIES_L2 = 1000;
    private final Map<String, String> popularMovieCache =
        new LinkedHashMap<String, String>(MAX_ENTRIES_L2, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > MAX_ENTRIES_L2;
            }
        };

    public MovieRecommendationCache() {
        populateCache();
    }

    private void populateCache() {
        // Populate recent movie cache
        for (int i = 0; i < 100; i++) {
            String movie = "Movie" + i;
            recentMovieCache.put(movie, "Recently Viewed");
        }
        
        // Populate popular movie cache
        String[] genres = {"Action", "Comedy", "Drama", "Horror", "Romance", "Sci-Fi", "Thriller"};
        for (int i = 0; i < 2000; i++) {
            String movie = "Movie" + i;
            String genre = genres[new Random().nextInt(genres.length)];
            popularMovieCache.put(movie, genre);
        }
    }

    public static void main(String[] args) {
        MovieRecommendationCache cache = new MovieRecommendationCache();
        
        // Measure the time taken to fetch a movie
        long startTime = System.nanoTime();
        String movie = cache.popularMovieCache.get("Movie100");
        long endTime = System.nanoTime();
        
        System.out.println("Recommended movie: " + movie);
        System.out.println("Time taken to fetch the movie: " + (endTime - startTime) + " nanoseconds");
    }
}
