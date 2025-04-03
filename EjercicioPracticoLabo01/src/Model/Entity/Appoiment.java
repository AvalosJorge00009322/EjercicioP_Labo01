package Model.Entity;

import java.util.Date;

/**
 * Las citas deben contener: paciente, especialidad, fecha y hora exacta, especialidad, doctor
 *
 **/
public class Appoiment {
    private Patient patient;
    private Doctor doctor;
    private String speciality;
    private Date appointmentDate;
    private Boolean Attendance;

    public Appoiment(Patient patient, Doctor doctor, String specialty, Date appointmentDate, Boolean attendance) {
        this.patient = patient;
        this.doctor = doctor;
        this.speciality = specialty;
        this.appointmentDate = appointmentDate;
        this.Attendance = attendance;
    }

    public Boolean getAttendance() {
        return Attendance;
    }

    public void setAttendance(Boolean attendance) {
        Attendance = attendance;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
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
}
