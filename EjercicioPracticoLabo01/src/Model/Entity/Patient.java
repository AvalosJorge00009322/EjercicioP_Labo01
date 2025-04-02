package Model.Entity;

/*
 Para los pacientes se requieren: nombre, apellido, DUI - (menores 000000-0) ,cumpleaños
 */

import java.util.Date;

public class Patient extends Person{

    public Patient(String name, String lastName, String dui, Date birthday) {
        super(name, lastName, dui, birthday);
    }
}
