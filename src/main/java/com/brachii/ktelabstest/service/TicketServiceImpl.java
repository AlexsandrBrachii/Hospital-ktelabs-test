package com.brachii.ktelabstest.service;


import com.brachii.ktelabstest.exception.EmptyValueException;
import com.brachii.ktelabstest.exception.NotFoundException;
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
    private final DoctorService doctorService;
    private final PatientService patientService;

    // 2.3.1
    @Override
    public List<Ticket> getTicketsWithStatusTrue(Long doctorId, LocalDateTime date) {
        if (date == null) {
            throw new EmptyValueException("Date cannot be null");
        }

        doctorService.getDoctorById(doctorId);
        return ticketRepository.findTrueTicketsForDoctorAndDate(doctorId, date);
    }

    // 2.3.2
    @Override
    public void updateStatusTicketToFalse(Long ticketId) {
        if (ticketId == null) {
            throw new EmptyValueException("Id cannot be null");
        }

        if (ticketRepository.findById(ticketId).isEmpty()) {
            throw new NotFoundException("Ticket with id=" + ticketId + " not found.");
        }

        ticketRepository.updateTicketStatusToFalse(ticketId);
        log.info("Status for ticket with id=" + ticketId + " update to false.");
    }

    // 2.3.2
    @Override
    public List<Ticket> getTicketsByPatientId(Long patientId) {
        if (patientId == null) {
            throw new EmptyValueException("Id cannot be null");
        }

        patientService.getPatientById(patientId);
        return ticketRepository.findTicketsByPatientId(patientId);
    }
}
