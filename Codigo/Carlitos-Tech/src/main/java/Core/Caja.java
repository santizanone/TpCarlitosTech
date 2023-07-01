package Core;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositorio.CajaDao;
import repositorio.Dao;

public class Caja {

    private float valorInicial;
    private float valorFinal;
    private LocalDateTime fechaApertura;
    private LocalDateTime fechaCierre;
    private boolean cerrada = true;
    private static Caja caja;

    public Caja(float valorInicial, float valorFinal, LocalDateTime fechaApertura, LocalDateTime fechaCierre) {
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
    }

    public Caja() {
        
    }

    public boolean estaCerrada() {
        return cerrada;
    }

    public float getValorInicial() {
        return valorInicial;
    }

    public float getValorFinal() {
        return valorFinal;
    }

    public LocalDateTime getFechaApertura() {
        return fechaApertura;
    }

    public LocalDateTime getFechaCierre() {
        return fechaCierre;
    }

    public void abrirCaja(float valorInicial) {
        this.cerrada = false;
        this.valorInicial = valorInicial;
        this.fechaApertura = LocalDateTime.now();
    }

    public void cerrarCaja(List<Venta> ventas) {
        System.out.println(ventas.get(0).getProductos());
        this.valorFinal = calcularTotalVentas(ventas);
        this.cerrada = true;
        this.fechaCierre = LocalDateTime.now();
        Dao<Caja> dao = new CajaDao();
        try {
            dao.add(this);
        } catch (SQLException ex) {
            Logger.getLogger(Caja.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    private float calcularTotalVentas(List<Venta> ventas){
        System.out.println(ventas.get(0).getProductos());
        float total = 0;
        
        for(Venta v: ventas){
            total = total + v.getPrecio();
        }
        System.out.println(total);
        return total;
    }

    
      public static Caja getInstance() {
        if(caja == null) {
            caja = new Caja();
        }
        
        return caja;
    }
    
    
}
