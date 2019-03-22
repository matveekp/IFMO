package lesson7;


import java.util.*;

public class Hospital {


    private List<Doctor> doctorList = new ArrayList<>();
    private List<Patient> patientsList = new ArrayList<>();


    Scanner scanner = new Scanner(System.in);
    String enterLogin;
    private static int patientCount = 0;

    MainDoctor mainDoctor = new MainDoctor("Ivanov I.I.", "ivanov");
    Doctor doctor1 = new Doctor("Petrov P.P.", "petrov");
    Doctor doctor2 = new Doctor("Sidorov V.V.", "sidorov");
    Doctor doctor3 = new Doctor("Nikitin N.N.", "nikitin");

    Patient patient1 = new Patient("Bobrov V.A.", "bobrob");


    Administrator administrator = new Administrator("Kazakov V.A.", "kazakov");

//    public static int getPatientCount() {
//        return patientCount;
//    }

//    public static void addPatientCount() {
//        Hospital.patientCount++;
//    }

    public void addDoctor(Doctor doctor) {
        doctorList.add(doctor);
    }

    public void addPatient(Patient patient) {
        patientsList.add(patient);

    }


    public List<Patient> showAllPatiens() {

        return patientsList;
    }

    public List<Doctor> showAllDoctors() {
        return doctorList;
    }

    public void assignDoctor(Doctor doctor) {

    }

    public void open() {

        addDoctor(doctor1);
        addDoctor(doctor2);
        addDoctor(doctor3);
        addPatient(patient1);

        while (true) {
            if (checkLogin() instanceof MainDoctor)
                //
                return;

            else if (checkLogin() instanceof Doctor)
                //
                return;

            else if (checkLogin() instanceof Patient)
                //
                return;

            else return;

        }

    }


    public User checkLogin() {


        System.out.println("Введите логин");

        enterLogin = scanner.next();

        if (enterLogin.equalsIgnoreCase("exit"))
            return null;

        else if (enterLogin.equalsIgnoreCase(mainDoctor.getLogin())) {

            System.out.println("Выполнен вход в систему. Ваше имя - " + mainDoctor.getName() + "Ваша роль в системе: Главный врач");

            // команды
            return mainDoctor;

        }

        else if (showAllDoctors().contains(enterLogin)) {
            System.out.println("Выполнен вход в систему. " + "Ваша роль в системе: Врач");
///?????? проверка есть ли врач

            // команды
            return null;
        }

        else {
            for (int i = 0; i < patientsList.size(); i++) {

                if (enterLogin.equals(patientsList.get(i))) {
                    System.out.println("Вы вошли как пациент. Ваше имя: " + patientsList.get(i).getName());
                    return patientsList.get(i);

                } else {

                    System.out.println("Вы не найдены в системе. Введите Ваше имя");
                    String name = scanner.next();
                    patientCount++;
                    String login = "patient" + patientCount;
                    Patient patient = new Patient(name, login);

                    addPatient(patient);
                    System.out.println("Запись добавлена.");
                    System.out.println("Ваше имя в системе: " + patient.getName());
                    System.out.println("Ваш логин: " + patient.getLogin());

                    return patient;

                }

            }

        }

        return null;
    }
}













