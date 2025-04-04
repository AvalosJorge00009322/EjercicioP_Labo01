package Model.Service;


import Model.DTO.AppoimentDTO;
import Model.Entity.Appoiment;
import Model.Entity.Doctor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ReserveAppoiment {

    private List<Doctor> doctorList;

    public ReserveAppoiment(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }


    public Appoiment reserveAppoiment (AppoimentDTO appoimentDTO) {
        return new Appoiment(
                appoimentDTO.getPatientName(),
                appoimentDTO.getDoctorName(),
                appoimentDTO.getSpeciality(),
                appoimentDTO.getAppointmentDate(),
                appoimentDTO.getAttendance(),
                appoimentDTO.getEmployeeCode()
        );
    }


    public Appoiment createAndShowAppoiment(){
        Scanner scanner = new Scanner(System.in);
        String patientName = "", doctorName = "", employeeCode = "", speciality = "";
        Date appoimentDate = null;
        boolean validInput = false, attendance = true;

        while (!validInput){
            System.out.println("Ingrese los datos de la cita:");
            patientName = getValidName(scanner, "Nombre del paciente: ");
            doctorName = getValidName(scanner, "Nombre del doctor: ");
            appoimentDate = getValidDate(scanner, "Fecha de la cita (dd/MM/yyyy) HH:mm : ");
            speciality = getDoctorSpeciality(doctorName);
            employeeCode = getDoctorEmployeeCode(doctorName);
            validInput = true;
        }

        AppoimentDTO appoimentDTO = new AppoimentDTO(
                patientName,
                doctorName,
                speciality,
                appoimentDate,
                attendance,
                employeeCode
        );
        Appoiment appoiment = reserveAppoiment(appoimentDTO);
        System.out.println("Cita reservada:");
        System.out.println("Nombre del paciente: " + appoiment.getPatientName());
        System.out.println("Nombre del doctor: " + appoiment.getDoctorName());
        System.out.println("Fecha de la cita: " + appoiment.getAppointmentDate());
        System.out.println("Especialidad: " + appoiment.getSpeciality());
        System.out.println("Codigo de empleado: " + appoiment.getEmployeeCode());
        System.out.println("Asistencia: " + appoiment.getAttendance());
        return appoiment;
    }

    private String getValidDoctor(Scanner scanner, String prompt){
       String doctorName;
        while(true){
            System.out.print(prompt);
            doctorName = scanner.nextLine();
            final String finaldoctorName = doctorName;
            if(doctorList.stream().anyMatch(doctor -> doctor.getName().equalsIgnoreCase(finaldoctorName))){
                break;
            }else{
                System.out.println("Doctor no encontrado, por favor ingrese un nombre valido.");
            }
        }
        return doctorName;
    }


    private Date getValidDate(Scanner scanner, String prompt){
        Date date;
        while(true){
            System.out.print(prompt);
            String dateStr = scanner.nextLine();
            try {
                date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dateStr);
                Date now = new Date();
                if(date.before(now)){
                    System.out.println("La fecha no puede ser anterior a la fecha actual.");
                    continue;
                }else if(date.getHours() < 8 || date.getHours() > 16){
                    System.out.println("La cita solo puede ser entre las 8:00 y las 4 pm.");
                    continue;
                }else {
                    break;
                }
            } catch (ParseException e) {
                System.out.println("Fecha invalida, por favor ingrese una fecha valida.");
            }
        }
        return date;
    }

    private String getDoctorSpeciality(String doctorName){
        final String finalDoctorName = doctorName;
        return doctorList.stream()
                .filter(doctor -> doctor.getName().equalsIgnoreCase(finalDoctorName))
                .findFirst()
                .map(Doctor::getSpeciality)
                .orElse("");
    }

    private String getDoctorEmployeeCode(String doctorName){
        final String finalDoctorName = doctorName;
        return doctorList.stream()
                .filter(doctor -> doctor.getName().equalsIgnoreCase(finalDoctorName))
                .findFirst()
                .map(Doctor::getEmployeeCode)
                .orElse("");
    }

    private String getValidName(Scanner scanner, String prompt){
        String name;
        while(true){
            System.out.print(prompt);
            name = scanner.nextLine();
            if(!name.trim().isEmpty()){
                break;
            }else{
                System.out.println("Nombre invalido, por favor ingrese un nombre valido.");
            }
        }
        return name;
    }

}
