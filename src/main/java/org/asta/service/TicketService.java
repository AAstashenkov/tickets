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

    public Map<String, Ticket> ticketsStorage;

    public TicketService() {
        this.ticketsStorage = new HashMap<>();
    }

    public Ticket findById(String idTicket) {
        if (ticketsStorage.containsKey(idTicket)) {
            return ticketsStorage.get(idTicket);
        } else {
            throw new IllegalArgumentException("No ticket with id " + idTicket);
        }
    }
}