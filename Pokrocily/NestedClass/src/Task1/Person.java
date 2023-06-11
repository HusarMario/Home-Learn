package Task1;

import Task1.Adress;

public class Person {
    private String name;
    private String surname;
    private int age;
    private Adress adress;

    public Person(String name, String surname, int age, String city, int houseNumber) {
        this.name = name;
        this.surname = surname;
        this.age = age;

        this.adress = new Adress(city,houseNumber);
    }
}
