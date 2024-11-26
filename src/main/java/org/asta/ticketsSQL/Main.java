package org.asta.ticketsSQL;

import org.asta.ticketsSQL.DAO.TicketDAOService;
import org.asta.ticketsSQL.DAO.UserDAOService;
import org.asta.ticketsSQL.model.Ticket;
import org.asta.ticketsSQL.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Asta
 */
public class Main {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5433/my_ticket_service_db";
        String user = "postgres";
        String password = "asta";

        try {
            UserDAOService userDAO = new UserDAOService(url, user, password);
            TicketDAOService ticketDAO = new TicketDAOService(url, user, password);

            // Save a new user
            userDAO.saveUser("Arseny");
            System.out.println("User saved");

            User fetchedUser = userDAO.fetchUserById(1);
            if (fetchedUser != null) {
                System.out.println("Fetched User: " + fetchedUser);
            } else {
                System.out.println("User not found.");
            }

            ticketDAO.saveTicket(1, "DAY");
            System.out.println("Ticket saved");

            Ticket fetchedTicket = ticketDAO.fetchTicketById(1);
            if (fetchedTicket != null) {
                System.out.println("Fetched Ticket: " + fetchedTicket);
            } else {
                System.out.println("Ticket not found");
            }

            List<Ticket> userTickets = ticketDAO.fetchTicketsByUserId(1);
            System.out.println("Tickets for user:");
            for (Ticket ticket : userTickets) {
                System.out.println(ticket);
            }

            ticketDAO.updateTicketType(1, "MONTH");
            System.out.println("Ticket update");

            Ticket updatedTicket = ticketDAO.fetchTicketById(1);
            System.out.println("Updated Ticket: " + updatedTicket);

            userDAO.deleteUserById(1);
            System.out.println("User deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}