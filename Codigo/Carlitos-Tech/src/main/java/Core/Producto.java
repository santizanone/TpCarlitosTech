package Core;

public class Producto {
    private int id;
    private String nombre;
    private float precio;
    private String marca;
    private int cantidad;
    private int activo;


     public Producto(int id, String nombre, float precio, String marca, int cantidad,int activo) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.cantidad = cantidad;
        this.activo = activo;
    }


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public String getMarca() {
        return marca;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getActivo() {
        return activo;
    }
            

    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", marca=" + marca + ", cantidad=" + cantidad + '}';
    }
    

    
    
    
    
}
