package com.ryan.review.mapper;

import com.ryan.review.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> GetAllUsers();
    User GetUserByName(String userName);
    User GetUserByID(int userID);
    int AddUser(User user);
    int UpdateUser(User user);
    int DeleteUser(User user);
}
