package Model.Entity;

import java.util.Date;

public class Person {
    private String name;
    private String lastName;
    private String DUI;
    private Date birthday;

    public Person(String name, String lastName, String dui, Date birthday) {
        this.name = name;
        this.lastName = lastName;
        this.DUI = dui;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDUI() {
        return DUI;
    }

    public void setDUI(String DUI) {
        this.DUI = DUI;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
