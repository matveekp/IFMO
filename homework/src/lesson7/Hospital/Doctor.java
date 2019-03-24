package lesson7.Hospital;

import java.text.SimpleDateFormat;
import java.util.*;

public class Doctor  extends User{

    private String name;
    private String login;
    private String specialisation;
    private int id;

    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    Map<Date, Patient> doctorTimePatientMap = new LinkedHashMap<>();

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

    public String getLogin() {
        return login;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public Map<Date, Patient> getDoctorTimePatientMap() {
        return doctorTimePatientMap;
    }

    public void addDoctorTimePatientMap(Date date, Patient patient){
        doctorTimePatientMap.put(date, patient);
    }

    public String getTimeForPatients() {

        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Date, Patient> entry : doctorTimePatientMap.entrySet()) {
            stringBuilder.append(sdfDate.format(entry.getKey())+" " + entry.getValue().getName()+"\n");
        }
        return stringBuilder.toString();
    }
}
