package ru.ildar.database.dao;

import org.springframework.stereotype.Repository;
import ru.ildar.entities.User;
import ru.ildar.entities.UserDetails;

@Repository
public interface UserDAO
{
    boolean userExists(String name, String password);
    void addUser(User user, UserDetails details);
    User getUser(int id);
}
