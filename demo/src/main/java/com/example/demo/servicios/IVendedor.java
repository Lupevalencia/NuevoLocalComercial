package com.example.demo.servicios;

import com.example.demo.modelo.Vendedor;
import java.util.List;

import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by d.zambrano_preving on 14/10/2021.
 */
public interface IVendedor extends JpaRepository<Vendedor, Integer> {

    
    @Query(value = "select numero_vendedor, nombre_vendedor, dni_vendedor " +
    "from vendedores " +
    "where dni_vendedor like '%:digitosDniVendedor%'",nativeQuery = true)
    public List<Vendedor> vendedorDniBuscado(@Param("digitosDniVendedor") Integer digitosDniVendedor);

    List<Vendedor> findByDniVendedorContaining(String dni);  //Con jpA mejor
    
}
