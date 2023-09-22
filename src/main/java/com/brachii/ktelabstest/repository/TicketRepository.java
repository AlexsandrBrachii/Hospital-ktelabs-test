package com.brachii.ktelabstest.repository;

import com.brachii.ktelabstest.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // 2.3.1
    @Query("SELECT t FROM Ticket t WHERE t.doctorId = :doctorId AND t.startTime >= :dateNow AND t.status = true")
    List<Ticket> findTrueTicketsForDoctorAndDate(Long doctorId, LocalDateTime dateNow);

    // 2.3.2
    @Transactional
    @Modifying
    @Query("UPDATE Ticket t SET t.status = false WHERE t.idTicket = :ticketId")
    void updateTicketStatusToFalse(Long ticketId);

    // 2.3.3
    @Query("SELECT t FROM Ticket t WHERE t.patientId = :patientId")
    List<Ticket> findTicketsByPatientId(Long patientId);

}
