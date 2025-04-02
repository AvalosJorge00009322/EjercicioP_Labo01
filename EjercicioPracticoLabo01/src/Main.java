import Model.DTO.DoctorDTO;
import Model.Entity.Doctor;
import Model.Service.DoctorService;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        DoctorDTO doctorDTO = new DoctorDTO(
                "John",
                "Doe",
                "12345678-9",
                new java.util.Date(),
                "Cardiology",
                new java.util.Date(),
                "EMP001"
        );

        DoctorService doctorService = new DoctorService();
        Doctor doctor = doctorService.createDoctor(doctorDTO);

        List<Doctor> doctorList = List.of(doctor);
        List<DoctorDTO> doctorDTOS = doctorList.stream().map(doctorItem -> {
            return new DoctorDTO(
                    doctorItem.getName(),
                    doctorItem.getLastName(),
                    doctorItem.getDUI(),
                    doctorItem.getBirthday(),
                    doctorItem.getSpeciality(),
                    doctorItem.getDateOfRecruitment(),
                    doctorItem.getEmployeeCode()
            );
        }).toList();

        doctorDTOS.forEach(doctorItem -> {
            System.out.println(doctorItem.getName() + " " + doctorItem.getLastName() + " " + doctorItem.getDUI());
        });


    }
}