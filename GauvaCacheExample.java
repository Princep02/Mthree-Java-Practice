package FouthDay;

import com.google.common.cache.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GauvaCacheExample {
    public static void main(String[] args) {
        LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(20)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        return "Value for " + key;
                    }
                });
        try {
            String[] genres = {"Action", "Comedy", "Drama", "Horror", "Romance", "Sci-Fi", "Thriller"};
            // Write code to generate 200,000 movies with random genres and push in cache
            for (int i = 0; i < 20; i++) {
                String movie = "Movie" + i;
                String genre = genres[new Random().nextInt(genres.length)];
                cache.put(movie, genre);
            }
            // Thread.sleep(1000);
            for (int i = 0; i < 100; i++) {
                long startTime = System.nanoTime();
                String movie = cache.get("Movie92600");
                long endTime = System.nanoTime();
                System.out.println("Time taken to fetch the movie: " + (endTime - startTime) + " nanoseconds");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
