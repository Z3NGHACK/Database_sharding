package main.java.db_sharding.db_sharding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.db_sharding.db_sharding.entity.User;


@Repository
public interface UserRepo extends JpaRepository<User, Long> 
{
    User findByList(String email);
    User findByUser(String userName);
}
