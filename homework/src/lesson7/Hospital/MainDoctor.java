package lesson7.Hospital;

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

    public String getLogin() {
        return login;
    }

}
