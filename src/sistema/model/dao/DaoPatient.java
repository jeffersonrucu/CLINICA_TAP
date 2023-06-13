package sistema.model.dao;

import sistema.controller.ControllerUser;
import sistema.helper.DateDB;
import sistema.helper.MySQLConnection;
import sistema.model.bean.Patient;
import sistema.model.bean.User;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class DaoPatient {
    private final Connection conn;
    private String date;

    public DaoPatient() throws SQLException, ParseException {
        MySQLConnection helper = new MySQLConnection("clinic", "root", "root", "localhost");
        DateDB dateDB = new DateDB();
        this.conn = helper.getConnection();
        this.date = dateDB.getDate();
    }

    public List<Patient> all() {
        List<Patient> patients = new ArrayList<>();

        try (Connection conn = this.conn) {
            String sql = "SELECT * FROM `patient`";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                int idUser = result.getInt("id_user");
                String healthInsurance = result.getString("health_insurance");
                String creationDate = result.getString("creation_date");
                String updateDate = result.getString("update_date");

                User user = new ControllerUser().read(idUser);
                patients.add(new Patient(id, healthInsurance, user , creationDate, updateDate));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return patients;
    }

    public Patient create(Patient patient) {
        try (Connection conn = this.conn) {
            String sql = "INSERT INTO `patient` (id_user, health_insurance , creation_date, update_date) VALUES (?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, patient.getUser().getIdUser());
            stmt.setString(2, patient.getHealthInsurance());
            stmt.setString(3, this.date);
            stmt.setString(4, this.date);

            int rowsAffected = stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    patient.setId(id);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        }

        return patient;
    }

    public Patient update(Patient patient) {
        try (Connection conn = this.conn) {
            String sql = "UPDATE `patient` SET id_user = ?, health_insurance = ?, update_date = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, patient.getUser().getIdUser());
            stmt.setString(2, patient.getHealthInsurance());
            stmt.setString(3, this.date);
            stmt.setInt(4, patient.getId());

            int rowsAffected = stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating data: " + e.getMessage());
        }

        return patient;
    }

    public Patient read(int id) {
        Patient patient = null;

        try (Connection conn = this.conn) {
            String sql = "SELECT * FROM `patient` WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                int idUser = result.getInt("id_user");
                String healthInsurance = result.getString("health_insurance");
                String creationDate = result.getString("creation_date");
                String updateDate = result.getString("update_date");

                User user = new ControllerUser().read(idUser);
                patient = new Patient(id, healthInsurance, user , creationDate, updateDate);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return patient;
    }

    public int delete(int id) {
        int rowsAffected = 0;

        try (Connection conn = this.conn) {
            String sql = "DELETE FROM `patient` WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            rowsAffected = stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error deleting data: " + e.getMessage());
        }

        return rowsAffected;
    }

    public List<Patient> search(String search) {
        List<Patient> patients = new ArrayList<Patient>();

        try (Connection conn = this.conn) {
            String sql = "SELECT * FROM `patient` WHERE name LIKE ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + search + "%");

            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                int idUser = result.getInt("id_user");
                String healthInsurance = result.getString("health_insurance");
                String creationDate = result.getString("creation_date");
                String updateDate = result.getString("update_date");

                User user = new ControllerUser().read(idUser);
                patients.add(new Patient(id, healthInsurance, user , creationDate, updateDate));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return patients;
    }
}
