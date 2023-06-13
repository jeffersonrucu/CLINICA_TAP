package sistema.model.dao;

import sistema.controller.ControllerEmployee;
import sistema.controller.ControllerPatient;
import sistema.helper.DateDB;
import sistema.helper.MySQLConnection;
import sistema.model.bean.*;
import sistema.model.bean.ConsultationPatientEmployee;
import sistema.model.bean.Employee;
import sistema.model.bean.Patient;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class DaoConsultationPatientEmployee {

    private final Connection conn;
    private String date;

    public DaoConsultationPatientEmployee() throws SQLException, ParseException {
        MySQLConnection helper = new MySQLConnection("clinic", "root", "root", "localhost");
        DateDB dateDB = new DateDB();
        this.conn = helper.getConnection();
        this.date = dateDB.getDate();
    }

    public List<ConsultationPatientEmployee> all() {
        List<ConsultationPatientEmployee> consultationPatientEmployees = new ArrayList<ConsultationPatientEmployee>();

        try (Connection conn = this.conn) {
            String sql = "SELECT * FROM `consultation_patient_employee`";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                int idPatient = result.getInt("id_patient");
                int idEmployee = result.getInt("id_employee");
                String dateConsult = result.getString("date_consult");
                String description = result.getString("description");
                String creationDate = result.getString("creation_date");
                String updateDate = result.getString("update_date");

                Patient patient = new ControllerPatient().read(idPatient);
                Employee employee = new ControllerEmployee().read(idEmployee);
                consultationPatientEmployees.add(new ConsultationPatientEmployee(id, dateConsult, description, patient, employee, creationDate, updateDate));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return consultationPatientEmployees;
    }

    public ConsultationPatientEmployee create(ConsultationPatientEmployee consultationPatientEmployee) {
        try (Connection conn = this.conn) {
            String sql = "INSERT INTO `consultation_patient_employee` (date_consult, description, id_patient, id_employee, creation_date, update_date) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, consultationPatientEmployee.getDateConsult());
            stmt.setString(2, consultationPatientEmployee.getDescription());
            stmt.setInt(3, consultationPatientEmployee.getPatient().getId());
            stmt.setInt(4, consultationPatientEmployee.getEmployee().getId());
            stmt.setString(5, this.date);
            stmt.setString(6, this.date);

            stmt.execute();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    consultationPatientEmployee.setId(id);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        }

        return consultationPatientEmployee;
    }

    public ConsultationPatientEmployee update(ConsultationPatientEmployee consultationPatientEmployee) {
        try (Connection conn = this.conn) {
            String sql = "UPDATE `consultation_patient_employee` SET date_consult = ?, description = ?, id_patient = ?, id_employee = ?, update_date = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, consultationPatientEmployee.getDateConsult());
            stmt.setString(2, consultationPatientEmployee.getDescription());
            stmt.setInt(3, consultationPatientEmployee.getPatient().getId());
            stmt.setInt(4, consultationPatientEmployee.getEmployee().getId());
            stmt.setString(5, this.date);
            stmt.setInt(6, consultationPatientEmployee.getId());

            int rowsAffected = stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating data: " + e.getMessage());
        }

        return consultationPatientEmployee;
    }

    public ConsultationPatientEmployee read(int id) {
        ConsultationPatientEmployee consultationPatientEmployee = null;

        try (Connection conn = this.conn) {
            String sql = "SELECT * FROM `consultation_patient_employee` WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                int idPatient = result.getInt("id_patient");
                int idEmployee = result.getInt("id_employee");
                String dateConsult = result.getString("date_consult");
                String description = result.getString("description");
                String creationDate = result.getString("creation_date");
                String updateDate = result.getString("update_date");

                Patient patient = new ControllerPatient().read(idPatient);
                Employee employee = new ControllerEmployee().read(idEmployee);
                consultationPatientEmployee = new ConsultationPatientEmployee(id, dateConsult, description, patient, employee, creationDate, updateDate);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return consultationPatientEmployee;
    }

    public int delete(int id) {
        int rowsAffected = 0;

        try (Connection conn = this.conn) {
            String sql = "DELETE FROM `consultation_patient_employee` WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            rowsAffected = stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error deleting data: " + e.getMessage());
        }

        return rowsAffected;
    }

    public List<ConsultationPatientEmployee> search(String search) {
        List<ConsultationPatientEmployee> consultationPatientEmployees = new ArrayList<ConsultationPatientEmployee>();

        try (Connection conn = this.conn) {
            String sql = "SELECT * FROM `person` WHERE name LIKE ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + search + "%");

            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                int idPatient = result.getInt("id_patient");
                int idEmployee = result.getInt("id_employee");
                String dateConsult = result.getString("date_consult");
                String description = result.getString("description");
                String creationDate = result.getString("creation_date");
                String updateDate = result.getString("update_date");

                Patient patient = new ControllerPatient().read(idPatient);
                Employee employee = new ControllerEmployee().read(idEmployee);
                consultationPatientEmployees.add(new ConsultationPatientEmployee(id, dateConsult, description, patient, employee, creationDate, updateDate));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return consultationPatientEmployees;
    }
}
