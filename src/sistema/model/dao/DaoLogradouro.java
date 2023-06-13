package sistema.model.dao;

import sistema.helper.DateDB;
import sistema.helper.MySQLConnection;
import sistema.model.bean.Logradouro;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class DaoLogradouro {

    private final Connection conn;
    private String date;

    public DaoLogradouro() throws SQLException, ParseException {
        MySQLConnection helper = new MySQLConnection("clinic", "root", "root", "localhost");
        DateDB dateDB = new DateDB();
        this.conn = helper.getConnection();
        this.date = dateDB.getDate();
    }

    public List<Logradouro> all() {
        List<Logradouro> logradouros = new ArrayList<Logradouro>();

        try (Connection conn = this.conn) {
            String sql = "SELECT * FROM `logradouro`";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String streetName = result.getString("street_name");
                String zipCode = result.getString("zip_code");
                int number = result.getInt("number");
                String neighborhood = result.getString("neighborhood");
                String city = result.getString("city");
                String state = result.getString("state");
                String country = result.getString("country");
                String creationDate = result.getString("creation_date");
                String updateDate = result.getString("update_date");

                logradouros.add(new Logradouro(id, streetName, zipCode, number, neighborhood, city, state, country, creationDate, updateDate));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        }

        return logradouros;
    }

    public Logradouro create(Logradouro logradouro) {
        try (Connection conn = this.conn) {
            String sql = "INSERT INTO `logradouro` (street_name, zip_code, number, neighborhood, city, state, country, creation_date, update_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, logradouro.getStreetNome());
            stmt.setString(2, logradouro.getZipCode());
            stmt.setInt(3, logradouro.getNumber());
            stmt.setString(4, logradouro.getNeighborhood());
            stmt.setString(5, logradouro.getCity());
            stmt.setString(6, logradouro.getState());
            stmt.setString(7, logradouro.getCountry());
            stmt.setString(8, this.date);
            stmt.setString(9, this.date);
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    logradouro.setId(id);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        }

        return logradouro;
    }

    public Logradouro update(Logradouro logradouro) {
        try (Connection conn = this.conn) {
            String sql = "UPDATE `person` SET street_name = ?, zip_code = ?, number = ?, neighborhood = ?, city = ?, state = ?, country = ?, update_date = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, logradouro.getStreetNome());
            stmt.setString(2, logradouro.getZipCode());
            stmt.setInt(3, logradouro.getNumber());
            stmt.setString(4, logradouro.getNeighborhood());
            stmt.setString(5, logradouro.getCity());
            stmt.setString(6, logradouro.getState());
            stmt.setString(7, logradouro.getCountry());
            stmt.setString(8, this.date);
            stmt.setInt(9, logradouro.getId());

            int rowsAffected = stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating data: " + e.getMessage());
        }

        return logradouro;
    }

    public Logradouro read(int id) {
        Logradouro logradouro = null;

        try (Connection conn = this.conn) {
            String sql = "SELECT * FROM `logradouro` WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                String streetName = result.getString("street_name");
                String zipCode = result.getString("zip_code");
                int number = result.getInt("number");
                String neighborhood = result.getString("neighborhood");
                String city = result.getString("city");
                String state = result.getString("state");
                String country = result.getString("country");
                String creationDate = result.getString("creation_date");
                String updateDate = result.getString("update_date");

                logradouro = new Logradouro(id, streetName, zipCode, number, neighborhood, city, state, country, creationDate, updateDate);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        }

        return logradouro;
    }

    public int delete(int id) {
        int rowsAffected = 0;

        try (Connection conn = this.conn) {
            String sql = "DELETE FROM `logradouro` WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            rowsAffected = stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error deleting data: " + e.getMessage());
        }

        return rowsAffected;
    }

    public List<Logradouro> search(String search) {
        List<Logradouro> logradouros = new ArrayList<Logradouro>();

        try (Connection conn = this.conn) {
            String sql = "SELECT * FROM `logradouro` WHERE name LIKE ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + search + "%");

            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                int id = result.getInt("id_type");
                String streetName = result.getString("street_name");
                String zipCode = result.getString("zip_code");
                int number = result.getInt("number");
                String neighborhood = result.getString("neighborhood");
                String city = result.getString("city");
                String state = result.getString("state");
                String country = result.getString("country");
                String creationDate = result.getString("creation_date");
                String updateDate = result.getString("update_date");

                logradouros.add(new Logradouro(id, streetName, zipCode, number, neighborhood, city, state, country, creationDate, updateDate));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        }

        return logradouros;
    }
}
