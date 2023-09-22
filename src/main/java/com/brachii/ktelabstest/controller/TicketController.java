package com.brachii.ktelabstest.controller;

import com.brachii.ktelabstest.model.Ticket;
import com.brachii.ktelabstest.service.TicketService;
import com.brachii.ktelabstest.soap.TicketServiceSoap;
import com.brachii.ktelabstest.util.DateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;
    private final TicketServiceSoap ticketServiceSoap;

    @PostMapping
    public String createTicket(@RequestBody String xmlTicket) {
        return ticketServiceSoap.createTicket(xmlTicket);
    }

    @GetMapping("/{idDoctor}")
    public List<Ticket> getTicketsWithStatusTrue(@PathVariable Long idDoctor, @RequestBody DateRequest dateRequest) {
        LocalDateTime date = dateRequest.getDate();
        return ticketService.getTicketsWithStatusTrue(idDoctor, date);
    }

    @PatchMapping("/{idTicket}")
    public void updateStatusTicketToFalse(@PathVariable Long idTicket) {
        ticketService.updateStatusTicketToFalse(idTicket);
    }

    @GetMapping("/patient/{idPatient}")
    public List<Ticket> getTicketsByPatientId(@PathVariable Long idPatient) {
        return ticketService.getTicketsByPatientId(idPatient);
    }


}
