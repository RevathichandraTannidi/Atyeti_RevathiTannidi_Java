package com.parking.system.service;

import com.parking.system.dto.TicketDto;
import com.parking.system.exception.ResourceNotFoundException;
import com.parking.system.model.ParkingSlot;

public interface SlotManaging {

    ParkingSlot allocateSlot(TicketDto ticketDTO) throws ResourceNotFoundException;
    void releaseSlot(Long slotId) throws ResourceNotFoundException;

}
