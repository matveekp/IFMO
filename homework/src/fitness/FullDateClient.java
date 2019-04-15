package fitness;

@AccessMode
public class FullDateClient extends Human {

    private Access group = new Access(8, 22, FitnessServiceEnumeration.GROUP);
    private Access gym = new Access(8, 22, FitnessServiceEnumeration.GYM);
    private Access pool = new Access(8, 22, FitnessServiceEnumeration.POOL);


    public FullDateClient(String name, String surname, int bYear) {
        super(name, surname, bYear);
    }

    public FullDateClient(String name, String surname, int bYear, String regDate) {
        super(name, surname, bYear, regDate);
    }
}
