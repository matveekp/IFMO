package multithreading.port;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Port {
    private List<Dock> dockList = new ArrayList<>();
    private static final Logger LOGGER = Logger.getLogger(MyThread.class);


    public Dock getFreeDock(){

        for (Dock dock : dockList) {
            if (dock.isFree())
                return dock;
            else return getFreeDock();
        }

       return getFreeDock();
    }

    public void addDock(Dock dock){
        if (!dockList.contains(dock))
            dockList.add(dock);
        else System.out.println("В порту уже числится этот док ");
    }



}
