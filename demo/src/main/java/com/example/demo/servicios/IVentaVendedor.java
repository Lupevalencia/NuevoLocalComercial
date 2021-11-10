package com.example.demo.servicios;

import com.example.demo.modelo.Venta;
import com.example.demo.modelo.VentaVendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IVentaVendedor extends JpaRepository<VentaVendedor, Integer> {
    @Query(value = "SELECT count(ventas.numero_vendedor) as numero_total_ventas, nombre_vendedor \n" +
     "FROM ventas\n" +
    "inner join vendedores ON (ventas.numero_vendedor = vendedores.id_vendedor)\n" +
    "group by vendedores.numero_vendedor",nativeQuery = true)
    public List<VentaVendedor> ventasRealizadasPorVendedores();


}
