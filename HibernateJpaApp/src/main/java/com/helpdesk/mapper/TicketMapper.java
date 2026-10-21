package com.helpdesk.mapper;

import com.helpdesk.dto.TicketResponseDto;
import com.helpdesk.model.Ticket;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;

public class TicketMapper {

    public static TicketResponseDto convertEntityIntoDto(Ticket ticket){
        return new TicketResponseDto(
                ticket.getId(),
                ticket.getSubject(),
                LocalDate.ofInstant(ticket.getCreatedAt() , ZoneOffset.UTC),
                ticket.getStatus(),
                ticket.getCustomer().getName(),
                ticket.getCustomer().getUser() == null?
                        null :
                        ticket.getCustomer().getUser().getUsername(),
                ticket.getExecutive() == null?
                        null:ticket.getExecutive().getId(),
                ticket.getExecutive() == null?
                        null : ticket.getExecutive().getJobTitle()
        );

    }
}
