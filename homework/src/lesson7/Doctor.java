package lesson7;

import java.util.ArrayList;
import java.util.List;

public class Doctor  extends User{

    private String name;
    private String login;

    List<Patient> doctorPatientsList = new ArrayList<>();

    public Doctor(String name, String login) {
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

    public List<Patient> getDoctorPatientList()
    {
        return doctorPatientsList;
    }

    public void addPatientsToDoctor(Patient o)
    {
        doctorPatientsList.add(o);
    }
}
