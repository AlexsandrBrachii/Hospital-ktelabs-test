package com.brachii.ktelabstest.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface TicketServiceSoap {

    @WebMethod
    String createTicket(String ticketXml);
}