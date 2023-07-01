package Core;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositorio.Dao;
import repositorio.UsuarioDao;

public class LoginService {
   

    public LoginService() {
      
    }
    
    public Usuario validarUsuario(String nombre,String contraseña){
        Dao<Usuario> dao = new UsuarioDao();
        Usuario user = null; 
        try {
            user =  dao.get(nombre);
        } catch (SQLException ex) {
            Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(user != null) {       
            if(user.getNombre().equals(nombre) && user.getContraseña().equals(contraseña)){
                return user;
            }
        }
        return null;
    }
}

