package fitness;

import fitness.MyExceptions.NoAccessException;
import fitness.MyExceptions.QueueException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FitnessRegistrator {
    private List<Human> inGym = new ArrayList<>();
    private List<Human> inPool = new ArrayList<>();
    private List<Human> inGroup = new ArrayList<>();


    public void add(Human human, FitnessServiceEnumeration type) throws QueueException, NoAccessException {

        if (!checkAccess(human, type)) {
            String message = "Access denied";
            System.out.println(message);
            FitnessLogger.printToFile(human, type, message);
            throw new NoAccessException(message);
        }

        String message = "There are no free space in " + type.toString();

        if (FitnessServiceEnumeration.GYM.equals(type)) {
            if (!checkSpace(inGym)) {
                System.out.println(message);
                FitnessLogger.printToFile(human, type, message);
                throw new QueueException(message);
            }
            del(human);
            inGym.add(human);
            FitnessLogger.printToFile(human, type, LocalDateTime.now().toString());

        } else if (FitnessServiceEnumeration.POOL.equals(type)) {
            if (!checkSpace(inPool)) {
                System.out.println(message);
                FitnessLogger.printToFile(human, type, message);
                throw new QueueException(message);
            }
            del(human);
            inPool.add(human);
            FitnessLogger.printToFile(human, type, LocalDateTime.now().toString());

        } else if (FitnessServiceEnumeration.GROUP.equals(type)) {
            if (!checkSpace(inGroup)) {
                System.out.println(message);
                FitnessLogger.printToFile(human, type, message);
                throw new QueueException(message);
            }
            del(human);
            inGroup.add(human);
            FitnessLogger.printToFile(human, type, "access is allowed");
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

    public boolean checkAccess(Human human, FitnessServiceEnumeration type) {
        Class hClass = human.getClass();
        if (hClass.isAnnotationPresent(AccessMode.class)) {
            AccessMode accessMode = (AccessMode) hClass.getDeclaredAnnotation(AccessMode.class);

            if (FitnessServiceEnumeration.GYM.equals(type)) {
                if (Integer.parseInt(accessMode.gym()) > LocalDateTime.now().getHour()) return true;
            } else if (FitnessServiceEnumeration.POOL.equals(type)) {
                if (Integer.parseInt(accessMode.pool()) > LocalDateTime.now().getHour()) return true;
            } else if (FitnessServiceEnumeration.GROUP.equals(type)) {
                if (Integer.parseInt(accessMode.group()) > LocalDateTime.now().getHour()) return true;
            }


        }
        return false;
    }


    public void print() {

        Comparator<Human> comparator = new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        }.thenComparing(new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        Collections.sort(inGym, comparator);
        Collections.sort(inPool, comparator);
        Collections.sort(inGroup, comparator);

        for (Human human : inGym) {
            System.out.println(human.getSurname() + " " + human.getName() + "    " + human.getClass().getSimpleName() + " - GYM");
        }
        for (Human human : inPool) {
            System.out.println(human.getSurname() + " " + human.getName() + "    " + human.getClass().getSimpleName() + " - POOL");
        }
        for (Human human : inGroup) {
            System.out.println(human.getSurname() + " " + human.getName() + "    " + human.getClass().getSimpleName() + " - GROUP");
        }

    }


}
