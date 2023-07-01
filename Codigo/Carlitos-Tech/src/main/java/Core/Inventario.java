
package Core;
import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> listaProducto = new ArrayList<>();

    public Inventario() {
        listaProducto = new ArrayList<>();
    }
    
    public Inventario(ArrayList<Producto>productos) {
        listaProducto = productos;
    }
    
   
    
}
