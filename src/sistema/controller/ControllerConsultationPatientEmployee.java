package sistema.controller;

import sistema.model.bean.ConsultationPatientEmployee;
import sistema.model.dao.DaoConsultationPatientEmployee;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class ControllerConsultationPatientEmployee {

    DaoConsultationPatientEmployee daoConsultationPatientEmployee;

    public ControllerConsultationPatientEmployee() throws SQLException, ParseException {
        this.daoConsultationPatientEmployee = new DaoConsultationPatientEmployee();
    }

    public List<ConsultationPatientEmployee> all() {
        return this.daoConsultationPatientEmployee.all();
    }

    public ConsultationPatientEmployee create(ConsultationPatientEmployee consultationPatientEmployee) {
        return this.daoConsultationPatientEmployee.create(consultationPatientEmployee);
    }

    public ConsultationPatientEmployee update(ConsultationPatientEmployee consultationPatientEmployee) throws ParseException {
        return this.daoConsultationPatientEmployee.update(consultationPatientEmployee);
    }

    public ConsultationPatientEmployee read(int id) {
        return this.daoConsultationPatientEmployee.read(id);
    }

    public int delete(int id) {
        return this.daoConsultationPatientEmployee.delete(id);
    }

    public List<ConsultationPatientEmployee> search(String search) {
        return this.daoConsultationPatientEmployee.search(search);
    }
}
