package org.asta;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Asta
 */
public class TicketService {
    public static void main(String[] args) {

        Ticket emptyTicket = new Ticket();
        System.out.println("Empty: " + emptyTicket);

        Ticket limitedTicket = new Ticket("Stadium", 123, LocalDateTime.now());
        System.out.println("Limited: " + limitedTicket);

        Ticket ticket = new Ticket("1234", "Arena", 101, LocalDateTime.now(),
                true, 'B', 10.0, BigDecimal.valueOf(50.00));
        System.out.println("Full: " + ticket);
    }
}