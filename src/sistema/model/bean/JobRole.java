package sistema.model.bean;

public class JobRole {

    private int id;
    private String nameJob;
    private int permission;
    private String creation_date;
    private String update_date;

    public JobRole(String nameJob, int permission) {
        this.nameJob = nameJob;
        this.permission = permission;
    }

    public JobRole(String nameJob, int permission, String creation_date, String update_date) {
        this.nameJob = nameJob;
        this.permission = permission;
        this.creation_date = creation_date;
        this.update_date = update_date;
    }

    public JobRole(int id, String nameJob, int permission, String creation_date, String update_date) {
        this.id = id;
        this.nameJob = nameJob;
        this.permission = permission;
        this.creation_date = creation_date;
        this.update_date = update_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameJob() {
        return nameJob;
    }

    public void setNameJob(String nameJob) {
        this.nameJob = nameJob;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
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
