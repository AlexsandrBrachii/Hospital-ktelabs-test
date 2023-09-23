package com.brachii.ktelabstest.dto;

import com.brachii.ktelabstest.model.Doctor;
import com.brachii.ktelabstest.model.Patient;

public class MyMapper {

    public static DoctorDto doctorToDoctorDto(Doctor doctor) {
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setIdDoctor(doctor.getIdDoctor());
        doctorDto.setFullNameDoctor(doctor.getFullNameDoctor());
        doctorDto.setSpecialty(doctor.getSpecialty());
        return doctorDto;
    }

    public static PatientDto patientToPatientDto(Patient patient) {
        PatientDto patientDto = new PatientDto();
        patientDto.setIdPatient(patient.getIdPatient());
        patientDto.setFullNamePatient(patient.getFullNamePatient());
        patientDto.setBirthDate(patient.getBirthDate());
        return patientDto;
    }
}


