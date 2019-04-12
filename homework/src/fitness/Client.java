package fitness;

import patterns.dicontainer.di.AutoRun;

@AccessMode(group = "0")
public class Client extends Human {

    private boolean isVisited;
    private Access gym = new Access(8, 22 ,FitnessServiceEnumeration.GYM);
    private Access pool = new Access(8, 22 ,FitnessServiceEnumeration.POOL);

    public Client(String name, String surname, int bYear) {
        super(name, surname, bYear);
    }

    public Client(String name, String surname, int bYear, String regDate) {
        super(name, surname, bYear, regDate);
    }
}
