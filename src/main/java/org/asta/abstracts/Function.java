package org.asta.abstracts;

/**
 * @author Asta
 */
public abstract class Function {

    private String id;

    public Function() {
    }
    public Function(String id) {
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
