package Model.Entity;

import java.util.Date;

/**
 * Para los doctores se requieren: nombre, apellido, DUI, cumpleaños, especialidad, cuando fue reclutado
 * y codigo de empelado, el nombre, apellido, dui y cumpleaños son heredados de la clase Pacients
 *
 * */


public class Doctor extends Person {

    private String speciality;
    private Date dateOfRecruitment;
    private String employeeCode;

    public Doctor(String name, String lastName, String dui, Date birthday, String specialty, Date dateOfRecruitment, String employeeCode) {
        super(name, lastName, dui, birthday);

        this.speciality = specialty;
        this.dateOfRecruitment = dateOfRecruitment;
        this.employeeCode = employeeCode;
    }


    public String getSpeciality() {
        return speciality;
    }

    public Date getDateOfRecruitment() {
        return dateOfRecruitment;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }
}
