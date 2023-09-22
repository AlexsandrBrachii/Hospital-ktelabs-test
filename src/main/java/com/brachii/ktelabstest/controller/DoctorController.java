package com.brachii.ktelabstest.controller;

import com.brachii.ktelabstest.dto.DoctorDto;
import com.brachii.ktelabstest.model.Doctor;
import com.brachii.ktelabstest.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorService.createDoctor(doctor);
    }

    @GetMapping("/{idDoctor}")
    public DoctorDto getDoctorById(@PathVariable Long idDoctor) {
        return doctorService.getDoctorById(idDoctor);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{idDoctor}")
    public void deleteDoctor(@PathVariable Long idDoctor) {
        doctorService.deleteDoctor(idDoctor);
    }
}
