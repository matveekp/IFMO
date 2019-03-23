package lesson7;

public class Patient extends User{
    private String name;
    private String login;

    public Patient(String name, String login) {
        this.name = name;
        this.login = login;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public void getCommands() {

    }
}
