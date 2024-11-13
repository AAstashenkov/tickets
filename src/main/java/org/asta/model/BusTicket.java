package org.asta.model;

import java.util.Objects;

/**
 * @author Asta
 */
public class BusTicket {

    private String ticketClass;
    private String ticketType;
    private String startDate;
    private String price;

    public String getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(String ticketClass) {
        this.ticketClass = ticketClass;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusTicket busTicket = (BusTicket) o;
        return Objects.equals(ticketClass, busTicket.ticketClass) && Objects.equals(ticketType, busTicket.ticketType) && Objects.equals(startDate, busTicket.startDate) && Objects.equals(price, busTicket.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketClass, ticketType, startDate, price);
    }

    @Override
    public String toString() {
        return "BusTicket{" +
                "ticketClass='" + ticketClass + '\'' +
                ", ticketType='" + ticketType + '\'' +
                ", startDate='" + startDate + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
