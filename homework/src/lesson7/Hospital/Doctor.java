package lesson7.Hospital;

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


    public List<Patient> getDoctorPatientList()
    {
        return doctorPatientsList;
    }

    public void addPatientsToDoctor(Patient o)
    {
        doctorPatientsList.add(o);
    }
}
