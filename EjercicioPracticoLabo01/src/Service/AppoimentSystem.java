package Service;

import Model.Entity.Appoiment;
import Model.Entity.Patient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppoimentSystem {

    private List<Appoiment> appoiments = new ArrayList<>();

    public void readAppoiments(){
        if (appoiments.isEmpty()) {
            System.out.println("No Appoiments.");
            return;
        }

        System.out.println("Appoiments:");
        for (Appoiment appoiment : appoiments) {
            System.out.println("Patient: " + appoiment.getPatient().getName() + " " + appoiment.getPatient().getLastName());
            System.out.println("Doctor: " + appoiment.getDoctor().getName() + " " + appoiment.getDoctor().getLastName());
            System.out.println("Speciality: " + appoiment.getSpeciality());
            System.out.println("Date: " + appoiment.getAppointmentDate());
            System.out.println("------------------------------");

        }
    }

}
