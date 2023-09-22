package com.brachii.ktelabstest.service;

import com.brachii.ktelabstest.model.Ticket;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketService {

    List<Ticket> getTicketsWithStatusTrue(Long doctorId, LocalDateTime date);

    void updateStatusTicketToFalse(Long ticketId);

    List<Ticket> getTicketsByPatientId(Long patientId);
}

