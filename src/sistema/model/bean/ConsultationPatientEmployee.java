package sistema.model.bean;

public class ConsultationPatientEmployee {
    private int id;
    private String dateConsult;
    private String description;
    private Patient patient;
    private Employee employee;
    private String creation_date;
    private String update_date;

    public ConsultationPatientEmployee(String dateConsult, String description, Patient patient, Employee employee) {
        this.dateConsult = dateConsult;
        this.description = description;
        this.patient = patient;
        this.employee = employee;
    }

    public ConsultationPatientEmployee(String dateConsult, String description, Patient patient, Employee employee, String creation_date, String update_date) {
        this.dateConsult = dateConsult;
        this.description = description;
        this.patient = patient;
        this.employee = employee;
        this.creation_date = creation_date;
        this.update_date = update_date;
    }

    public ConsultationPatientEmployee(int id, String dateConsult, String description, Patient patient, Employee employee, String creation_date, String update_date) {
        this.id = id;
        this.dateConsult = dateConsult;
        this.description = description;
        this.patient = patient;
        this.employee = employee;
        this.creation_date = creation_date;
        this.update_date = update_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateConsult() {
        return dateConsult;
    }

    public void setDateConsult(String dateConsult) {
        this.dateConsult = dateConsult;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }
}
