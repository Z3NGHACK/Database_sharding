package main.java.db_sharding.db_sharding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.transaction.Transactional;
import main.java.db_sharding.db_sharding.entity.User;
import main.java.db_sharding.db_sharding.repository.UserRepo;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    // Autowire the UserRepo to interact with the database
    @Autowired
    private UserRepo userRepo;

    // Autowire the ShardingService to determine which shard to use
    @Autowired
    private ShardingService shardingService;

    /**
     * Creates a new user in the database.
     * 
     * @param user the user to be saved
     * @return the saved user
     * @throws IllegalArgumentException if the user is null
     */
    @Transactional
    public User createUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        // Determine the shard to use based on the user ID
        String shard = shardingService.determineShardForUserId(user.getuserId());
        if (shard == null) {
            throw new RuntimeException("Shard determination failed for user ID: " + user.getuserId());
        }

        logger.info("Creating user in shard: {}", shard);

        // Save the user to the appropriate shard
        return userRepo.save(user);
    }

    /**
     * Fetches a user by their ID.
     * 
     * @param userId the ID of the user to fetch
     * @return the user if found
     * @throws RuntimeException if the user is not found
     */
    public User getUserById(Long userId) {
        if (userId == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }

        // Determine the shard to use based on the user ID
        String shard = shardingService.determineShardForUserId(userId);
        if (shard == null) {
            throw new RuntimeException("Shard determination failed for user ID: " + userId);
        }

        logger.info("Fetching user from shard: {}", shard);

        // Retrieve the user from the repository
        return userRepo
                .findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
    }

    /**
     * Fetches user data from the correct shard based on the user ID.
     * 
     * @param shard the shard to fetch from
     * @param userId the ID of the user to fetch
     * @return the user data as a String (or modify to return the actual user object)
     */
    public String getUserDataFromShard(String shard, Long userId) {
        if (shard == null || userId == null) {
            throw new IllegalArgumentException("Shard or User ID cannot be null");
        }

        logger.info("Fetching user data from shard: {} for user ID: {}", shard, userId);

        // Here, you would perform actual logic to fetch data from the specified shard
        // For example, you may use different repositories or data sources for each shard.
        // This is a simplified mock behavior to illustrate the concept.

        // Assuming userRepo works across all shards, this is just for illustration.
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        return "User Data from " + shard + ": " + user.toString(); // Just returning a string for mock
    }
}
