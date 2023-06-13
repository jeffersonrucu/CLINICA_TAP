package sistema.model.bean;

public class Patient {

    private int id;
    private String healthInsurance;
    private User user;
    private String creation_date;
    private String update_date;

    public Patient(String healthInsurance, User user) {
        this.healthInsurance = healthInsurance;
        this.user = user;
    }

    public Patient(String healthInsurance, User user, String creation_date, String update_date) {
        this.healthInsurance = healthInsurance;
        this.user = user;
        this.creation_date = creation_date;
        this.update_date = update_date;
    }

    public Patient(int id, String healthInsurance, User user, String creation_date, String update_date) {
        this.id = id;
        this.healthInsurance = healthInsurance;
        this.user = user;
        this.creation_date = creation_date;
        this.update_date = update_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(String healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
