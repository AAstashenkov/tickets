package org.asta;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * @author Asta
 */
public class TicketService {

    private static HashMap<String, Ticket> ticketsStorage;

    public TicketService() {
        this.ticketsStorage = new HashMap<>();
    }

    public static void main(String[] args) {

        Ticket ticket1 = new Ticket("1", "Arena1", 101, LocalDateTime.now(),
                true, 'C', 10.0, BigDecimal.valueOf(55.00));
        Ticket ticket2 = new Ticket("2", "Arena2", 102, LocalDateTime.now(),
                true, 'B', 10.0, BigDecimal.valueOf(54.00));
        Ticket ticket3 = new Ticket("3", "Arena3", 103, LocalDateTime.now(),
                true, 'A', 10.0, BigDecimal.valueOf(52.00));
        Ticket ticket4 = new Ticket("4", "Arena4", 104, LocalDateTime.now(),
                true, 'B', 10.0, BigDecimal.valueOf(77.00));
        Ticket ticket5 = new Ticket("5", "Arena5", 105, LocalDateTime.now(),
                true, 'B', 10.0, BigDecimal.valueOf(88.80));
        Ticket ticket6 = new Ticket("6", "Arena6", 106, LocalDateTime.now(),
                true, 'B', 10.0, BigDecimal.valueOf(78.90));
        Ticket ticket7 = new Ticket("7", "Arena7", 808, LocalDateTime.now(),
                true, 'A', 10.0, BigDecimal.valueOf(45.70));
        Ticket ticket8 = new Ticket("8", "Arena8", 809, LocalDateTime.now(),
                true, 'B', 10.0, BigDecimal.valueOf(50.60));
        Ticket ticket9 = new Ticket("9", "Arena9", 888, LocalDateTime.now(),
                true, 'B', 10.0, BigDecimal.valueOf(53.00));
        Ticket ticket10 = new Ticket("10", "Arena10", 999, LocalDateTime.now(),
                true, 'C', 10.0, BigDecimal.valueOf(545.00));


        ticketsStorage.put(ticket1.getId(), ticket1);
        ticketsStorage.put(ticket2.getId(), ticket2);
        ticketsStorage.put(ticket3.getId(), ticket3);
        ticketsStorage.put(ticket4.getId(), ticket4);
        ticketsStorage.put(ticket5.getId(), ticket5);
        ticketsStorage.put(ticket6.getId(), ticket6);
        ticketsStorage.put(ticket7.getId(), ticket7);
        ticketsStorage.put(ticket8.getId(), ticket8);
        ticketsStorage.put(ticket9.getId(), ticket9);
        ticketsStorage.put(ticket10.getId(), ticket10);

    }

    public Ticket findById(String idTicket) {
        if (ticketsStorage.containsKey(idTicket)) {
            return ticketsStorage.get(idTicket);
        } else {
            throw new IllegalArgumentException("No ticket with id " + idTicket);
        }
    }
}
