package Model.Service;

import Model.DTO.DoctorDTO;
import Model.Entity.Doctor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.Random;

public class DoctorService {

    private static final Pattern DUI_PATTERN = Pattern.compile("^\\d{8}-\\d$");
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private static final String[] SPECIALITIES = {"Pediatria", "Cardiologia", "Dermatologia", "Ginecologia", "Psiquiatria"};


    public Doctor createDoctor(DoctorDTO doctorDTO){
        return new Doctor(
                doctorDTO.getName(),
                doctorDTO.getLastName(),
                doctorDTO.getDUI(),
                doctorDTO.getBirthday(),
                doctorDTO.getSpeciality(),
                doctorDTO.getDateOfRecruitment(),
                doctorDTO.getEmployeeCode()
        );
    }

    public List<DoctorDTO> convertToDto(List<Doctor> doctorList){
        return doctorList.stream()
                .map(doctor -> new DoctorDTO(
                        doctor.getName(),
                        doctor.getLastName(),
                        doctor.getDUI(),
                        doctor.getBirthday(),
                        doctor.getSpeciality(),
                        doctor.getDateOfRecruitment(),
                        doctor.getEmployeeCode()
                )).collect(Collectors.toList());
    }

    public void showDoctors(List<Doctor> doctorList){
        List<DoctorDTO> doctorDTOS = convertToDto(doctorList);
        doctorDTOS.forEach(doctorItem ->{
            System.out.println("Nombre: " + doctorItem.getName());
            System.out.println("Apellido: " + doctorItem.getLastName());
            System.out.println("DUI: " + doctorItem.getDUI());
            System.out.println("Cumpleaños: " + doctorItem.getBirthday());
            System.out.println("Especialidad: " + doctorItem.getSpeciality());
            System.out.println("Fecha de reclutamiento: " + doctorItem.getDateOfRecruitment());
            System.out.println("Codigo de empleado: " + doctorItem.getEmployeeCode());
        });
    }

    public Doctor createAndShowDoctor() {
        Scanner scanner = new Scanner(System.in);
        String name = "", lastName = "", dui = "", birthdayStr, speciality = "", dateOfRecruitmentStr;
        Date birthday = null, dateOfRecruitment = null;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Ingrese los datos del doctor:");
            name = getValidName(scanner, "Nombre: ");
            lastName = getValidName(scanner, "Apellido: ");
            dui = getValidDui(scanner, "DUI: ");
            birthday = getValidBirthday(scanner, "Cumpleaños (dd/MM/yyyy): ");
            speciality = getValidSpeciality(scanner);
            dateOfRecruitment = getValidBirthday(scanner, "Fecha de reclutamiento (dd/MM/yyyy): ");

            validInput = true;
        }


        String employeeCode = generateEmployeeCode();
        DoctorDTO doctorDTO = new DoctorDTO(
                name,
                lastName,
                dui,
                birthday,
                speciality,
                dateOfRecruitment,
                employeeCode
        );
        Doctor doctor = createDoctor(doctorDTO);
        List<Doctor> doctorList = List.of(doctor);
        showDoctors(doctorList);
        return doctor;
    }

    private static String generateEmployeeCode() {
        Random random = new Random();
        int digit1 = random.nextInt(10);
        char letter1 = (char) ('A' + random.nextInt(26));
        int digit2 = random.nextInt(10);
        char letter2 = (char) ('A' + random.nextInt(26));
        int digit3 = random.nextInt(10);

        return String.format("ZNH-%d%c%d-MD-%c%d", digit1, letter1, digit2, letter2, digit3);
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

    private String getValidDui(Scanner scanner, String prompt){
        String dui;
        while(true){
            System.out.print(prompt);
            dui = scanner.nextLine();
            if(DUI_PATTERN.matcher(dui).matches()){
                break;
            }else{
                System.out.println("DUI invalido, por favor ingrese un DUI valido.");
            }
        }
        return dui;
    }

    private Date getValidBirthday(Scanner scanner, String prompt){
        Date birthday = null;
        while(true){
            System.out.print(prompt);
            String birthdayStr = scanner.nextLine();
            try {
                birthday = DATE_FORMAT.parse(birthdayStr);
                if(birthday.after(new Date())){
                    System.out.println("La fecha no puede ser mayor a la fecha de ahora.");
                }else{
                    break;
                }
            } catch (ParseException e) {
                System.out.println("Fecha invalida, por favor ingrese una fecha valida.");
            }
        }
        return birthday;
    }

    private String getValidSpeciality(Scanner scanner){
        String speciality;
        while(true){
            System.out.print("Especialidad (opciones: Pediatria, Cardiologia, Dermatologia, Ginecologia, Psiquiatria): ");
            speciality = scanner.nextLine();
            for(String validspeciality : SPECIALITIES){
                if(validspeciality.equalsIgnoreCase(speciality) ){
                    return validspeciality;
                }
            }
            System.out.println("Especialidad invalida, por favor ingrese una especialidad valida.");
        }

    }

}
