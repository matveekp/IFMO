package multithreading.port;

import java.util.ArrayList;
import java.util.List;

public class Port {
    private List<Dock> dockList = new ArrayList<>();

    public Dock getFreeDock(){
        for (Dock dock : dockList) {
            if (dock.isFree())
                return dock;
        }

       return getFreeDock();
    }

    public void addDock(Dock dock){
        if (!dockList.contains(dock))
            dockList.add(dock);
        else System.out.println("В порту уже числится этот док ");
    }



}
