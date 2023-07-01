package repositorio;

import Core.Caja;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import repositorio.Jdbc.SqlConnection;

public class CajaDao implements Dao<Caja>{

    @Override
    public void add(Caja caja){
        Connection con = SqlConnection.getConnection();
        java.sql.Timestamp fechaHoraInicio = java.sql.Timestamp.valueOf(caja.getFechaApertura());
        java.sql.Timestamp fechaHoraFinal = java.sql.Timestamp.valueOf(caja.getFechaCierre());
        String query = "INSERT INTO caja (valor_inicial, valor_final, fecha_apertura, fecha_cierre) values (?,?,?,?)";
        
        try(PreparedStatement ps = con.prepareStatement(query)){
            ps.setFloat(1, caja.getValorInicial());
            ps.setFloat(2, caja.getValorFinal());
            ps.setTimestamp(3, fechaHoraInicio);
            ps.setTimestamp(4, fechaHoraFinal);
            ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Caja get(int id) {
        ResultSet rs = null;
        Connection con = SqlConnection.getConnection();
        
        float valorInicial = 0, valorFinal = 0;
        LocalDateTime fechaApertura = null, fechaCierre = null;
        
        String query = "SELECT * from caja WHERE id=?";
        
        try(PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1, id);
            rs = ps.executeQuery();
            valorInicial = rs.getFloat("valor_inicial");
            valorFinal = rs.getFloat("valor_final");
            Timestamp fechaAperturaSQL = rs.getTimestamp("fecha_apertura");
            Timestamp fechaCierreSQL = rs.getTimestamp("fecha_cierre");
            
            fechaApertura = fechaAperturaSQL.toLocalDateTime();
            fechaCierre = fechaCierreSQL.toLocalDateTime();
        }catch(SQLException e){
            System.out.println(e);
        }finally{
            try{
                if(rs!=null){
                    rs.close();
                }    
            }catch(SQLException e){System.out.println(e);}
        }
        
        if(fechaApertura==null || fechaCierre==null){
            return null;
        }
        return new Caja(valorInicial, valorFinal, fechaApertura, fechaCierre);
    }

    @Override
    public Caja get(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List getList() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Caja t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
