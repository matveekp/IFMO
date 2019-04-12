package patterns.dao;

import java.util.List;

public class TXTFileUserDao implements UserDao {
    @Override
    public void addUser(User user) {
        System.out.println("Добавление нового пользователя" + user);
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }
}

