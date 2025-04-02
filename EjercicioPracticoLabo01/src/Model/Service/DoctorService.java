package Model.Service;

import Model.DTO.DoctorDTO;
import Model.Entity.Doctor;

public class DoctorService {
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
}
