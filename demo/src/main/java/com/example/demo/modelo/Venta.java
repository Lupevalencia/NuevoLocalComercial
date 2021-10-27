
package com.example.demo.modelo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ventas")
public class Venta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idVenta;
    Date fechaVenta;  //  nº con 6 cifras. Ejemplo 061021 día,mes,año
    int numeroVendedor; //numeros del 1-100
    int codigoProducto;
    int cantidadVendidaProducto;
    int formaPago;  // Efectivo: 0 ; Débito: 1 ; Tarjeta: 2
    // //necesito este atributo aunque esto tiene que calcularlo con el precio del producto y no pidiéndoselo al usuario por teclado
    float precioFinalVenta;
    
    public Venta() {
    }

    public Venta(Date fechaVenta, int numeroVendedor, int codigoProducto, int cantidadVendidaProducto, int formaPago) {
        this.fechaVenta = fechaVenta;
        this.numeroVendedor = numeroVendedor;
        this.codigoProducto = codigoProducto;
        this.cantidadVendidaProducto = cantidadVendidaProducto;
        this.formaPago = formaPago;
        this.precioFinalVenta = 0;
    }    
    
    public Venta(int idVenta, Date fechaVenta, int numeroVendedor, int codigoProducto, int cantidadVendidaProducto, int formaPago, float precioFinalVenta) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.numeroVendedor = numeroVendedor;
        this.codigoProducto = codigoProducto;
        this.cantidadVendidaProducto = cantidadVendidaProducto;
        this.formaPago = formaPago;
        this.precioFinalVenta = precioFinalVenta;
    }    

    
    
    public int getIdVenta() {
        return this.idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaVenta() {
        return this.fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getNumeroVendedor() {
        return this.numeroVendedor;
    }

    public void setNumeroVendedor(int numeroVendedor) {
        this.numeroVendedor = numeroVendedor;
    }

    public int getCodigo() {
        return this.codigoProducto;
    }

    public void setCodigo(int codigo) {
        this.codigoProducto = codigoProducto;
    }

    public int getCantidadVendidaProducto() {
        return this.cantidadVendidaProducto;
    }

    public void setCantidadVendidaProducto(int cantidadVendidaProducto) {
        this.cantidadVendidaProducto = cantidadVendidaProducto;
    }

    public int getFormaPago() {
        return this.formaPago;
    }

    public void setFormaPago(int formaPago) {
        this.formaPago = formaPago;
    }

    public float getPrecioFinalVenta() {
        return precioFinalVenta;
    }

    public void setPrecioFinalVenta(float precioFinalVenta) {
        this.precioFinalVenta = precioFinalVenta;
    }

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", fechaVenta=" + fechaVenta + ", numeroVendedor=" + numeroVendedor + ", codigoProducto=" + codigoProducto + ", cantidadVendidaProducto=" + cantidadVendidaProducto + ", formaPago=" + formaPago + ", precioFinalVenta=" + precioFinalVenta + '}';
    }



   
    
}
