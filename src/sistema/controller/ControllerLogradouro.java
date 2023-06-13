package sistema.controller;

import sistema.model.bean.Logradouro;
import sistema.model.dao.DaoLogradouro;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class ControllerLogradouro {

    DaoLogradouro daoLogradouro;

    public ControllerLogradouro() throws SQLException, ParseException {
        this.daoLogradouro = new DaoLogradouro();
    }

    public List<Logradouro> all() {
        return this.daoLogradouro.all();
    }

    public Logradouro create(Logradouro logradouro) {
        return this.daoLogradouro.create(logradouro);
    }

    public Logradouro update(Logradouro logradouro) throws ParseException {
        return this.daoLogradouro.update(logradouro);
    }

    public Logradouro read(int id) {
        return this.daoLogradouro.read(id);
    }

    public int delete(int id) {
        return this.daoLogradouro.delete(id);
    }

    public List<Logradouro> search(String search) {
        return this.daoLogradouro.search(search);
    }
}
