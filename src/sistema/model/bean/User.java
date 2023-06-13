package sistema.model.bean;

public class User {
    private int idUser;
    private String username;
    private String email;
    private String emailRecovery;
    private String password;
    private Person person;
    private String creation_date;
    private String update_date;

    public User(String username, String email, String emailRecovery, String password, Person person) {
        this.username = username;
        this.email = email;
        this.emailRecovery = emailRecovery;
        this.password = password;
        this.person = person;
    }

    public User(int idUser, String username, String email, String emailRecovery, String password, Person person, String creation_date, String update_date) {
        this.idUser = idUser;
        this.username = username;
        this.email = email;
        this.emailRecovery = emailRecovery;
        this.password = password;
        this.person = person;
        this.creation_date = creation_date;
        this.update_date = update_date;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailRecovery() {
        return emailRecovery;
    }

    public void setEmailRecovery(String emailRecovery) {
        this.emailRecovery = emailRecovery;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
