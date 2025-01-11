package main.java.db_sharding.db_sharding.controller;

import main.java.db_sharding.db_sharding.service.ShardingService;
import main.java.db_sharding.db_sharding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShardingController {

    private final ShardingService shardingService;
    private final UserService userService;

    @Autowired
    public ShardingController(ShardingService shardingService, UserService userService) {
        this.shardingService = shardingService;
        this.userService = userService;
    }

    // Endpoint to fetch user data by user ID
    @GetMapping("/user/{userId}")
    public String getUserData(@PathVariable Long userId) {
        // Determine the shard to use based on user ID
        String shard = shardingService.determineShardForUserId(userId);

        // Fetch user data from the appropriate shard (mock behavior here)
        String userData = userService.getUserDataFromShard(shard, userId);

        return userData;
    }

    // Endpoint to test sharding logic
    @GetMapping("/test-shard/{userId}")
    public String testSharding(@PathVariable Long userId) {
        String shard = shardingService.determineShardForUserId(userId);
        return "User with ID " + userId + " is assigned to shard: " + shard;
    }
}
