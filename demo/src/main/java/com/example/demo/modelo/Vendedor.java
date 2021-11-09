
package com.example.demo.modelo;

//Solo necesito que herede dos de sus atributos, aunque la venta al completo va referida a uno de los vendedores del Local Comercial

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vendores")
public class Vendedor{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idVendedor;
    int numeroVendedor;
    String nombreVendedor;
    String dniVendedor;
    //int numeroTotalVentas;
    
    public Vendedor() {
    }

    //public Vendedor(/*int idVendedor,*/String nombreVendedor) {
        //this.idVendedor = idVendedor;
      //  this.nombreVendedor = nombreVendedor;
        //this.numeroTotalVentas = 0;
    //}
    
    public Vendedor(int numeroVendedor, String nombreVendedor, String dniVendedor) {
        this.numeroVendedor = numeroVendedor;
        this.nombreVendedor = nombreVendedor;
        this.dniVendedor = dniVendedor;
        //this.numeroTotalVentas = 0;
    } 
    
    public Vendedor(int idVendedor, int numeroVendedor, String nombreVendedor, String dniVendedor/*,int numeroTotalVentas*/) {
        this.idVendedor = idVendedor;
        this.numeroVendedor = numeroVendedor;
        this.nombreVendedor = nombreVendedor;
        this.dniVendedor = dniVendedor;
        //this.numeroTotalVentas = numeroTotalVentas;
    }

    public int getIdVendedor() {
        return this.idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public int getNumeroVendedor() {
        return this.numeroVendedor;
    }

    public void setNumeroVendedor(int numeroVendedor) {
        this.numeroVendedor = numeroVendedor;
    }

    public String getNombreVendedor() {
        return this.nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getDniVendedor() {
        return this.dniVendedor;
    }

    public void setDniVendedor(String dniVendedor) {
        this.dniVendedor = dniVendedor;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "idVendedor=" + idVendedor +
                ", numeroVendedor=" + numeroVendedor +
                ", nombreVendedor='" + nombreVendedor + '\'' +
                ", dniVendedor='" + dniVendedor + '\'' +
                '}';
    }
}
