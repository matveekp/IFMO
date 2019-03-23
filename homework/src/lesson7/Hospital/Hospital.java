package lesson7.Hospital;


import java.util.*;

public class Hospital {


    private List<Doctor> doctorList = new ArrayList<>();
    private List<Patient> patientsList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    String enterLogin;
    String enterCommand;
    private static int patientCount = 1;

    MainDoctor mainDoctor = new MainDoctor("Ivanov I.I.", "ivanov");
    Doctor doctor1 = new Doctor("Petrov P.P.", "petrov", "Surgeon");
    Doctor doctor2 = new Doctor("Sidorov V.V.", "sidorov", "Oculist");
    Doctor doctor3 = new Doctor("Nikitin N.N.", "nikitin", "Dentist");

    Patient patient1 = new Patient("Bobrov V.A.", "patient1");

    Administrator administrator = new Administrator("MainAdminName", "admin");

    User currentUser;

    public List<Patient> showAllPatiens() {

        return patientsList;
    }

    public List<Doctor> showAllDoctors() {
        return doctorList;
    }

    public void assignDoctor(Doctor doctor) {

    }

    public void init() {
        doctorList.add(doctor1);
        doctorList.add(doctor2);
        doctorList.add(doctor3);
        patientsList.add(patient1);
    }


    public void open() {
        init();

        while (true) {
            currentUser = checkLogin();
            if (currentUser instanceof MainDoctor) {
                System.out.println("----------------------------");
                System.out.println("Выберите желаемое действие:");
                System.out.println("1. Посмотреть всех пациентов");
                System.out.println("2. Посмотреть запись к конкретному врачу");
                int choise = scanner.nextInt();
                switch (choise) {
                    case 1:
                        for (Patient patient : patientsList) {
                            System.out.println(patient);
                        }
                        break;
                    case 2:
                        break;


                }
            } else if (currentUser instanceof Doctor) {
                System.out.println("----------------------------");
                System.out.println("Выберите желаемое действие:");
                System.out.println("1. Посмотреть записи пациентов");
                System.out.println("2. Выйти из системы");
                int choise = scanner.nextInt();
                switch (choise) {
                    case 1:
                        for (Doctor doctor : doctorList) {
                            System.out.println(doctor.getDoctorPatientList((Doctor) currentUser));
                        }
                        break;
                    case 2:
                        break;
                }
            } else if (currentUser instanceof Patient) {
                System.out.println("----------------------------");
                System.out.println("Выберите желаемое действие:");
                System.out.println("1. Записаться к врачу");
                System.out.println("2. Выйти из системы");
                int choise = scanner.nextInt();
                switch (choise) {
                    case 1:
                        System.out.println("Список врачей");
                        for (int i = 1; i < doctorList.size()-1; i++) {
                            System.out.println(i+". "+ doctorList.get(i).getName());
                        }

                        System.out.println("----------------------------");
                        System.out.println("К каому врачу Вы хотите записаться?");

                        int choise2 = scanner.nextInt();

                        switch (choise2){
                            case 1:

                                break;
                            case 2:

                                break;
                            case 3:

                                break;

                        }


                        break;
                    case 2:
                        break;

                }

            } else return;

        }

    }


    public User checkLogin() {

        System.out.println("Введите логин");
        enterLogin = scanner.next();

        if (enterLogin.equalsIgnoreCase("exit"))
            return null;

        else if (enterLogin.equalsIgnoreCase(mainDoctor.getLogin())) {
            System.out.println("Выполнен вход в систему. Ваше имя - " + mainDoctor.getName());
            System.out.println("Ваша роль в системе: Главный врач");
            return mainDoctor;
        } else {
            //проверка на доктора
            for (int i = 0; i < doctorList.size(); i++) {
                if (enterLogin.equals(doctorList.get(i).getLogin())) {
                    System.out.println("Выполнен вход в систему. Ваше имя - " + doctorList.get(i).getName());
                    System.out.println("Ваша роль в системе: Врач");
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
            } else return null;


        }

    }

}













