package org.asta.ticketsSQL.DAO;

import org.asta.ticketsSQL.model.Ticket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Asta
 */
public class TicketDAOService {

    private Connection connection;

    public TicketDAOService(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    public void saveTicket(int userId, String ticketType) throws SQLException {
        String sql = "INSERT INTO ticket (user_id, ticket_type) VALUES (?, CAST(? AS ticket_type))";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.setString(2, ticketType);
            pstmt.executeUpdate();
        }
    }

    public Ticket fetchTicketById(int id) throws SQLException {
        String sql = "SELECT * FROM ticket WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Ticket(rs.getInt("id"), rs.getInt("user_id"),
                        rs.getString("ticket_type"), rs.getTimestamp("creation_date"));
            }
        }
        return null;
    }

    public List<Ticket> fetchTicketsByUserId(int userId) throws SQLException {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT * FROM ticket WHERE user_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                tickets.add(new Ticket(rs.getInt("id"), rs.getInt("user_id"),
                        rs.getString("ticket_type"), rs.getTimestamp("creation_date")));
            }
        }
        return tickets;
    }

    public void updateTicketType(int ticketId, String newType) throws SQLException {
        String sql = "UPDATE ticket SET ticket_type = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(2, ticketId);
            pstmt.executeUpdate();
        }
    }
}