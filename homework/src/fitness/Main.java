package fitness;

import fitness.MyExceptions.NoAccessException;
import fitness.MyExceptions.QueueException;

public class Main {
    public static void main(String[] args) {


        Human client1 = new Client("Nikol", "Ozerans", 1980);
        Human client2 = new DayClient("Jimmy", "Tudeski", 1995);
        Human client3 = new FullDateClient("Yanni", "Gogolak", 1976);

        Human client4 = new FullDateClient("Frank", "Figuero", 1979);
        Human client5 = new DayClient("Bobby", "Bobovsk", 1976);
        Human client6 = new FullDateClient("Johny", "Jonhsky", 1979);



        FitnessRegistrator fitnessRegistrator = new FitnessRegistrator();

        try {
//            fitnessRegistrator.add(client1, FitnessServiceEnumeration.GROUP);
//            fitnessRegistrator.add(client2, FitnessServiceEnumeration.GYM);
//            fitnessRegistrator.add(client2, FitnessServiceEnumeration.POOL);
//            fitnessRegistrator.add(client2, FitnessServiceEnumeration.GROUP);

            fitnessRegistrator.add(client1, FitnessServiceEnumeration.GYM);
            fitnessRegistrator.add(client3, FitnessServiceEnumeration.GYM);
            fitnessRegistrator.add(client4, FitnessServiceEnumeration.GYM);

            fitnessRegistrator.print();
            System.out.println("-----------------------");

            fitnessRegistrator.add(client1, FitnessServiceEnumeration.POOL);
            fitnessRegistrator.add(client3, FitnessServiceEnumeration.POOL);
            fitnessRegistrator.add(client4, FitnessServiceEnumeration.GROUP);

            fitnessRegistrator.print();
            System.out.println("-----------------------");


            fitnessRegistrator.add(client4, FitnessServiceEnumeration.POOL);
            fitnessRegistrator.add(client3, FitnessServiceEnumeration.GROUP);
            fitnessRegistrator.print();

        } catch (NoAccessException | QueueException e) {
            e.printStackTrace();
        }

    }
}



