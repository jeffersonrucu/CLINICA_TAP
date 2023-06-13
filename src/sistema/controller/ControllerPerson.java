package sistema.controller;

import sistema.model.bean.Person;
import sistema.model.dao.DaoPerson;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class ControllerPerson {

    DaoPerson daoPerson;

    public ControllerPerson() throws SQLException, ParseException {
        this.daoPerson = new DaoPerson();
    }

    public List<Person> all() {
        return this.daoPerson.all();
    }

    public Person create(Person person) {
        return this.daoPerson.create(person);
    }

    public Person update(Person person) throws ParseException {
        return this.daoPerson.update(person);
    }

    public Person read(int id) {
        return this.daoPerson.read(id);
    }

    public int delete(int id) {
        return this.daoPerson.delete(id);
    }

    public List<Person> search(String search) {
        return this.daoPerson.search(search);
    }
}
