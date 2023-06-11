package Task1;

public class NestedPerson {
    private String name;
    private String surname;
    private int age;
    private NestedAdress nestedAdress;

    private class NestedAdress{
        private String city;
        private int houseNumber;

        public NestedAdress(String city, int houseNumber) {
            this.city = city;
            this.houseNumber = houseNumber;
        }
    }

    public NestedPerson(String name, String surname, int age, String city, int houseNumber) {
        this.name = name;
        this.surname = surname;
        this.age = age;

        this.nestedAdress = new NestedAdress(city,houseNumber);
    }
}
