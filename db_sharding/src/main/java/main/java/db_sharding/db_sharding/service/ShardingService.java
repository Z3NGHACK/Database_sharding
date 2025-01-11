package main.java.db_sharding.db_sharding.service;

import org.springframework.stereotype.Service;

@Service
public class ShardingService {

    public String determineShardForUserId(Long userId) {
        int shardIndex = Math.abs(userId.hashCode()) % 2; // Assuming two shards (ds0, ds1)
        return "ds" + shardIndex; 
    }
}