package main.java.db_sharding.db_sharding.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    userId;

    private String  userName;
    private String  email;
    private String  phoneNumber;

    public User() 
    {}

    public User(
        Long userId, 
        String userName, 
        String email, 
        String phoneNumber
    ) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public Long getuserId() {
        return userId;
    }
    public void setuserId(Long userId) {
        this.userId = userId;
    }
    public String getuserName() {
        return userName;
    }
    public void setuserName(String userName) {
        this.userName = userName;
    }
    public String getemail() {
        return email;
    }
    public void setemail(String email) {
        this.email = email;
    }
    public String getphoneNumber() {
        return phoneNumber;
    }
    public void setphoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
