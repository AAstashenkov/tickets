package org.asta.model;

import org.asta.abstracts.User;
import org.asta.enums.Role;

/**
 * @author Asta
 */
public class Client extends User {

    private Ticket ticket;
    private Role role;

    public Client() {
        this.role = Role.CLIENT;
    }

    public Client(String id) {
        super(id);
        this.role = Role.CLIENT;
    }

    public void getTicket(Ticket ticket) {
        this.ticket = ticket;
        System.out.println("Ticket: " + ticket);
    }

    @Override
    public void printRole() {
        System.out.println("Role of current user is: " + role);
    }
}
