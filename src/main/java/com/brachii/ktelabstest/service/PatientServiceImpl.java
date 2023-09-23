package com.brachii.ktelabstest.service;

import com.brachii.ktelabstest.dto.PatientDto;
import com.brachii.ktelabstest.exception.EmptyValueException;
import com.brachii.ktelabstest.exception.NotFoundException;
import com.brachii.ktelabstest.model.Patient;
import com.brachii.ktelabstest.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static com.brachii.ktelabstest.dto.MyMapper.patientToPatientDto;

@RequiredArgsConstructor
@Slf4j
@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;


    @Override
    public Patient createPatient(Patient patient) {
        if (patient == null) {
            throw new EmptyValueException("Patient cannot be null");
        }

        UUID uuidNew = UUID.randomUUID();
        patient.setUuidPatient(uuidNew);
        Patient newPatient = patientRepository.save(patient);
        log.info("Patient created with id=" + patient.getIdPatient());
        return newPatient;
    }

    @Override
    public PatientDto getPatientById(Long patientId) {
        if (patientId == null) {
            throw new EmptyValueException("Id cannot be null");
        }

        Optional<Patient> patientOptional = patientRepository.findById(patientId);

        if (patientOptional.isEmpty()) {
            log.info("Patient with id=" + patientId + " not found.");
            throw new NotFoundException("Patient with id=" + patientId + " not found.");
        }

        Patient patient = patientOptional.get();
        PatientDto dto = patientToPatientDto(patient);
        log.info("Return patient with id=" + dto.getIdPatient());
        return dto;
    }

    @Override
    public void deletePatient(Long patientId) {
        if (patientId == null) {
            throw new EmptyValueException("Id cannot be null");
        }

        getPatientById(patientId);
        patientRepository.deleteById(patientId);
        log.info("Patient with id=" + patientId + " deleted.");
    }
}
