package Model.DTO;

import java.util.Date;

public class AppoimentDTO {
    private String patientName;
    private String doctorName;
    private String employeeCode;
    private String speciality;
    private Date appointmentDate;
    private Boolean attendance;

    public AppoimentDTO(String patientName, String doctorName, String speciality, Date appointmentDate, Boolean attendance, String employeeCode) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.speciality = speciality;
        this.appointmentDate = appointmentDate;
        this.attendance = attendance;
        this.employeeCode = employeeCode;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Boolean getAttendance() {
        return attendance;
    }

    public void setAttendance(Boolean attendance) {
        this.attendance = attendance;
    }
}
