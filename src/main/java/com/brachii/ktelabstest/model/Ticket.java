package com.brachii.ktelabstest.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket")
    private Long idTicket;

    @Column(name = "id_d")
    private Long doctorId;

    @Column(name = "id_p")
    private Long patientId;

    @Column(name = "duration_t")
    private Integer duration;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "status")
    private Boolean status;
}
