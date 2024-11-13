package org.asta.model;

import org.asta.abstracts.User;
import org.asta.enums.Role;

import java.util.Random;

/**
 * @author Asta
 */
public class Admin extends User {

    private Role role;

    public Admin() {
        this.role = Role.ADMIN;
    }

    public Admin(String id) {
        super(id);
        this.role = Role.ADMIN;
    }

    public void checkTicket(Ticket ticket) {
        System.out.println("Checked by Admin");
    }

    @Override
    public void printRole(){
        System.out.println("Role of current user is: " + role);
    }
}
