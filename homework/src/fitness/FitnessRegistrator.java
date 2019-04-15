package fitness;

import fitness.MyExceptions.QueueException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FitnessRegistrator {
    private List<Human> inGym = new ArrayList<>();
    private List<Human> inPool = new ArrayList<>();
    private List<Human> inGroup = new ArrayList<>();


    public void add(Human human, FitnessServiceEnumeration type) throws QueueException {
        if (FitnessServiceEnumeration.GYM.equals(type)) {
            if (checkSpace(inGym)) {
                inGym.add(human);
                FitnessLogger.printToFile(human, type);
            } else throw new QueueException();
        }
        if (FitnessServiceEnumeration.GROUP.equals(type)) {
            if (checkSpace(inGroup)) {
                inGroup.add(human);
                FitnessLogger.printToFile(human, type);
            } else throw new QueueException();
        }

        if (FitnessServiceEnumeration.POOL.equals(type)) {
            if (checkSpace(inPool)) {
                inPool.add(human);
                FitnessLogger.printToFile(human, type);
            } else throw new QueueException();
        }

    }

    public boolean checkSpace(List list) {
        if (list.size() > 20)
            return false;
        return true;

    }

    public void del(Human human) {
        if (inGym.contains(human))
            inGym.remove(human);
        if (inPool.contains(human))
            inPool.remove(human);
        if (inGroup.contains(human))
            inGroup.remove(human);
    }

    public void print() {

        Comparator<Human> comparator = new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {

                int result = o1.getSurname().compareTo(o2.getSurname());
                if (result == 0) {
                    result = o1.getName().compareTo(o2.getName());
                }
                return result;

            }
        };

        Collections.sort(inGym, comparator);
        Collections.sort(inPool, comparator);
        Collections.sort(inGroup, comparator);

        for (Human human : inGym) {
            System.out.println(human.getSurname() + " " + human.getName() + "    " + human.getClass().getSimpleName() + " - GYM");
        }

        for (Human human : inPool) {
            System.out.println(human.getSurname() + " " + human.getName() + "    " + human.getClass().getSimpleName() + " - GYM");
        }

        for (Human human : inGroup) {
            System.out.println(human.getSurname() + " " + human.getName() + "    " + human.getClass().getSimpleName() + " - GYM");
        }

    }


}
