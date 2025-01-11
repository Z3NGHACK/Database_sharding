package main.java.db_sharding.db_sharding.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class ShardRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        // The logic that determines which shard to use based on the current context
        return ShardingContext.getCurrentShard();
    }
}
