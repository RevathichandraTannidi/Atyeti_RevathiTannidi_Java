package com.parking.system.service;

import com.parking.system.dto.TicketDto;
import com.parking.system.dto.TicketRequestDto;
import com.parking.system.exception.ResourceNotFoundException;
import com.parking.system.model.Ticket;

public interface TicketSer {

    Ticket createTicket(TicketRequestDto requestDTO) throws Exception;
    Ticket closeTicket(Long ticketId) throws ResourceNotFoundException;
    TicketDto getTicketDetails(Long id) throws ResourceNotFoundException;
}
