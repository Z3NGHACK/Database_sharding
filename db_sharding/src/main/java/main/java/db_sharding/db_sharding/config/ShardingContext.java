package main.java.db_sharding.db_sharding.config;

public class ShardingContext {

    private static ThreadLocal<String> currentShard = new ThreadLocal<>();

    public static void setCurrentShard(String shard) {
        currentShard.set(shard);
    }

    public static String getCurrentShard() {
        return currentShard.get();
    }

    public static void clear() {
        currentShard.remove();
    }
}
