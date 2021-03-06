package com.example.demo.servicios;

import com.example.demo.modelo.Producto;
import com.example.demo.modelo.Venta;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.*;

import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by d.zambrano_preving on 14/10/2021.
 */
@Repository
public interface IVenta extends JpaRepository<Venta, Integer> { //Cuidado con escribir la clase diferente, no la reconoce
    
    //public int vendedorConMayorCantidadVentas();
    
    @Query(value = "select * from " +
"(select codigo_producto, cantidad_vendida_producto, forma_pago, numero_vendedor, fecha_venta, id_venta " +
"from ventas " +
"where forma_pago = 1 " +
"order by numero_vendedor) tabla1 " +
"inner join " +
"(SELECT ventas.codigo_producto, round(precio_unitario * cantidad_Vendida_producto,2) as precio_final_venta, precio_unitario " +
"FROM productos " +
"INNER JOIN ventas ON (productos.id_producto = ventas.codigo_producto)) tabla2 " +
"on tabla1.codigo_producto = tabla2.codigo_producto;",nativeQuery = true)
    public List<Venta> listarOrdenadoVentasDebito();
    
    
    
    
    @Query(value = "select * from ventas where numero_vendedor = :numero_vendedor and codigo_producto = :codigo_producto",nativeQuery = true)
    
    public Optional<Venta> obtenerVentaPorVendedorYCodigo(@Param("numero_vendedor") Integer numero_vendedor, @Param("codigo_producto") Integer codigo_producto);
    //public Optional<Venta> obtenerVentaPorVendedorYCodigo(int numeroVendedor, int codigoProducto); HOLA
    
    
    @Query(value = "select round(sum(precio_final_venta),2) from \n" +
"(select codigo_producto, cantidad_vendida_producto, forma_pago\n" +
"from ventas\n" +
"order by numero_vendedor) tabla1\n" +
"inner join\n" +
"(SELECT ventas.codigo_producto, round(precio_unitario * cantidad_Vendida_producto,2) as precio_final_venta, precio_unitario\n" +
"FROM productos\n" +
"INNER JOIN ventas ON (productos.id_producto = ventas.codigo_producto)) tabla2\n" +
"on tabla1.codigo_producto = tabla2.codigo_producto;",nativeQuery = true)
    public float montoTotalVentas();
   
    
    
    @Query(value = "select max(precio_final_venta) from \n" +
"(select codigo_producto, cantidad_vendida_producto, forma_pago\n" +
"from ventas\n" +
"where forma_pago = 2\n" +
"order by numero_vendedor) tabla1\n" +
"inner join\n" +
"(SELECT ventas.codigo_producto, round(precio_unitario * cantidad_Vendida_producto,2) as precio_final_venta, precio_unitario\n" +
"FROM productos\n" +
"INNER JOIN ventas ON (productos.id_producto = ventas.codigo_producto)) tabla2\n" +
"on tabla1.codigo_producto = tabla2.codigo_producto;",nativeQuery = true)
    public float ventaMayorTarjetaCredito();


    @Query(value = "select round(sum(precio_final_venta),2) from \n" +
"(select codigo_producto, cantidad_vendida_producto, forma_pago\n" +
"from ventas\n" +
"where (fecha_venta between :fechaInicial and :fechaFin )\n" +
"order by numero_vendedor) tabla1\n" +
"inner join\n" +
"(SELECT ventas.codigo_producto, round(precio_unitario * cantidad_Vendida_producto,2) as precio_final_venta, precio_unitario\n" +
"FROM productos\n" +
"INNER JOIN ventas ON (productos.id_producto = ventas.codigo_producto)) tabla2\n" +
 "on tabla1.codigo_producto = tabla2.codigo_producto;",nativeQuery = true)
    public float montoTotalMes(@Param("fechaInicial") Date fechaInicial, @Param("fechaFin") Date fechaFin);



  @Query(value = "select min(precio_final_venta) from \n" +
"(select codigo_producto, cantidad_vendida_producto, forma_pago\n" +
"from ventas\n" +
"where forma_pago = 0\n" +
"order by numero_vendedor) tabla1\n" +
"inner join\n" +
"(SELECT ventas.codigo_producto, round(precio_unitario * cantidad_Vendida_producto,2) as precio_final_venta, precio_unitario\n" +
"FROM productos\n" +
"INNER JOIN ventas ON (productos.id_producto = ventas.codigo_producto)) tabla2\n" +
"on tabla1.codigo_producto = tabla2.codigo_producto;",nativeQuery = true)
    public float menorVentaEfectivo();


  @Query(value = "select max(cantidad_vendida_producto)\n" +
          "from ventas\n" +
          "inner join productos on (ventas.codigo_producto = productos.id_producto)",nativeQuery = true)
    public int cantidadProuctoMasVendido();




    @Query(value = "select * from ventas where codigo_producto = :codigo",nativeQuery = true)
    public Optional<Venta> comprobarCodigoVendido(@Param("codigo") Integer codigo);
    //Esto devuelve una venta y yo necesito que cuando la devuelva muestre la venta y vuelva a pedir un id porque no se puede borrar y si no devuelve la venta entonces entra en el if
}
