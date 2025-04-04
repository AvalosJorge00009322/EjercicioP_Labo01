package Model.Service;

import Model.Entity.Appoiment;

import java.util.List;

public class FindByCode {

    public void showAppoimentsByCode(List<Appoiment> appoiments, String doctorCode) {

        boolean found = false;

        for(Appoiment appoiment : appoiments) {
            if (appoiment.getEmployeeCode().equalsIgnoreCase(doctorCode)) {
                System.out.println("Patient: " + appoiment.getPatientName());
                System.out.println("Doctor: " + appoiment.getDoctorName());
                System.out.println("Speciality: " + appoiment.getSpeciality());
                System.out.println("Date: " + appoiment.getAppointmentDate());
                System.out.println("Asisitio:" + appoiment.getAttendance());
                System.out.println("------------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No se encontro el codigo.");
        }

    }
}
