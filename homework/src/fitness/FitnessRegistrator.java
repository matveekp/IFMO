package fitness;

import java.util.ArrayList;

public class FitnessRegistrator {
    private ArrayList<Human> inGym = new ArrayList<>();
    private ArrayList<Human> inPool = new ArrayList<>();
    private ArrayList<Human> inGroup = new ArrayList<>();

    //поменять листы на treeset or hashset for comparator

    public void add(Human human, FitnessServiceEnumeration type){
        if (FitnessServiceEnumeration.GYM.equals(type)) {
            //проверки отдельными методами

        }
    }



}
