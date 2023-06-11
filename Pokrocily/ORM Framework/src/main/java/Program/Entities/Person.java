package Program.Entities;

import Anotations.ID;
import Anotations.Table;
import Anotations.Bar;

@Table("Person")
public class Person {
    @ID
    @Bar("ID")
    private Long id;

    @Bar("Name")
    private String name;

    @Bar("Surname")
    private String surname;

    @Bar("Age")
    private Integer age;

    @Bar("Address")
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
