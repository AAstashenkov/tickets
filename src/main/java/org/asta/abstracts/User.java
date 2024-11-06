package org.asta.abstracts;

/**
 * @author Asta
 */
public abstract class User extends Functional{

    public User() {
    }

    public User(String id) {
        super(id);
    }

    public void printRole() {
        System.out.println("Role: ");
    }
}
