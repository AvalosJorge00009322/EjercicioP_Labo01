package Model.Service;

import Model.Entity.Patient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PatientService {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private Scanner scanner = new Scanner(System.in);
    private PatientRegisterSystem patientRegisterSystem = new PatientRegisterSystem();

    public Patient createAndShowPatient() {
        System.out.println("Ingrese los datos del paciente:");
        String name = getValidInput("Nombre: ");
        String lastName = getValidInput("Apellido: ");
        String dui = getValidInput("DUI: ");
        Date birthday = getValidDate("Cumpleaños (dd/MM/yyyy): ");

        boolean added = patientRegisterSystem.addPatient(name, lastName, dui, birthday);
        if (added) {
            Patient patient = new Patient(name, lastName, dui, birthday);
            showPatient(patient);
            return patient;
        } else {
            return null;
        }

    }

    private String getValidInput(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Campo requerido. Intente de nuevo.");
        }
    }

    private Date getValidDate(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                Date date = dateFormat.parse(input);
                if (date.after(new Date())) {
                    System.out.println("La fecha no puede ser futura.");
                } else {
                    return date;
                }
            } catch (ParseException e) {
                System.out.println("Formato inválido. Intente con dd/MM/yyyy.");
            }
        }
    }

    public void showPatient(Patient patient) {
        System.out.println("\nPaciente registrado:");
        System.out.println("Nombre: " + patient.getName());
        System.out.println("Apellido: " + patient.getLastName());
        System.out.println("DUI: " + patient.getDUI());
        System.out.println("Cumpleaños: " + dateFormat.format(patient.getBirthday()));
    }

}
