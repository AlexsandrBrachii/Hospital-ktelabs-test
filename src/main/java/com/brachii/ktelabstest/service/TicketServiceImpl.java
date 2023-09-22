package com.brachii.ktelabstest.service;


import com.brachii.ktelabstest.model.Ticket;
import com.brachii.ktelabstest.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    // 2.3.1
    @Override
    public List<Ticket> getTicketsWithStatusTrue(Long doctorId, LocalDateTime date) {
        return ticketRepository.findTrueTicketsForDoctorAndDate(doctorId, date);
    }

    // 2.3.2
    @Override
    public void updateStatusTicketToFalse(Long ticketId) {
        ticketRepository.updateTicketStatusToFalse(ticketId);
        log.info("Status for ticket with id=" + ticketId + " update to false.");
    }

    // 2.3.2
    @Override
    public List<Ticket> getTicketsByPatientId(Long patientId) {
        return ticketRepository.findTicketsByPatientId(patientId);
    }
}
