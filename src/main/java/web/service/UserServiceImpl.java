package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    @Override
    @Transactional
    public void editUser(User user) {
        this.userDao.editUser(user);
    }

    @Override
    @Transactional
    public void removeUser(long id) {
        this.userDao.removeUser(id);
    }

    @Override
    @Transactional
    public User getUserById(long id) {
        return this.userDao.getUserById(id);
    }

    @Override
    @Transactional
    public List<User> allUsers() {
        return this.userDao.allUsers();
    }
}
