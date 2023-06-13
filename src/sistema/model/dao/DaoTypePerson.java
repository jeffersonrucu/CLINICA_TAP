package sistema.model.dao;

import sistema.helper.DateDB;
import sistema.helper.MySQLConnection;
import sistema.model.bean.TypePerson;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class DaoTypePerson {
    private final Connection conn;
    private String date;

    public DaoTypePerson() throws SQLException, ParseException {
        MySQLConnection helper = new MySQLConnection("clinic", "root", "root", "localhost");
        DateDB dateDB = new DateDB();
        this.conn = helper.getConnection();
        this.date = dateDB.getDate();
    }

    public List<TypePerson> all() {
        List<TypePerson> persons = new ArrayList<>();

        try (Connection conn = this.conn) {
            String sql = "SELECT * FROM `type_person`";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String cpf = result.getString("cpf");
                String cnpj = result.getString("cnpj");
                String creationDate = result.getString("creation_date");
                String updateDate = result.getString("update_date");

                persons.add(new TypePerson(id, cpf, cnpj, creationDate, updateDate));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        }

        return persons;
    }

    public TypePerson create(TypePerson typePerson) {
        try (Connection conn = this.conn) {
            String sql = "INSERT INTO `type_person` (cpf, cnpj, creation_date, update_date) VALUES (?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, typePerson.getCpf());
            stmt.setString(2, typePerson.getCnpj());
            stmt.setString(3, this.date);
            stmt.setString(4, this.date);

            int rowsAffected = stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    typePerson.setId(id);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        }

        return typePerson;
    }

    public TypePerson update(TypePerson typePerson) {
        try (Connection conn = this.conn) {
            String sql = "UPDATE `type_person` SET cpf = ?, cnpj = ?, update_date = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, typePerson.getCpf());
            stmt.setString(2, typePerson.getCnpj());
            stmt.setString(3, this.date);
            stmt.setInt(4, typePerson.getId());

            int rowsAffected = stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating data: " + e.getMessage());
        }

        return typePerson;
    }

    public TypePerson read(int id) {
        TypePerson typePerson = null;

        try (Connection conn = this.conn) {
            String sql = "SELECT * FROM `type_person` WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                String cpf = result.getString("cpf");
                String cnpj = result.getString("cnpj");
                String creationDate = result.getString("creation_date");
                String updateDate = result.getString("update_date");

                typePerson = new TypePerson(id, cpf, cnpj, creationDate, updateDate);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        }

        return typePerson;
    }

    public int delete(int id) {
        int rowsAffected = 0;

        try (Connection conn = this.conn) {
            String sql = "DELETE FROM `type_person` WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            rowsAffected = stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error deleting data: " + e.getMessage());
        }

        return rowsAffected;
    }

    public List<TypePerson> search(String search) {
        List<TypePerson> typePersons = new ArrayList<TypePerson>();

        try (Connection conn = this.conn) {
            String sql = "SELECT * FROM `person` WHERE name LIKE ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + search + "%");

            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                int id = result.getInt("id_type");
                String cpf = result.getString("cpf");
                String cnpj = result.getString("cnpj");
                String creationDate = result.getString("creation_date");
                String updateDate = result.getString("update_date");

                typePersons.add(new TypePerson(id, cpf, cnpj, creationDate, updateDate));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        }

        return typePersons;
    }
}
