package com.brachii.ktelabstest.controller;

import com.brachii.ktelabstest.dto.PatientDto;
import com.brachii.ktelabstest.model.Patient;
import com.brachii.ktelabstest.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }

    @GetMapping("/{idPatient}")
    public PatientDto getPatientById(@PathVariable Long idPatient) {
        return patientService.getPatientById(idPatient);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{idPatient}")
    public void deletePatient(@PathVariable Long idPatient) {
        patientService.deletePatient(idPatient);
    }
}
