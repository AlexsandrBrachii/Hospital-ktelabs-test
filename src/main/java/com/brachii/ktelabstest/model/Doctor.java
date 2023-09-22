package com.brachii.ktelabstest.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doctor")
    private Long idDoctor;

    @Column(name = "uuid_doctor")
    private UUID uuidDoctor;

    @Column(name = "fullname_doctor")
    private String fullNameDoctor;
}
