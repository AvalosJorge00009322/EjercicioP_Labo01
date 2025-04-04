package Model.Service;

import Model.Entity.Appoiment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public void updateAppointmentStatus(Scanner scanner) {
        if (appoiments.isEmpty()) {
            System.out.println("No hay citas registradas.");
            return;
        }

        for (int i = 0; i < appoiments.size(); i++) {
            Appoiment a = appoiments.get(i);
            System.out.println((i + 1) + ". " +
                    a.getPatientName() + " con el Dr. " +
                    a.getDoctorName() + " | Fecha: " + a.getAppointmentDate());
        }

        System.out.print("Seleccione el número de la cita a actualizar: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        if (index < 1 || index > appoiments.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        Appoiment selected = appoiments.get(index - 1);

        System.out.print("¿El paciente asistió? (s/n): ");
        String input = scanner.nextLine().trim().toLowerCase();
        if (input.equals("s")) {
            selected.setAttendance(true);
            System.out.println("Cita actualizada como 'asistida'.");
        } else {
            selected.setAttendance(false);
            System.out.println("Se marcó como que el paciente no asistió.");
            System.out.print("¿Desea cancelar esta cita? (s/n): ");
            String cancelInput = scanner.nextLine().trim().toLowerCase();
            if (cancelInput.equals("s")) {
                appoiments.remove(selected);
                System.out.println("La cita ha sido cancelada.");
            }
        }
    }


}
