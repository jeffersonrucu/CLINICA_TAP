package sistema.controller;

public class ControllerLogin {

    public ControllerLogin() {
    }

    public Boolean valid(String username, String password) {
        if(username.equals("jefferson") && password.equals("LWpass2010")) return true;

        return false;
    }
}
