package com.brachii.ktelabstest.service;

import com.brachii.ktelabstest.dto.DoctorDto;
import com.brachii.ktelabstest.model.Doctor;
import com.brachii.ktelabstest.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static com.brachii.ktelabstest.dto.MyMapper.doctorToDoctorDto;

@RequiredArgsConstructor
@Slf4j
@Service
public class DoctorServiceImpl implements DoctorService {


    private final DoctorRepository doctorRepository;


    @Override
    public Doctor createDoctor(Doctor doctor) {
        UUID uuidNew = UUID.randomUUID();
        doctor.setUuidDoctor(uuidNew);
        Doctor newDoctor = doctorRepository.save(doctor);
        log.info("Doctor created with id=" + doctor.getIdDoctor());
        return newDoctor;
    }

    @Override
    public DoctorDto getDoctorById(Long doctorId) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorId);

        if (doctorOptional.isEmpty())  {
            log.info("Doctor with id=" + doctorId + " not found.");
            return null;
        }

        Doctor doctor = doctorOptional.get();
        DoctorDto dto = doctorToDoctorDto(doctor);
        log.info("Return Doctor with id=" + dto.getIdDoctor());
        return dto;
    }

    @Override
    public void deleteDoctor(Long doctorId) {
        doctorRepository.deleteById(doctorId);
        log.info("Doctor with id=" + doctorId + " deleted.");
    }
}
