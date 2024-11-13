package org.asta.validator;

import org.asta.model.BusTicket;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Asta
 */
public class Validator {

    Map<String, Integer> violationsTypes = new HashMap<>();

    public final String PRICE_VIOLATION = "price";
    public final String START_DATE_VIOLATION = "startDate";
    public final String TICKET_TYPE_VIOLATION = "price";

    private int totalNumOfValidTickets;
    private int totalNumOfTickets;

    private void getViolations(String violationType) {
        violationsTypes.put(violationType, violationsTypes.getOrDefault(violationType, 0) + 1);
    }

    public boolean validateBusTicket(BusTicket busTicket) {

        boolean isTicketPriceValid = validateTicketPrice(busTicket);
        boolean isValidTicketType = validateTicketType(busTicket);
        boolean isValidStartDate = validateTicketDate(busTicket);

        if (isTicketPriceValid && isValidTicketType && isValidStartDate) {
            totalNumOfValidTickets++;
        }

        totalNumOfTickets++;
        return isTicketPriceValid && isValidTicketType && isValidStartDate;
    }

    public boolean validateTicketPrice(BusTicket ticket) {
        if (ticket.getPrice() == null) {
            getViolations(PRICE_VIOLATION);
            return false;
        } else if (Integer.parseInt(ticket.getPrice()) == 0) {
            getViolations(PRICE_VIOLATION);
            return false;
        } else if (Integer.parseInt(ticket.getPrice()) % 2 != 0) {
            getViolations(PRICE_VIOLATION);
            return false;
        }
        return true;
    }

    public boolean validateTicketType(BusTicket ticket) {
        if (ticket.getTicketType() == null) {
            getViolations(TICKET_TYPE_VIOLATION);
            return false;
        } else if (!Arrays.asList("DAY", "WEEK", "MONTH", "YEAR").contains(ticket.getTicketType())) {
            getViolations(TICKET_TYPE_VIOLATION);
            return false;
        } else if (ticket.getTicketType().isEmpty()) {
            getViolations(TICKET_TYPE_VIOLATION);
            return false;
        }
        return true;
    }

    public boolean validateTicketDate(BusTicket ticket) {
        if (ticket.getStartDate() == null) {
            getViolations(START_DATE_VIOLATION);
            return false;
        } else if (ticket.getStartDate().isEmpty()) {
            getViolations(START_DATE_VIOLATION);
            return false;
        } else if (LocalDate.parse(ticket.getStartDate()).isAfter(LocalDate.now())) {
            getViolations(START_DATE_VIOLATION);
            return false;
        }
        return true;
    }

    public void getPopularViolation() {

        int maxCount = 0;
        String maxViolations = " ";

        for (Map.Entry<String, Integer> popularViolations : violationsTypes.entrySet()) {
            if (maxCount < popularViolations.getValue()) {
                maxCount = popularViolations.getValue();
                maxViolations = popularViolations.getKey();
            }
        }

        System.out.println("Most popular violation = " + maxViolations +
                "\n Total: " + totalNumOfTickets +
                "\n Valid: " + totalNumOfValidTickets +
                "\n Types: " + violationsTypes.entrySet());
    }

}