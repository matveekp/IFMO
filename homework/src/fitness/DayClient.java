package fitness;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AccessMode(gym = "16", group = "16", pool = "0")
public class DayClient extends Human {

    private String endOfReg;
    private Access group = new Access(8, 16, FitnessServiceEnumeration.GROUP);
    private Access gym = new Access(8, 16, FitnessServiceEnumeration.GYM);

    public String getEndOfReg() {
        return endOfReg;
    }

    public void setEndOfReg(String endOfReg) {
        this.endOfReg = endOfReg;
    }

    public Access getGroup() {
        return group;
    }

    public void setGroup(Access group) {
        this.group = group;
    }




    public DayClient(String name, String surname, int bYear) {
        super(name, surname, bYear);
        this.endOfReg = LocalDateTime.now().plusMonths(12).toString();

    }

    public DayClient(String name, String surname, int bYear, String regDate, int endOfReg) {
        super(name, surname, bYear, regDate);
        //TODO: подсчет даты окончания регистраии отдельным методом
        this.endOfReg = LocalDateTime.now().plusMonths(endOfReg).toString();
    }
}
