package com.brachii.ktelabstest.service;

import com.brachii.ktelabstest.dto.DoctorDto;
import com.brachii.ktelabstest.model.Doctor;

public interface DoctorService {

    Doctor createDoctor(Doctor doctor);

    void deleteDoctor(Long doctorId);

    DoctorDto getDoctorById(Long doctorId);
}
