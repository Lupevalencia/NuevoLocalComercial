package com.example.demo.modelo;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ventavendedor")

public class VentaVendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int numeroTotalVentas;
    String nombreVendedor;

    public VentaVendedor() {

    }

    public VentaVendedor(int numeroTotalVentas, String nombreVendedor) {
        this.numeroTotalVentas = numeroTotalVentas;
        this.nombreVendedor = nombreVendedor;
    }

    public int getNumeroTotalVentas() {
        return this.numeroTotalVentas;
    }

    public void setNumeroTotalVentas(int numeroTotalVentas) {
        this.numeroTotalVentas = numeroTotalVentas;
    }

    public String getNombreVendedor() {
        return this.nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }


    @Override
    public String toString() {
        return "VentaVendedor{" +
                "numeroTotalVentas=" + numeroTotalVentas +
                ", nombreVendedor='" + nombreVendedor + '\'' +
                '}';
    }
}
