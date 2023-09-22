package com.brachii.ktelabstest.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PatientDto {


    private Long idPatient;

    private String fullNamePatient;

    private Date birthDate;
}
