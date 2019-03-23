package lesson7.Hospital;

public class Patient extends User {
    private String name;
    private String login;

    public Patient(String name, String login) {
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
