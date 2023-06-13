package sistema.model.bean;

public class Logradouro {

    private int id;
    private String streetNome;
    private String zipCode;
    private int number;
    private String neighborhood;
    private String city;
    private String state;
    private String country;
    private String creation_date;
    private String update_date;

    public Logradouro(String streetNome, String zipCode, int number, String neighborhood, String city, String state, String country) {
        this.streetNome = streetNome;
        this.zipCode = zipCode;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public Logradouro(int id, String streetNome, String zipCode, int number, String neighborhood, String city, String state, String country, String creation_date, String update_date) {
        this.id = id;
        this.streetNome = streetNome;
        this.zipCode = zipCode;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.country = country;
        this.creation_date = creation_date;
        this.update_date = update_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetNome() {
        return streetNome;
    }

    public void setStreetNome(String streetNome) {
        this.streetNome = streetNome;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
