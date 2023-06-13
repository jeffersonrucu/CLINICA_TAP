package sistema.model.bean;

public class Person {

    private int idPerson;
    private String name;
    private String gender;
    private Logradouro logradouro;
    private TypePerson typePerson;
    private String creation_date;
    private String update_date;

    public Person(String name, String gender, Logradouro logradouro, TypePerson typePerson) {
        this.name = name;
        this.gender = gender;
        this.logradouro = logradouro;
        this.typePerson = typePerson;
    }

    public Person(int idPerson, String name, String gender, Logradouro logradouro, TypePerson typePerson, String creation_date, String update_date) {
        this.idPerson = idPerson;
        this.name = name;
        this.gender = gender;
        this.logradouro = logradouro;
        this.typePerson = typePerson;
        this.creation_date = creation_date;
        this.update_date = update_date;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Logradouro getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }

    public TypePerson getTypePerson() {
        return typePerson;
    }

    public void setTypePerson(TypePerson typePerson) {
        this.typePerson = typePerson;
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
