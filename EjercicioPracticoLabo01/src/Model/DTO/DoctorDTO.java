package Model.DTO;

import java.util.Date;

public class DoctorDTO {
    private String name;
    private String lastName;
    private String DUI;
    private Date birthday;
    private String speciality;
    private Date dateOfRecruitment;
    private String employeeCode;

    public DoctorDTO(String name, String lastName, String dui, Date birthday, String speciality, Date dateOfRecruitment, String employeeCode) {
        this.name = name;
        this.lastName = lastName;
        this.DUI = dui;
        this.birthday = birthday;
        this.speciality = speciality;
        this.dateOfRecruitment = dateOfRecruitment;
        this.employeeCode = employeeCode;
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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String specialty) {
        this.speciality = specialty;
    }

    public Date getDateOfRecruitment() {
        return dateOfRecruitment;
    }

    public void setDateOfRecruitment(Date dateOfRecruitment) {
        this.dateOfRecruitment = dateOfRecruitment;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }
}
