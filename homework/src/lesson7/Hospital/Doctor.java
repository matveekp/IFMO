package lesson7.Hospital;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Doctor  extends User{

    private String name;
    private String login;
    private String specialisation;
    private int id;

    List<Patient> doctorPatientsList = new ArrayList<>();

    public Doctor(int id, String name, String login, String specialisation) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.specialisation=specialisation;
    }

    public int getId() {
        return id;
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

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
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
