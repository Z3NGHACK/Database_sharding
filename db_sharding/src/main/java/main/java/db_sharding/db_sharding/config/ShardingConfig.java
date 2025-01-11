package main.java.db_sharding.db_sharding.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShardingConfig {

    @Bean
    public ShardingAlgorithm<String> shardingAlgorithm() {
        return new MyShardingAlgorithm(); 
    }

    // ... other sharding-related configurations (if applicable) 
}