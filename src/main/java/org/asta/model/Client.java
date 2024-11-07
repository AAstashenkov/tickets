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

    public Ticket getTicket(Ticket ticket) {
        return ticket;
    }

    @Override
    public void printRole() {
        System.out.println("Role of current user is: " + role);
    }
}
