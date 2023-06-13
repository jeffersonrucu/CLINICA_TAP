package sistema.model.bean;

public class Employee {

    private int id;
    private String hiringDate;
    private Double wage;
    private User user;
    private JobRole jobRole;
    private String creation_date;
    private String update_date;

    public Employee(String hiringDate, Double wage, User user, JobRole jobRole) {
        this.hiringDate = hiringDate;
        this.wage = wage;
        this.user = user;
        this.jobRole = jobRole;
    }

    public Employee(String hiringDate, Double wage, User user, JobRole jobRole, String creation_date, String update_date) {
        this.hiringDate = hiringDate;
        this.wage = wage;
        this.user = user;
        this.jobRole = jobRole;
        this.creation_date = creation_date;
        this.update_date = update_date;
    }

    public Employee(int id, String hiringDate, Double wage, User user, JobRole jobRole, String creation_date, String update_date) {
        this.id = id;
        this.hiringDate = hiringDate;
        this.wage = wage;
        this.user = user;
        this.jobRole = jobRole;
        this.creation_date = creation_date;
        this.update_date = update_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(String hiringDate) {
        this.hiringDate = hiringDate;
    }

    public Double getWage() {
        return wage;
    }

    public void setWage(Double wage) {
        this.wage = wage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public JobRole getJobRole() {
        return jobRole;
    }

    public void setJobRole(JobRole jobRole) {
        this.jobRole = jobRole;
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
