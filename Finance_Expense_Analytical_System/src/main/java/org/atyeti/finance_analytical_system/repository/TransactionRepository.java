package org.atyeti.finance_analytical_system.repository;
import org.atyeti.finance_analytical_system.exception.FinancialException;
import org.atyeti.finance_analytical_system.model.Transaction;
import org.atyeti.finance_analytical_system.util.DatabaseManager;
import java.sql.*;
import java.util.*;

public class TransactionRepository {

    private Connection conn = DatabaseManager.getInstance().getConnection();

    public void addTransaction(Transaction t) {
        String sql = "INSERT INTO transactions (user_id, amount, category, date) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, t.getUserId());
            ps.setDouble(2, t.getAmount());
            ps.setString(3, t.getCategory());
            ps.setDate(4, java.sql.Date.valueOf(t.getDate()));
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Transaction> getAllTransactions(int userId) {
        List<Transaction> list = new ArrayList<>();
        String sql = "SELECT * FROM transactions WHERE user_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Transaction t = new Transaction();
                t.setId(rs.getInt("id"));
                t.setUserId(rs.getInt("user_id"));
                t.setAmount(rs.getDouble("amount"));
                t.setCategory(rs.getString("category"));
                t.setDate(rs.getDate("date").toLocalDate());
                list.add(t);
            }
        } catch (SQLException e) {
            throw new FinancialException("Error while saving transaction", e);
        }

        return list;
    }
}