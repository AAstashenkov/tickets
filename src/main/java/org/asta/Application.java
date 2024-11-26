package org.asta;

import org.asta.arrayList.ArrayList;
import org.asta.hashSet.HashSet;
import org.asta.model.Admin;
import org.asta.model.Client;
import org.asta.model.Ticket;
import org.asta.service.TicketService;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Asta
 */
public class Application {

    private static ArrayList arrayList = new ArrayList();
    private static TicketService ticketService = new TicketService();
    private static Client client = new Client();
    private static Admin admin = new Admin();

    public static void main(String[] args) {

        admin.printRole();
        client.printRole();

        Ticket ticket1 = new Ticket("1234", "Arena", 101, LocalDateTime.now(),
                true, 'B', 10.0, BigDecimal.valueOf(50.00));
        Ticket ticket2 = new Ticket("7777", "Arena1", 333, LocalDateTime.now(),
                true, 'A', 12.0, BigDecimal.valueOf(77.12));

        ticketService.ticketsStorage.put(ticket1.getId(), ticket1);
        ticketService.ticketsStorage.put(ticket2.getId(), ticket2);

        ticket1.shared("google@gmail.com");
        ticket1.shared(1238888888);

        System.out.println(client.getTicket(ticket2));
        admin.checkTicket(ticket1);

        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println("ArrayList: ");
        arrayList.put("One");
        arrayList.put("Two");
        arrayList.put("Three");

        showArrayList(arrayList);

        arrayList.delete(1);
        System.out.println("ArrayList: ");
        showArrayList(arrayList);

        System.out.println("Get by index: " + arrayList.getByIndex(2));

        System.out.println("HashSet:");
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);

        System.out.println("HashSet");
        hashSet.display();

    }


    public static void showArrayList(ArrayList<String> arrayList) {
        for (int i = 0; i < arrayList.getSize(); i++) {
            System.out.println(arrayList.getByIndex(i));
        }
    }
}
