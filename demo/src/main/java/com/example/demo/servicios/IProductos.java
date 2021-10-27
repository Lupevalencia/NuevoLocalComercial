package com.example.demo.servicios;

import com.example.demo.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by d.zambrano_preving on 14/10/2021.
 */
@Repository
public interface IProductos extends JpaRepository<Producto, Integer> {
}

// Hay dos tipos de repositorios, JpaRepository permite hacer más cosas. No recuerdo el nombre del otro
//Producto: nombre de la clase e Integer: el tipo del id_Producto