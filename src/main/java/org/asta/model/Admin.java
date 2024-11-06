package org.asta.model;

import org.asta.abstracts.User;
import org.asta.enums.Role;

import java.util.Random;

/**
 * @author Asta
 */
public class Admin extends User {

    private Role role;
    private static final Random random = new Random();

    public Admin() {
        this.role = Role.ADMIN;
    }

    public Admin(String id) {
        super(id);
        this.role = Role.ADMIN;
    }

    public void checkTicket(Ticket ticket) {
        String message = isTicketValid() ? "Good ticket!" : "Bad ticket!";
        System.out.println(message);
    }

    private boolean isTicketValid() {
        return random.nextBoolean();
    }

    @Override
    public void printRole(){
        System.out.println("Role of current user is: " + role);
    }
}
