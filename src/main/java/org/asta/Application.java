package org.asta;

import org.asta.model.Admin;
import org.asta.model.Client;
import org.asta.model.Ticket;
import org.asta.service.TicketService;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Asta
 */
public class Application {
    public static void main(String[] args) {
        TicketService ticketService = new TicketService();
        Client client = new Client();
        Admin admin = new Admin();

        admin.printRole();
        client.printRole();

        Ticket ticket = new Ticket("1234", "Arena", 101, LocalDateTime.now(),
                true, 'B', 10.0, BigDecimal.valueOf(50.00));
        Ticket ticket2 = new Ticket("7777", "Arena1", 333, LocalDateTime.now(),
                true, 'A', 12.0, BigDecimal.valueOf(77.12));

        ticketService.ticketsStorage.put(ticket.getId(), ticket);
        ticketService.ticketsStorage.put(ticket2.getId(), ticket2);

        ticket.shared("google@gmail.com");
        ticket.shared(1238888888);

        System.out.println(client.getTicket(ticket2));
        admin.checkTicket(ticket);
    }
}
