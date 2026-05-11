package org.atyeti.finance_analytical_system.repository;

import org.atyeti.finance_analytical_system.model.User;
import org.atyeti.finance_analytical_system.util.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepository {

    private Connection conn =
            DatabaseManager.getInstance().getConnection();

    // CHECK USER EXISTS
    public boolean userExists(int id) {

        String sql = "SELECT id FROM users WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // CREATE USER
    public void createUser(int id, String name,
                           double income, double budget) {

        String sql =
                "INSERT INTO users(id, name, income, monthly_budget) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, income);
            ps.setDouble(4, budget);

            ps.executeUpdate();

            System.out.println("User created successfully!");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // GET USER BY ID
    public User getUserById(int id) {

        String sql = "SELECT * FROM users WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                User u = new User();

                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setIncome(rs.getDouble("income"));
                u.setMonthlyBudget(rs.getDouble("monthly_budget"));

                return u;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    // UPDATE USER
    public void updateUser(User user) {

        String sql =
                "UPDATE users SET name=?, income=?, monthly_budget=? WHERE id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getName());
            ps.setDouble(2, user.getIncome());
            ps.setDouble(3, user.getMonthlyBudget());
            ps.setInt(4, user.getId());

            ps.executeUpdate();

            System.out.println("User updated successfully!");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // DELETE USER
    public void deleteUser(int id) {

        String sql = "DELETE FROM users WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("User deleted successfully!");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}