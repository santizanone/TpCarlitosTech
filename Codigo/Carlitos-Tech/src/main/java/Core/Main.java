package Core;

import vistas.Login;

public class Main {
    public static void main(String[] args) {
        LoginService service = new LoginService();
        Login login = new vistas.Login();
        login.setVisible(true);
        
    }
}
