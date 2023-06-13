package sistema.model.dao;

import sistema.controller.ControllerPerson;
import sistema.helper.DateDB;
import sistema.helper.MySQLConnection;
import sistema.model.bean.Person;
import sistema.model.bean.User;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class DaoUser {

    private final Connection conn;
    private String date;

    public DaoUser() throws SQLException, ParseException {
        MySQLConnection helper = new MySQLConnection("clinic", "root", "root", "localhost");
        DateDB date = new DateDB();
        this.conn = helper.getConnection();
        this.date = date.getDate();
    }

    public List<User> all() {
        List<User> users = new ArrayList<User>();

        try (Connection conn = this.conn) {
            String sql = "SELECT * FROM `user`";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                int resultID = result.getInt("id");
                int resultIDPerson = result.getInt("id_person");
                String resultUsername = result.getString("username");
                String resultEmail = result.getString("email");
                String resultEmailRecovery = result.getString("email_recovery");
                String resultPassword = result.getString("password");
                String resultDateCreation = result.getString("data_criacao");
                String resultDateUpdate = result.getString("data_edicao");

                Person person = new ControllerPerson().read(resultIDPerson);
                users.add(new User(resultID, resultUsername, resultEmail, resultEmailRecovery, resultPassword, person, resultDateCreation, resultDateUpdate));
            }
        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    public User create(User user) {
        try (Connection conn = this.conn) {
            String sql = "INSERT INTO `user` (id_person, username, email, email_recovery, password, creation_date, update_date) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, user.getPerson().getIdPerson());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getEmailRecovery());
            stmt.setString(5, user.getPassword());
            stmt.setString(6, this.date);
            stmt.setString(7, this.date);
            stmt.execute();


            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    user.setIdUser(id);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        }

        return user;
    }

    public User update(User user) {
        try (Connection conn = this.conn) {
            String sql = "UPDATE `user` SET username = ?, email = ?, email_recovery = ?, password = ?, update_date = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getEmailRecovery());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, this.date);
            stmt.setInt(6, user.getIdUser());

            int rowsAffected = stmt.executeUpdate();
            // System.out.println(rowsAffected + " row(s) inserted");
        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        }

        return user;
    }

    public User read(int id) {
        User user = null;

        try (Connection conn = this.conn) {
            String sql = "SELECT * FROM `user ` WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,  id);

            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                int resultID = result.getInt("id");
                int resultIDPerson = result.getInt("id_person");
                String resultUsername = result.getString("username");
                String resultEmail = result.getString("email");
                String resultEmailRecovery = result.getString("email_recovery");
                String resultPassword = result.getString("password");
                String resultDateCreation = result.getString("creation_date");
                String resultDateUpdate = result.getString("update_date");

                Person person = new ControllerPerson().read(resultIDPerson);
                user = new User(resultID, resultUsername, resultEmail, resultEmailRecovery, resultPassword, person, resultDateCreation, resultDateUpdate);
            }
        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return user;
    }

    public int delete(int id) {
        int rowsAffected = 0;

        try (Connection conn = this.conn) {
            String sql = "DELETE FROM `user` WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,  id);

            rowsAffected = stmt.executeUpdate();
            return rowsAffected;
        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        }
        return rowsAffected;
    }

    public List<User> search (String search) {
        List<User> users = new ArrayList<User>();

        try (Connection conn = this.conn) {
            String sql = "SELECT * FROM `user` WHERE username LIKE ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + search + "%");

            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                int resultID = result.getInt("id");
                int resultIDPerson = result.getInt("id_person");
                String resultUsername = result.getString("username");
                String resultEmail = result.getString("email");
                String resultEmailRecovery = result.getString("email_recovery");
                String resultPassword = result.getString("password");
                String resultDateCreation = result.getString("creation_date");
                String resultDateUpdate = result.getString("update_date");

                Person person = new ControllerPerson().read(resultIDPerson);
                users.add(new User(resultID, resultUsername, resultEmail, resultEmailRecovery, resultPassword, person, resultDateCreation, resultDateUpdate));
            }
        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return users;
    }
}
