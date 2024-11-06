package org.asta.service;

import org.asta.model.Admin;
import org.asta.model.Client;
import org.asta.model.Ticket;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Asta
 */
public class TicketService {

    private Map<String, Ticket> ticketsStorage;

    public TicketService() {
        this.ticketsStorage = new HashMap<>();
    }

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

        ticket.shareByEmail("google@gmail.com");
        ticket.shareByPhone("+1238888888");

        client.getTicket(ticket);
        admin.checkTicket(ticket);
    }

    public Ticket findById(String idTicket) {
        if (ticketsStorage.containsKey(idTicket)) {
            return ticketsStorage.get(idTicket);
        } else {
            throw new IllegalArgumentException("No ticket with id " + idTicket);
        }
    }
}