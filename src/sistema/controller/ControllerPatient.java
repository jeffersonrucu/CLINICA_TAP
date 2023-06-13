package sistema.controller;

import sistema.model.bean.Patient;
import sistema.model.dao.DaoPatient;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class ControllerPatient {

    DaoPatient daoPatient;

    public ControllerPatient() throws SQLException, ParseException {
        this.daoPatient = new DaoPatient();
    }

    public List<Patient> all() {
        return this.daoPatient.all();
    }

    public Patient create(Patient patient) {
        return this.daoPatient.create(patient);
    }

    public Patient update(Patient patient) throws ParseException {
        return this.daoPatient.update(patient);
    }

    public Patient read(int id) {
        return this.daoPatient.read(id);
    }

    public int delete(int id) {
        return this.daoPatient.delete(id);
    }

    public List<Patient> search(String search) {
        return this.daoPatient.search(search);
    }
}
