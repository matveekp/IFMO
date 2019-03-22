package lesson7;

import java.util.ArrayList;
import java.util.List;

public class MainDoctor extends User{

    private String name;
    private String login;



    public MainDoctor(String name, String login) {
        this.name = name;
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
