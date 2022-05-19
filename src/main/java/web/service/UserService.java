package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void editUser(User user);
    void removeUser(long id);
    User getUserById(long id);
    List<User> allUsers();
}
