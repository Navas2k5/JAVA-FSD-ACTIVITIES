package com.helpdesk.main;

import com.helpdesk.config.AppConfig;
import com.helpdesk.dto.TicketResponseDto;
import com.helpdesk.enums.Priority;
import com.helpdesk.service.TicketService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class TicketController {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        TicketService ticketService = context.getBean(TicketService.class);

        /* Prepare input */
        String subject ="Internet shutdown";
        String issue="My wifi router is not working, the lights are off too";
        Priority priority = Priority.RED;
        int customerId = 1;

        //ticketService.insertTicket(customerId , subject, issue, priority);
        System.out.println("Ticket created...");


        List<TicketResponseDto> listDto = ticketService.fetchTicketInfo();
        listDto.forEach(System.out::println);
    }
}
