package sistema.controller;

import sistema.model.bean.TypePerson;
import sistema.model.dao.DaoTypePerson;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class ControllerTypePerson {
    DaoTypePerson daoTypePerson;

    public ControllerTypePerson() throws SQLException, ParseException {
        this.daoTypePerson = new DaoTypePerson();
    }

    public List<TypePerson> all() {
        return this.daoTypePerson.all();
    }

    public TypePerson create(TypePerson typePerson) {
        return this.daoTypePerson.create(typePerson);
    }

    public TypePerson update(TypePerson typePerson) throws ParseException {
        return this.daoTypePerson.update(typePerson);
    }

    public TypePerson read(int id) {
        return this.daoTypePerson.read(id);
    }

    public int delete(int id) {
        return this.daoTypePerson.delete(id);
    }

    public List<TypePerson> search(String search) {
        return this.daoTypePerson.search(search);
    }
}
