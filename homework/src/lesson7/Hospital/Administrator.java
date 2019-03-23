package lesson7.Hospital;

import java.util.List;

public class Administrator extends User{

    Doctor doctor;
    Patient patient;


    public void addPatientToDoctor(Patient patient){
       doctor.addPatientsToDoctor(patient);
    }

//    public List<Patient> showPatientsToDoctor(Doctor doctor) {
//      return doctor.getDoctorPatientList(doctor);
//
//    }






}
