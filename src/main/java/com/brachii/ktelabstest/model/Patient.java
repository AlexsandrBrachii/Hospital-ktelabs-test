package com.brachii.ktelabstest.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "patients")
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_patient")
    private Long idPatient;

    @Column(name = "uuid_patient")
    private UUID uuidPatient;

    @Column(name = "fullname_patient")
    private String fullNamePatient;

    @Column(name = "birthdate")
    private Date birthDate;
}
