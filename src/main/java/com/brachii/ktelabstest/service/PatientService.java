package com.brachii.ktelabstest.service;

import com.brachii.ktelabstest.dto.PatientDto;
import com.brachii.ktelabstest.model.Patient;

public interface PatientService {


    PatientDto getPatientById(Long patientId);

    Patient createPatient(Patient patient);

    void deletePatient(Long patientId);
}
