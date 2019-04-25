package multithreading.port;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

public class Port {

    List<SynchronousQueue<Ship>> list;
    List<Dock> dockList = new ArrayList<>();
    Dock dock;

    public Dock getFreeDock(){
        for (Dock dock : dockList) {

            if (dock.isFree())
                return dock;

        }
       getFreeDock();
       return dock;
    }

    public void addDock(Dock dock){
        dockList.add(dock);
    }



}
