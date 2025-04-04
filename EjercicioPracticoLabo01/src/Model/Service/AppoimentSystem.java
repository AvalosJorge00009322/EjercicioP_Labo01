package Model.Service;

import Model.Entity.Appoiment;

import java.util.ArrayList;
import java.util.List;

public class AppoimentSystem {

    private List<Appoiment> appoiments = new ArrayList<>();

    public List<Appoiment> readAppoiments(){
        if (appoiments.isEmpty()) {
            System.out.println("No Appoiments.");
            return null;
        }

        System.out.println("Appoiments:");
        for (Appoiment appoiment : appoiments) {
            System.out.println("Patient: " + appoiment.getPatientName());
            System.out.println("Doctor: " + appoiment.getDoctorName());
            System.out.println("Speciality: " + appoiment.getSpeciality());
            System.out.println("Date: " + appoiment.getAppointmentDate());
            System.out.println("------------------------------");

        }
        return null;
    }

    public List<Appoiment> getAppoiments() {
        return appoiments;
    }

}
