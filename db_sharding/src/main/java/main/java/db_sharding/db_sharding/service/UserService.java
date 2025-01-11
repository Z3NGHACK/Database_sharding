// package main.java.db_sharding.db_sharding.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import jakarta.transaction.Transactional;
// import main.java.db_sharding.db_sharding.entity.User;
// import main.java.db_sharding.db_sharding.repository.UserRepo;

// @Service
// public class UserService {
//     @Autowired
//     private UserRepo userRepo;

//     @Transactional
//     public User createUser(User user){
//         if(user == null){
//             throw new IllegalArgumentException("User cannot be null");
//         }
//         return userRepo.save(user);
//     }

//     public User getUserById(Long userId)
//     {
//         return userRepo
//         .findById(userId)
//         .orElseThrow(() -> 
//             new RuntimeException
//             ("User not found with ID: " + userId)
//         );
//     }

// }

package main.java.db_sharding.db_sharding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import main.java.db_sharding.db_sharding.entity.User;
import main.java.db_sharding.db_sharding.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepo userRepo;

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
        logger.info("Creating user: {}", user);
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
        logger.info("Fetching user with ID: {}", userId);
        return userRepo
                .findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
    }
}
