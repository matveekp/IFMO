package lesson9;



public class TestSolarSystem{

    public static void main(String[] args) {

        for (PlanetsOfSolarSystem planet : PlanetsOfSolarSystem.values())
            System.out.println(planet);

    }
}


enum PlanetsOfSolarSystem {
    MERCURY("Меркурий", 3.303e+23, 2.4397e6, 58E10), VENUS("Венера", 4.869e+24, 6.0518e6, 108E10),
    EARTH("Земля", 5.976e+24, 6.37814e6, 150E10 ), MARS("Марс", 6.421e+23, 3.3972e6, 228E10 ),
    JUPITER("Юпитер", 1.9e+27,   7.1492e7,  778E10 ) , SATURN("Сатурн", 5.688e+26, 6.0268e7, 1429E10 ),
    URANUS("Уран", 8.686e+25, 2.5559e7,  2871E10), NEPTUNE("Нептун", 1.024e+26, 2.4746e7, 4504E10);


    private String name;
    private double weight;
    private double radius;
    private double orbitRadius;

    PlanetsOfSolarSystem(String name, double weight, double radius, double orbitRadius) {
        this.name = name;
        this.weight = weight;
        this.radius = radius;
        this.orbitRadius = orbitRadius;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getRadius() {
        return radius;
    }

    public double getOrbitRadius() {
        return orbitRadius;
    }


    @Override
    public String toString() {
        return "PlanetsOfSolarSystem{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", radius=" + radius +
                ", orbitRadius=" + orbitRadius +
                '}';
    }
}
