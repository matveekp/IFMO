package lesson7.Hospital;


import java.util.*;

public class Hospital {


    List<Doctor> doctorList = new ArrayList<>();
    List<Patient> patientsList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    String enterLogin;
    String enterCommand;
    private static int patientCount = 3;

    MainDoctor mainDoctor = new MainDoctor("Ivanov I.I.", "ivanov");
    Doctor doctor1 = new Doctor(0, "Petrov P.P.", "petrov", "Surgeon");
    Doctor doctor2 = new Doctor(1, "Sidorov V.V.", "sidorov", "Oculist");
    Doctor doctor3 = new Doctor(2, "Nikitin N.N.", "nikitin", "Dentist");

    Patient patient1 = new Patient("Bobrov V.A.", "patient1");
    Patient patient2 = new Patient("Sokolov A.A.", "patient2");
    Patient patient3 = new Patient("Nikolskiy V.G.", "patient3");


    User currentUser;


    public void init() {
        doctorList.add(doctor1);
        doctorList.add(doctor2);
        doctorList.add(doctor3);

        patientsList.add(patient1);
        patientsList.add(patient2);
        patientsList.add(patient3);

        doctor1.addPatientsToDoctor(patient1);


        doctor2.addPatientsToDoctor(patient1);
        doctor2.addPatientsToDoctor(patient2);
        doctor2.addPatientsToDoctor(patient3);


        doctor3.addPatientsToDoctor(patient3);
    }


    public void open() {
        init();

        while (true) {
            currentUser = checkLogin();
            if (currentUser instanceof MainDoctor) {
                System.out.println("----------------------------");
                System.out.println("Выберите желаемое действие:");
                System.out.println("1. Посмотреть всех пациентов");
                System.out.println("2. Посмотреть все записи к конкретному врачу");
                int choice = scanner.nextInt();
                switch (choice) {

                    case 1:
                        for (int i = 0; i < patientsList.size(); i++) {
                            System.out.println(i+". " + patientsList.get(i).getName());
                        }
                        break;

                    case 2:
                        System.out.println("Список врачей");
                        for (int i = 0; i < doctorList.size(); i++) {
                            System.out.println(i+". "+ doctorList.get(i).getName() + ". Специализация: " + doctorList.get(i).getSpecialisation());
                        }
                        System.out.println("----------------------------");
                        System.out.println("Укажите ID врача, записи к которому Вы хотите посмотреть?");
                        int choice2 = scanner.nextInt();

                        for (int i = 0; i < doctorList.get(choice2).getDoctorPatientList().size(); i++) {
                            System.out.println(i + ". " + doctorList.get(choice2).getDoctorPatientList().get(i).getName());
                        }

                            System.out.println("----------------------------");
                            System.out.println("Выход из системы.");
                            System.out.println("----------------------------");

                            break;
}


            } else if (currentUser instanceof Doctor) {
                System.out.println("----------------------------");
                System.out.println("Выберите желаемое действие:");
                System.out.println("1. Посмотреть записи пациентов");
                System.out.println("2. Выйти из системы");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:

                        for (int i = 0; i < ((Doctor) currentUser).getDoctorPatientList().size(); i++) {
                            System.out.println(i + ". " + ((Doctor) currentUser).getDoctorPatientList().get(i).getName());
                        }

                        System.out.println("----------------------------");
                        System.out.println("Выход из системы.");
                        System.out.println("----------------------------");

                        break;
                    case 2:
                        System.out.println("----------------------------");
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
                            System.out.println(i+". "+ doctorList.get(i).getName()+". Специализация: " + doctorList.get(i).getSpecialisation());
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
                        System.out.println("----------------------------");
                        System.out.println("Выход из системы.");
                        System.out.println("----------------------------");
                        break;
                    case 2:
                        System.out.println("----------------------------");
                        System.out.println("Выход из системы.");
                        System.out.println("----------------------------");
                        break;

                }

            } else {
                System.out.println("----------------------------");
                System.out.println("Работа программы завершена");
                System.out.println("----------------------------");
                return;
            }

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













