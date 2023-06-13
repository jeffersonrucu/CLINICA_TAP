package sistema.model.dao;

import sistema.helper.DateDB;
import sistema.helper.MySQLConnection;
import sistema.model.bean.JobRole;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class DaoJobRole {

    private final Connection conn;
    private String date;

    public DaoJobRole() throws SQLException, ParseException {
        MySQLConnection helper = new MySQLConnection("clinic", "root", "root", "localhost");
        DateDB dateDB = new DateDB();
        this.conn = helper.getConnection();
        this.date = dateDB.getDate();
    }

    public List<JobRole> all() {
        List<JobRole> jobRoles = new ArrayList<>();

        try (Connection conn = this.conn) {
            String sql = "SELECT * FROM `job_role`";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String nameJob = result.getString("name_job");
                int permission = result.getInt("permission");
                String creationDate = result.getString("creation_date");
                String updateDate = result.getString("update_date");

                jobRoles.add(new JobRole(id, nameJob, permission, creationDate, updateDate));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        }

        return jobRoles;
    }

    public JobRole create(JobRole jobRole) {
        try (Connection conn = this.conn) {
            String sql = "INSERT INTO `job_role` (name_job, permission, creation_date, update_date) VALUES (?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, jobRole.getNameJob());
            stmt.setInt(2, jobRole.getPermission());
            stmt.setString(3, this.date);
            stmt.setString(4, this.date);

            int rowsAffected = stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    jobRole.setId(id);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        }

        return jobRole;
    }

    public JobRole update(JobRole jobRole) {
        try (Connection conn = this.conn) {
            String sql = "UPDATE `type_person` SET name_job = ?, permission = ?, update_date = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, jobRole.getNameJob());
            stmt.setInt(2, jobRole.getPermission());
            stmt.setString(3, this.date);
            stmt.setInt(4, jobRole.getId());

            int rowsAffected = stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating data: " + e.getMessage());
        }

        return jobRole;
    }

    public JobRole read(int id) {
        JobRole jobRole = null;

        try (Connection conn = this.conn) {
            String sql = "SELECT * FROM `job_role` WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                String nameJob = result.getString("name_job");
                int permission = result.getInt("permission");
                String creationDate = result.getString("creation_date");
                String updateDate = result.getString("update_date");

                jobRole = new JobRole(id, nameJob, permission, creationDate, updateDate);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        }

        return jobRole;
    }

    public int delete(int id) {
        int rowsAffected = 0;

        try (Connection conn = this.conn) {
            String sql = "DELETE FROM `job_role` WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            rowsAffected = stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error deleting data: " + e.getMessage());
        }

        return rowsAffected;
    }

    public List<JobRole> search(String search) {
        List<JobRole> jobRoles = new ArrayList<JobRole>();

        try (Connection conn = this.conn) {
            String sql = "SELECT * FROM `job_role` WHERE name_job LIKE ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + search + "%");

            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String nameJob = result.getString("name_job");
                int permission = result.getInt("permission");
                String creationDate = result.getString("creation_date");
                String updateDate = result.getString("update_date");

                jobRoles.add(new JobRole(id, nameJob, permission, creationDate, updateDate));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        }

        return jobRoles;
    }
}
