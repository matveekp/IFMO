package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();

        User user1 = new User("qwe", 22, "Russia");
        User user2 = new User("asd", 56, "USA");
        User user3 = new User("zxc", 55, "German");
        User user4 = new User("ert", 46, "Canada");
        User user5 = new User("dfg", 18, "Canada");


        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);


        Listeners listeners = new Listeners(users);


        System.out.println(listeners.getFromCanada45());
        System.out.println(listeners.getMoreThen45());
        System.out.println(listeners.getRussianUsers());


        List<User> russianUsers =
                listeners.getFilterUsers(user -> "Russia".equals(user.getCountry()));

        System.out.println(russianUsers);

        Predicate<User> russiaFilter = user -> "Russia".equals(user.getCountry());
        Predicate<User> ageFilter = user -> user.getAge()>45;
        Predicate<User> canadaFilter = user -> "Canada".equals(user.getCountry());

        System.out.println(listeners.getFilterUsers(canadaFilter));
        System.out.println(canadaFilter.and(ageFilter));
        System.out.println(canadaFilter.or(russiaFilter));


    }


}


class Listeners {
    List<User> userList;

    public Listeners(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getRussianUsers() {
        List<User> list = new ArrayList<>();

        for (User user : userList) {
            if ("Russia".equals(user.getCountry()))
                list.add(user);
        }

        return list;
    }


    public List<User> getMoreThen45() {
        List<User> list = new ArrayList<>();
        for (User user : userList) {
            if (user.getAge() > 45)
                list.add(user);

        }
        return list;
    }

    public List<User> getFromCanada45() {
        List<User> list = new ArrayList<>();
        for (User user : userList) {
            if (user.getAge() > 45 && "Canada".equals(user.getCountry()))
                list.add(user);

        }
        return list;
    }


    // с использованием predicate
    public List<User> getFilterUsers(Predicate<User> filter) {
        List<User> list = new ArrayList<>();
        for (User user : userList) {
            if (filter.test(user)) {
                list.add(user);
            }
        }
        return list;
    }
}

class User {

    private String login;
    private int age;
    private String country;

    public User(String login, int age, String country) {
        this.login = login;
        this.age = age;
        this.country = country;
    }

    public String getLogin() {
        return login;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(login, user.login) &&
                Objects.equals(country, user.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, age, country);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                '}';
    }
}
