package org.asta.abstracts;

/**
 * @author Asta
 */
public abstract class Functional {

    private String id;

    public Functional() {
    }
    public Functional(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void print() {
        System.out.println("Print content in console");
    }
}
