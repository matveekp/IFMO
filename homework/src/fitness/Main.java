package fitness;

public class Main {
    public static void main(String[] args) {


        Human client1 = new Client("Nikol", "Ozerans", 1900);
        Human client2 = new Client("Jimmy", "Tudeski", 1900);
        Human client3 = new DayClient("Yanni", "Gogolak", 1900);
        Human client4 = new FullDateClient("Frank", "Figuero", 1901);
        FitnessRegistrator fitnessRegistrator = new FitnessRegistrator();

        try {
        fitnessRegistrator.add(client1, FitnessServiceEnumeration.GYM);
        fitnessRegistrator.add(client2, FitnessServiceEnumeration.GYM);
        fitnessRegistrator.add(client3, FitnessServiceEnumeration.GYM);
        fitnessRegistrator.add(client4, FitnessServiceEnumeration.GYM);
        fitnessRegistrator.print();
        fitnessRegistrator.add(client1, FitnessServiceEnumeration.POOL);
        fitnessRegistrator.add(client2, FitnessServiceEnumeration.POOL);
        fitnessRegistrator.add(client3, FitnessServiceEnumeration.POOL);
        fitnessRegistrator.add(client4, FitnessServiceEnumeration.POOL);
        fitnessRegistrator.print();
        fitnessRegistrator.add(client1, FitnessServiceEnumeration.GROUP);
        fitnessRegistrator.add(client2, FitnessServiceEnumeration.GROUP);
        fitnessRegistrator.add(client3, FitnessServiceEnumeration.GROUP);
        fitnessRegistrator.add(client4, FitnessServiceEnumeration.GROUP);
        fitnessRegistrator.print();

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}



