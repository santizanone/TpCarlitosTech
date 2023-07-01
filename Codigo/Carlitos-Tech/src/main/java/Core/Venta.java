package Core;

import java.time.LocalDateTime;
import java.util.List;

public class Venta {
    private LocalDateTime fechaHora;
    private float precio;
    private List<Producto> productos;
    
    public Venta(List<Producto>productos,float precio) {
        this.productos = productos;
        fechaHora = LocalDateTime.now();
        this.precio = precio;
        
    }

    public Venta(float precio, LocalDateTime fechaHora, List<Producto>productos) {
        this.precio = precio;
        this.fechaHora = fechaHora;
        this.productos = productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
   

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public float getPrecio() {
        return precio;
    }
    
    public List<Producto> getProductos(){
        return productos;
    }
    
}
