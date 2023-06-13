package sistema.model.bean;

public class TypePerson {
    private int id;
    private String cpf;
    private String cnpj;
    private String creation_date;
    private String update_date;

    public TypePerson(String cpf, String cnpj) {
        this.cpf = cpf;
        this.cnpj = cnpj;
    }

    public TypePerson(int id, String cpf, String cnpj, String creation_date, String update_date) {
        this.id = id;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.creation_date = creation_date;
        this.update_date = update_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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
