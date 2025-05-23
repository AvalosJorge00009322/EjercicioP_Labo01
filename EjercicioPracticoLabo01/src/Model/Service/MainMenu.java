package Model.Service;



import Model.Entity.Doctor;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class MainMenu {
    private List<Doctor> doctorList = new ArrayList<>();
    private PatientService patientService = new PatientService();
    private AppoimentSystem appoimentSystem = new AppoimentSystem();
    private ReserveAppoiment reserveAppoiment = new ReserveAppoiment(doctorList, appoimentSystem);


    public void MainMenu (){
        Scanner scanner = new Scanner(System.in);
        DoctorService doctorService = new DoctorService();
        FindByCode findByCode = new FindByCode();
        int opcion = 0;

        do{
            System.out.println("Bienvenido al sistema de doctores");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Crear doctor");
            System.out.println("2. Mostrar doctores");
            System.out.println("3. Agregar pacientes");
            System.out.println("4. Agregar citas");
            System.out.println("5. Ver citas");
            System.out.println("6. Ver citas por codigo");
            System.out.println("7. Actualizar estado de cita");
            System.out.println("8. Boton extraño pero muy interesante");
            System.out.println("9. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    // Crear doctor
                   Doctor doctor = doctorService.createAndShowDoctor();
                    doctorList.add(doctor);
                    break;
                case 2:
                    doctorService.showDoctors(doctorList);
                    break;
                case 3:
                    patientService.createAndShowPatient();
                    break;
                case 4:
                    reserveAppoiment.createAndShowAppoiment();
                    break;
                case 5:
                    appoimentSystem.readAppoiments();
                    break;
                case 6:
                    System.out.println("Ingrese el código:");
                    String doctorCode = scanner.next();
                    findByCode.showAppoimentsByCode(appoimentSystem.getAppoiments(), doctorCode);
                    break;
                case 7:
                    System.out.println("Acutalizar estado:");
                    appoimentSystem.updateAppointmentStatus(scanner);
                    break;
                case 8:
                    // Salir
                    System.out.println("Explotando zaun....");
                    break;
                case 9:
                    // Salir
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }while(true);
    }
}
