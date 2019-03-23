package lesson7;


import java.util.*;

public class Hospital {


    private List<Doctor> doctorList = new ArrayList<>();
    private List<Patient> patientsList = new ArrayList<>();


    Scanner scanner = new Scanner(System.in);
    String enterLogin;
    String enterCommand;
    private static int patientCount = 1;

    MainDoctor mainDoctor = new MainDoctor("Ivanov I.I.", "ivanov");
    Doctor doctor1 = new Doctor("Petrov P.P.", "petrov");
    Doctor doctor2 = new Doctor("Sidorov V.V.", "sidorov");
    Doctor doctor3 = new Doctor("Nikitin N.N.", "nikitin");

    Patient patient1 = new Patient("Bobrov V.A.", "bobrov");

    Administrator administrator = Administrator.getInstance();

    User currentUser;



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

    public void init() {
        addDoctor(doctor1);
        addDoctor(doctor2);
        addDoctor(doctor3);
        addPatient(patient1);
    }


    public void open() {
        init();

        while (true) {
            if (checkLogin() instanceof MainDoctor) {
                //

               currentUser = checkLogin();
                System.out.println(checkLogin());
                //System.out.println(currentUser.getCommands());

               return;
            }

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
            return mainDoctor;
        }

        else {
            //проверка на доктора
            for (int i = 0; i < doctorList.size(); i++) {
                if (enterLogin.equals(doctorList.get(i).getLogin())) {
                    System.out.println("Выполнен вход в систему. " + "Ваша роль в системе: Врач");
                    return doctorList.get(i);
                }
            }
            //проверка на пациента
            for (int i = 0; i < patientsList.size(); i++) {
                if (enterLogin.equals(patientsList.get(i).getLogin())) {
                    System.out.println("Вы вошли как пациент. Ваше имя: " + patientsList.get(i).getName());
                    return patientsList.get(i);
                }
            }
            //если не нашли пациента
                    System.out.println("Вы не найдены в системе. Введите Ваше имя");
                    String name = scanner.next();
                    if (!name.equalsIgnoreCase("exit")) {
                        patientCount++;
                        String login = "patient" + patientCount;
                        Patient patient = new Patient(name, login);
                        patientsList.add(patient);
                        System.out.println("Запись добавлена.");
                        System.out.println("Ваше имя в системе: " + patient.getName());
                        System.out.println("Ваш логин: " + patient.getLogin());
                        return patient;
                    }
                    else return null;


                }

            }

        }

















