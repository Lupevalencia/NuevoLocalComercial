package com.example.demo.servicios;

import com.example.demo.modelo.Vendedor;
import java.util.List;

import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by d.zambrano_preving on 14/10/2021.
 */
public interface IVendedor extends JpaRepository<Vendedor, Integer> {
    
    @Query(value = "SELECT count(ventas.numero_vendedor) as numero_total_ventas, nombre_vendedor \n" +
    "FROM ventas\n" +
    "inner join vendedores ON (ventas.numero_vendedor = vendedores.id_vendedor)\n" +
    "group by vendedores.numero_vendedor",nativeQuery = true)
    public List<Vendedor> ventasRealizadasPorVendedores();
    
    
    @Query(value = "select numero_vendedor, nombre_vendedor, dni_vendedor\n" +
    "from vendedores\n" +
    "where dni_vendedor like :digitosDniVendedor%",nativeQuery = true)
    public List<Vendedor> vendedorDniBuscado(@Parameter("digitosDniVendedor") int digitosDniVendedor);
    
}
