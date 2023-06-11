import Task1.NestedPerson;
import Task1.Person;
import Task2.FireHero;
import Task2.WaterHero;

public class Main {

    public static void main(String[] args) {

        Person person = new Person("Mario","Husar",21, "Povazany", 413);
        NestedPerson nestedPerson = new NestedPerson("Mario","Husar",21, "Povazany", 413);


        WaterHero waterHero = new WaterHero();
        FireHero fireHero = new FireHero();

        waterHero.attack();
        fireHero.defense();
        waterHero.skipTurn();
    }
}
