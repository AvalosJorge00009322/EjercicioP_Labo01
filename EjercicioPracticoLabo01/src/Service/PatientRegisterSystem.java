package Service;

import Model.Entity.Appoiment;
import Model.Entity.Patient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientRegisterSystem {

    private List<Patient> patients = new ArrayList<>();

    public boolean addPatient(String name, String lastName, String dui, Date birthday) {
        for (Patient p : patients){
            if (p.getDUI().equals(dui)){
                System.out.println("Patient already exists");
                return false;
            }
        }

        Patient newPatient = new Patient(name, lastName, dui, birthday);
        patients.add(newPatient);
        System.out.println("Patient added");
        return true;
    }

}
