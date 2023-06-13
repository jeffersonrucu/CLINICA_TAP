package sistema.controller;

import sistema.model.bean.Employee;
import sistema.model.dao.DaoEmployee;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class ControllerEmployee {

    DaoEmployee daoEmployee;

    public ControllerEmployee() throws SQLException, ParseException {
        this.daoEmployee = new DaoEmployee();
    }

    public List<Employee> all() {
        return this.daoEmployee.all();
    }

    public Employee create(Employee employee) {
        return this.daoEmployee.create(employee);
    }

    public Employee update(Employee employee) throws ParseException {
        return this.daoEmployee.update(employee);
    }

    public Employee read(int id) {
        return this.daoEmployee.read(id);
    }

    public int delete(int id) {
        return this.daoEmployee.delete(id);
    }

    public List<Employee> search(String search) {
        return this.daoEmployee.search(search);
    }
}
