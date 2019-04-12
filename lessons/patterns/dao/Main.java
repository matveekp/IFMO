package patterns.dao;

public class Main {
    public static void main(String[] args) {
        User user = new User("Bob", 45);

        UserDao userDao = new TXTFileUserDao();
        userDao.addUser(user);

    }
}
