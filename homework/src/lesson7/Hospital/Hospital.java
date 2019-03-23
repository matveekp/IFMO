package lesson7.Hospital;


import java.util.*;

public class Hospital {


    private List<Doctor> doctorList = new ArrayList<>();
    private List<Patient> patientsList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    String enterLogin;
    String enterCommand;
    private static int patientCount = 3;

    MainDoctor mainDoctor = new MainDoctor("Ivanov I.I.", "ivanov");
    Doctor doctor1 = new Doctor(1, "Petrov P.P.", "petrov", "Surgeon");
    Doctor doctor2 = new Doctor(2, "Sidorov V.V.", "sidorov", "Oculist");
    Doctor doctor3 = new Doctor(3, "Nikitin N.N.", "nikitin", "Dentist");

    Patient patient1 = new Patient("Bobrov V.A.", "patient1");
    Patient patient2 = new Patient("Sokolov A.A.", "patient2");
    Patient patient3 = new Patient("Nikolskiy V.G.", "patient3");

    Administrator administrator = new Administrator();

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
        patientsList.add(patient2);
        patientsList.add(patient3);

        doctor2.addPatientsToDoctor(patient1);
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
                        for (int i = 0; i < patientsList.size(); i++) {
                            System.out.println(i+". " + patientsList.get(i).getName());
                        }
                        break;

                    case 2:
                        System.out.println("Список врачей");
                        for (int i = 0; i < doctorList.size(); i++) {
                            System.out.println(i+". "+ doctorList.get(i).getName());
                        }
                        System.out.println("----------------------------");
                        System.out.println("Укажите ID врача, записи к которому Вы хотите посмотреть?");
                        int choise2 = scanner.nextInt();
                        for (int i = 0; i < doctorList.size(); i++) {

                            if (choise2 == doctorList.get(i).getId()){
                                System.out.println(doctorList.get(i).getDoctorPatientList());
                            }
                            else System.out.println("Вы указали неверный ID");
                            System.out.println("Выход из системы.");
                            System.out.println("----------------------------");
                        }
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
                        for (int i = 0; i < doctorList.size(); i++) {
                            System.out.println(i+" ."+doctorList.get(i).getDoctorPatientList());
                        }
                        break;
                    case 2:
                        System.out.println("Выход из системы.");
                        System.out.println("----------------------------");
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
                        for (int i = 0; i < doctorList.size(); i++) {
                            System.out.println(i+". "+ doctorList.get(i).getName());
                        }
                        System.out.println("----------------------------");
                        System.out.println("К какому врачу Вы хотите записаться?");
                        int choise2 = scanner.nextInt();
                        for (int i = 0; i < doctorList.size(); i++) {
                            if (choise2 == doctorList.get(i).getId()){
                                doctorList.get(i).addPatientsToDoctor((Patient) currentUser);
                            }
                        }
                        System.out.println("Вы успешно записались к врачу!");
                        System.out.println("Выход из системы.");
                        System.out.println("----------------------------");
                        break;
                    case 2:
                        System.out.println("Выход из системы.");
                        System.out.println("----------------------------");
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













