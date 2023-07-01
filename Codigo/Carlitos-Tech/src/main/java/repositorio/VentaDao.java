package repositorio;

import Core.Producto;
import java.sql.SQLException;
import java.util.List;
import Core.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositorio.Jdbc.SqlConnection;

public class VentaDao implements Dao<Venta> {

    @Override
    public void add(Venta venta) {
        java.sql.Timestamp sqlTimestamp = java.sql.Timestamp.valueOf(venta.getFechaHora());
        Connection con = SqlConnection.getConnection();
        String query;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int idVenta = 0;

        try {
            query = "INSERT INTO Venta (fecha_hora, valor) VALUES (?, ?)";
            ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setTimestamp(1, sqlTimestamp);
            ps.setFloat(2, venta.getPrecio());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            while (rs.next()) {
                idVenta = rs.getInt(1);
            }

            query = "INSERT INTO venta_producto (id_venta, id_producto, cantidad) VALUES (?, ?, ?)";
            ps = con.prepareStatement(query);
            for (Producto p : venta.getProductos()) {
                ps.setInt(1, idVenta);
                ps.setInt(2, p.getId());
                ps.setInt(3, p.getCantidad());
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null && ps != null) {
                    rs.close();
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(VentaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Venta get(int id) {
        Connection con = SqlConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        float valor = 0;
        LocalDateTime fechaHora = null;
        ArrayList<Producto> productos = new ArrayList<>();
        String query;

        query = "SELECT * from venta WHERE id=?";

        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            valor = rs.getFloat("valor");
            Timestamp fechaHoraSQL = rs.getTimestamp("fecha_hora");
            fechaHora = fechaHoraSQL.toLocalDateTime();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null && ps != null) {
                    rs.close();
                    ps.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        query = "                SELECT producto.id as id, producto.nombre as nombre, producto.marca as marca, producto.precio as precio, venta_producto.cantidad as cantidad                 from venta_producto                INNER JOIN producto ON venta_producto.id_producto = producto.id                WHERE venta_producto.id_venta = ?;";

        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idProducto = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String marca = rs.getString("marca");
                float precio = rs.getFloat("precio");
                int cantidad = rs.getInt("cantidad");
                int activo = rs.getInt("activo");
                productos.add(new Producto(idProducto, nombre, precio, marca, cantidad,activo));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null && ps != null) {
                    rs.close();
                    ps.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        if (productos.isEmpty()) {
            return null;
        }
        return new Venta(valor, fechaHora, productos);
    }

    @Override
    public List getList() throws SQLException {
        Connection con = SqlConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Venta> ventas = new ArrayList<>();
        List<Integer> indices = new ArrayList<>();
        
        float valor = 0;
        LocalDateTime fechaHora = null;
        ArrayList<Producto> productos = new ArrayList<>();
        String query;
        query = "SELECT * from venta";

        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
            valor = rs.getFloat("valor");
            Timestamp fechaHoraSQL = rs.getTimestamp("fecha_hora");
            fechaHora = fechaHoraSQL.toLocalDateTime();
            ventas.add(new Venta(valor, fechaHora, productos));
            indices.add(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null && ps != null) {
                    rs.close();
                    ps.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

         query = "                SELECT producto.id as id, producto.nombre as nombre, producto.marca as marca, producto.precio as precio,producto.activo as activo ,venta_producto.cantidad as cantidad                 from venta_producto                INNER JOIN producto ON venta_producto.id_producto = producto.id                WHERE venta_producto.id_venta = ?;";

        try {
            for(int i = 0;i<ventas.size();i++ ){
                productos = new ArrayList<>();
                ps = con.prepareStatement(query);         
                ps.setInt(1,indices.get(i) );
                rs = ps.executeQuery();
                while (rs.next()) {
                    int idProducto = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String marca = rs.getString("marca");
                    float precio = rs.getFloat("precio");
                    int cantidad = rs.getInt("cantidad");
                    
                    int activo = rs.getInt("activo");
                    productos.add(new Producto(idProducto, nombre, precio, marca, cantidad,activo));
                }
                ventas.get(i).setProductos(productos);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null && ps != null) {
                    rs.close();
                    ps.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        if (productos.isEmpty()) {
            return null;
        }
        return ventas;
    }

    @Override
    public void update(Venta venta) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Venta get(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
