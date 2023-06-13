package sistema.model.dao;

import sistema.controller.ControllerJobRole;
import sistema.controller.ControllerUser;
import sistema.helper.DateDB;
import sistema.helper.MySQLConnection;
import sistema.model.bean.*;
import sistema.model.bean.Employee;
import sistema.model.bean.JobRole;
import sistema.model.bean.User;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class DaoEmployee {

    private final Connection conn;
    private String date;

    public DaoEmployee() throws SQLException, ParseException {
        MySQLConnection helper = new MySQLConnection("clinic", "root", "root", "localhost");
        DateDB dateDB = new DateDB();
        this.conn = helper.getConnection();
        this.date = dateDB.getDate();
    }

    public List<Employee> all() {
        List<Employee> employees = new ArrayList<Employee>();

        try (Connection conn = this.conn) {
            String sql = "SELECT * FROM `employee`";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                int idUser = result.getInt("id_user");
                int idJobRole = result.getInt("id_job_role");
                String hiringDate = result.getString("hiring_date");
                Double wage = result.getDouble("wage");
                String creationDate = result.getString("creation_date");
                String updateDate = result.getString("update_date");

                User user = new ControllerUser().read(idUser);
                JobRole jobRole = new ControllerJobRole().read(idJobRole);
                employees.add(new Employee(id, hiringDate, wage, user, jobRole, creationDate, updateDate));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return employees;
    }

    public Employee create(Employee employee) {
        try (Connection conn = this.conn) {
            String sql = "INSERT INTO `employee` (id_user, id_job_role, hiring_date, wage, creation_date, update_date) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, employee.getUser().getIdUser());
            stmt.setInt(2, employee.getJobRole().getId());
            stmt.setString(3, employee.getHiringDate());
            stmt.setDouble(4, employee.getWage());
            stmt.setString(5, this.date);
            stmt.setString(6, this.date);

            stmt.execute();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    employee.setId(id);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        }

        return employee;
    }

    public Employee update(Employee employee) {
        try (Connection conn = this.conn) {
            String sql = "UPDATE `employee` SET id_user = ?, id_job_role = ?, hiring_date = ?, wage = ?, update_date = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, employee.getUser().getIdUser());
            stmt.setInt(2, employee.getJobRole().getId());
            stmt.setString(3, employee.getHiringDate());
            stmt.setDouble(4, employee.getWage());
            stmt.setString(5, this.date);
            stmt.setInt(6, employee.getId());

            int rowsAffected = stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating data: " + e.getMessage());
        }

        return employee;
    }

    public Employee read(int id) {
        Employee employee = null;

        try (Connection conn = this.conn) {
            String sql = "SELECT * FROM `employee` WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                int idUser = result.getInt("id_user");
                int idJobRole = result.getInt("id_job_role");
                String hiringDate = result.getString("hiring_date");
                Double wage = result.getDouble("wage");
                String creationDate = result.getString("creation_date");
                String updateDate = result.getString("update_date");

                User user = new ControllerUser().read(idUser);
                JobRole jobRole = new ControllerJobRole().read(idJobRole);
                employee = new Employee(id, hiringDate, wage, user, jobRole, creationDate, updateDate);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return employee;
    }

    public int delete(int id) {
        int rowsAffected = 0;

        try (Connection conn = this.conn) {
            String sql = "DELETE FROM `employee` WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            rowsAffected = stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error deleting data: " + e.getMessage());
        }

        return rowsAffected;
    }

    public List<Employee> search(String search) {
        List<Employee> employees = new ArrayList<Employee>();

        try (Connection conn = this.conn) {
            String sql = "SELECT * FROM `employee` WHERE name LIKE ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + search + "%");

            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                int idUser = result.getInt("id_user");
                int idJobRole = result.getInt("id_job_role");
                String hiringDate = result.getString("hiring_date");
                Double wage = result.getDouble("wage");
                String creationDate = result.getString("creation_date");
                String updateDate = result.getString("update_date");

                User user = new ControllerUser().read(idUser);
                JobRole jobRole = new ControllerJobRole().read(idJobRole);
                employees.add(new Employee(id, hiringDate, wage, user, jobRole, creationDate, updateDate));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return employees;
    }
}
