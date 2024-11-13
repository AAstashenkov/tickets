package org.asta;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.asta.model.BusTicket;
import org.asta.validator.Validator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Asta
 */
public class Application {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/tickets.txt"));
        BusTicket ticket;
        Validator validator = new Validator();
        ObjectMapper mapper = new ObjectMapper();
        String input;
        while ((input = reader.readLine()) != null) {
            ticket = mapper.readValue(input, BusTicket.class);
            System.out.println(ticket.toString());
            System.out.println(validator.validateBusTicket(ticket));
        }
        validator.getPopularViolation();

    }

}