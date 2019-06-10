import java.util.Objects;

public class Unit {

    private int health;
    private int attack;

    public Unit(int health, int attack) throws Exception {
        if (health <1  || attack < 1) {
            throw new Exception("Данные должны быть полодительными!");
        }
        this.health = health;
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public void addHealth(int health){
        this.health += health;
    }

    public void minusHealth(int health){
        this.health -= health;
    }

    public void attack(Unit enemy){
        enemy.minusHealth(this.attack);
    }

    @Override
    public String toString() {
        return "Unit{" +
                "health=" + health +
                ", attack=" + attack +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return health == unit.health &&
                attack == unit.attack;
    }

    @Override
    public int hashCode() {
        return Objects.hash(health, attack);
    }
}
