package com.example.demo.servicios;

import com.example.demo.modelo.Vendedor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by d.zambrano_preving on 14/10/2021.
 */
public interface IVendedor extends JpaRepository<Vendedor, Integer> {
    
    @Query(value = "SELECT count(ventas.numero_vendedor) as numero_total_ventas, nombre_vendedor \n" +
    "FROM ventas\n" +
    "inner join vendedores ON (vendedores.id_vendedor = ventas.numero_vendedor)\n" +
    "group by id_vendedor",nativeQuery = true)    
    public List<Vendedor> VentasRealizadasPorVendedores();
    
    
    
    
}
