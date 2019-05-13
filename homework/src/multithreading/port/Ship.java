package multithreading.port;

public class Ship {



    private int maxWeight;
    private int currentWeight;
    private String name;

    public Ship(int maxWeight, int currentWeight, String name) {
        this.maxWeight = maxWeight;
        this.currentWeight = currentWeight;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean hasCargo() {
        return currentWeight > 0;
    }

    public boolean hasFreeSpace() {
        return currentWeight < maxWeight;
    }

    public void addCargo(int wight){
        currentWeight += wight;
    }

    public void getCargo(int weight){
        currentWeight -= weight;
    }

    public boolean isEmpty() {
        return currentWeight <= 0;
    }


}
