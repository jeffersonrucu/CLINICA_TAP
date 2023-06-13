package sistema.controller;

import sistema.model.bean.User;
import sistema.model.dao.DaoUser;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class ControllerUser {
    DaoUser daoUser;

    public ControllerUser() throws SQLException, ParseException {
        this.daoUser = new DaoUser();
    }

    public List<User> all() {
        return this.daoUser.all();
    }

    public User create(User user) {
        return this.daoUser.create(user);
    }

    public User update(User user) throws ParseException {
        return this.daoUser.update(user);
    }

    public User read(int id) {
        return this.daoUser.read(id);
    }

    public int delete(int id) {
        return this.daoUser.delete(id);
    }

    public List<User> search(String search) {
        return this.daoUser.search(search);
    }
}
