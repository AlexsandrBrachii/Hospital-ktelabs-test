package com.brachii.ktelabstest.soap;

import com.brachii.ktelabstest.model.Ticket;
import com.brachii.ktelabstest.repository.TicketRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@RequiredArgsConstructor
@Slf4j
@Service
@WebService(endpointInterface = "com.brachii.ktelabstest.soap.TicketServiceSoap")
public class TicketServiceSoapImpl implements TicketServiceSoap {

    private final TicketRepository ticketRepository;

    @Override
    @WebMethod
    public String createTicket(String ticketXml) {
        Ticket newTicket = null;

        try {
            ObjectMapper xmlMapper = new XmlMapper();
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode jsonNode = xmlMapper.readTree(ticketXml);
            objectMapper.registerModule(new JavaTimeModule());
            newTicket = objectMapper.treeToValue(jsonNode, Ticket.class);
        } catch (Exception e) {
            log.info("Exception in mapper.");
            e.printStackTrace();
        }

        ticketRepository.save(newTicket);
        log.info("Create ticket with id=" + newTicket.getIdTicket());

        return ticketXml;
    }
}