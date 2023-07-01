package repositorio;

import Core.Rol;
import Core.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositorio.Jdbc.SqlConnection;

public class UsuarioDao implements Dao<Usuario> {

    @Override
    public void add(Usuario usuario) {
        Connection con = SqlConnection.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("insert into usuario (nombre,apellido,contraseña,rol) VALUES(?,?,?,?)");

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getContraseña());
            ps.setInt(4, usuario.getRol().getId());
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try{
                if(ps != null){
                    ps.close();
                }
            }catch(SQLException e){}
            
        }

    }

    @Override
    public void delete(int id) {
        Connection con = SqlConnection.getConnection();
        PreparedStatement ps = null;
        try {
            String query = "DELETE FROM Usuario WHERE id=?";
            ps = con.prepareStatement(query);
            int idEliminar = id;
            ps.setInt(1, idEliminar);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                if(ps != null){
                    ps.close();
                }
            }catch(SQLException e){}
        }
    }
    
    @Override
    public Usuario get(String nombre) throws SQLException {
        String nom = "", apellido = "", contraseña = "";
        int rol = -1;
        Connection con = SqlConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("Select * from usuario where nombre =?");
        ps.setString(1, nombre);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            nom = rs.getString(2);
            apellido = rs.getString(3);
            contraseña = rs.getString(4);
            rol = rs.getInt(5);
        }
        rs.close();
        ps.close();

        if (nom.equals("")) {
            return null;
        }
        return new Usuario(nombre, apellido, contraseña, Rol.getRol(rol));

    }

    @Override
    public List<Usuario> getList() throws SQLException { // posible futura implementacion
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Usuario t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario get(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
