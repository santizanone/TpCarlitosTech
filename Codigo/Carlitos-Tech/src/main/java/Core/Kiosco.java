package Core;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import repositorio.Dao;
import repositorio.VentaDao;

public class Kiosco {

    private Inventario inventario;
    private static List<Venta> listaVentas = new ArrayList<>();
    public Kiosco(Inventario inventario, Caja caja) {
        this.inventario = inventario;        
    }

    public static void añadirVenta(List<Producto> listaProductos, float valorTotal) throws SQLException {          
        Venta venta = new Venta(listaProductos,valorTotal);                
        listaVentas.add(venta);       
        Dao<Venta> dao = new VentaDao();
        dao.add(venta);
    }

        

    public static void abrirCaja( float valorInicial) {
        Caja.getInstance().abrirCaja(valorInicial);        
    }

    public static void cerrarCaja() {
         Caja.getInstance().cerrarCaja(listaVentas); // El metodo cerrarCaja() deberia ya devolver el valor final y no pedir parametros
    }
}
