package sistema.model.dao;

import sistema.controller.ControllerLogradouro;
import sistema.controller.ControllerTypePerson;
import sistema.helper.DateDB;
import sistema.helper.MySQLConnection;
import sistema.model.bean.Logradouro;
import sistema.model.bean.Person;
import sistema.model.bean.TypePerson;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class DaoPerson {
    private final Connection conn;
    private String date;

    public DaoPerson() throws SQLException, ParseException {
        MySQLConnection helper = new MySQLConnection("clinic", "root", "root", "localhost");
        DateDB dateDB = new DateDB();
        this.conn = helper.getConnection();
        this.date = dateDB.getDate();
    }

    public List<Person> all() {
        List<Person> persons = new ArrayList<Person>();

        try (Connection conn = this.conn) {
            String sql = "SELECT * FROM `person`";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                int idType = result.getInt("id_type");
                int idLogradouro = result.getInt("id_logradouro");
                String name = result.getString("name");
                String gender = result.getString("gender");
                String creationDate = result.getString("creation_date");
                String updateDate = result.getString("update_date");

                Logradouro logradouro = new ControllerLogradouro().read(idLogradouro);
                TypePerson typePerson = new ControllerTypePerson().read(idType);
                persons.add(new Person(id, name, gender, logradouro, typePerson, creationDate, updateDate));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return persons;
    }

    public Person create(Person person) {
        try (Connection conn = this.conn) {
            String sql = "INSERT INTO `person` (id_type, id_logradouro, name, gender, creation_date, update_date) VALUES (?, ?, ?, ?, ?, ?)";

            System.out.println(person.getTypePerson().getId());
            System.out.println(person.getLogradouro().getId());

            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, person.getTypePerson().getId());
            stmt.setInt(2, person.getLogradouro().getId());
            stmt.setString(3, person.getName());
            stmt.setString(4, person.getGender());
            stmt.setString(5, this.date);
            stmt.setString(6, this.date);

            stmt.execute();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    person.setIdPerson(id);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        }

        return person;
    }

    public Person update(Person person) {
        try (Connection conn = this.conn) {
            String sql = "UPDATE `person` SET id_type = ?, id_logradouro = ?, name = ?, gender = ?, update_date = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, person.getTypePerson().getId());
            stmt.setInt(2, person.getLogradouro().getId());
            stmt.setString(3, person.getName());
            stmt.setString(4, person.getGender());
            stmt.setString(5, this.date);
            stmt.setInt(6, person.getIdPerson());

            int rowsAffected = stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating data: " + e.getMessage());
        }

        return person;
    }

    public Person read(int id) {
        Person person = null;

        try (Connection conn = this.conn) {
            String sql = "SELECT * FROM `person` WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                int idTypePerson = result.getInt("id_type");
                int idLogradouro = result.getInt("id_logradouro");
                String name = result.getString("name");
                String gender = result.getString("gender");
                String creationDate = result.getString("creation_date");
                String updateDate = result.getString("update_date");

                Logradouro logradouro = new ControllerLogradouro().read(idLogradouro);
                TypePerson typePerson = new ControllerTypePerson().read(idTypePerson);
                person = new Person(id, name, gender, logradouro, typePerson, creationDate, updateDate);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return person;
    }

    public int delete(int id) {
        int rowsAffected = 0;

        try (Connection conn = this.conn) {
            String sql = "DELETE FROM `person` WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            rowsAffected = stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error deleting data: " + e.getMessage());
        }

        return rowsAffected;
    }

    public List<Person> search(String search) {
        List<Person> persons = new ArrayList<Person>();

        try (Connection conn = this.conn) {
            String sql = "SELECT * FROM `person` WHERE name LIKE ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + search + "%");

            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                int id = result.getInt("id_type");
                int idTypePerson = result.getInt("id_type");
                int idLogradouro = result.getInt("id_logradouro");
                String name = result.getString("name");
                String gender = result.getString("gender");
                String creationDate = result.getString("creation_date");
                String updateDate = result.getString("update_date");

                Logradouro logradouro = new ControllerLogradouro().read(idLogradouro);
                TypePerson typePerson = new ControllerTypePerson().read(idTypePerson);
                persons.add(new Person(id, name, gender, logradouro, typePerson, creationDate, updateDate));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return persons;
    }
}
