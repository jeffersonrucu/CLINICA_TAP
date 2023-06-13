package sistema.controller;

import sistema.model.bean.JobRole;
import sistema.model.dao.DaoJobRole;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class ControllerJobRole {

    DaoJobRole daoJobRole;

    public ControllerJobRole() throws SQLException, ParseException {
        this.daoJobRole = new DaoJobRole();
    }

    public List<JobRole> all() {
        return this.daoJobRole.all();
    }

    public JobRole create(JobRole jobRole) {
        return this.daoJobRole.create(jobRole);
    }

    public JobRole update(JobRole jobRole) throws ParseException {
        return this.daoJobRole.update(jobRole);
    }

    public JobRole read(int id) {
        return this.daoJobRole.read(id);
    }

    public int delete(int id) {
        return this.daoJobRole.delete(id);
    }

    public List<JobRole> search(String search) {
        return this.daoJobRole.search(search);
    }
}
