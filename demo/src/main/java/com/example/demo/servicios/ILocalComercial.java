
package com.example.demo.servicios;

import com.example.demo.modelo.Producto;
import com.example.demo.modelo.Vendedor;
import com.example.demo.modelo.Venta;
import com.example.demo.modelo.VentaVendedor;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ILocalComercial {
    // NOS OLVIDAMOS DE LOS FICHEROS y DEBEMOS DE CREAR LOS MÉTODOS QUE NECESITEMOS MANDAR A LLAMAR PARA VALIDAR
    //SÓLO NECESITAREMOS PASARLE POR PARÁMETROS LOS OBJETOS A INSERTAR Y LOS DATOS CONCRETOS A BUSCAR
    

    /**
     * Insertar los datos del producto que deseamos agregar al catálogo de Productos
     * @param productoAAgregar 
     */
    void ingresarProductos(Producto productoAAgregar);
    
    /**
     * Insertar los datos de la venta que se va a realizar al catálogo de Ventas
     * @param ventaAAgregar 
     */
    void ingresarVentas(Venta ventaAAgregar);
    
    /**
     * El método nos devuelve el número del vendedor con mayor cantidad de ventas realizadas
     * @return 
     */
    //int vendedorConMayorCantidadVentas(); //PENDIENTE
    
    /**
     * Listar las ventas ordenadas por número de vendedor de todas aquellas que se han realizado por débito. Además,
     * hay que incluir el precio final de la venta = precioUnitario* cantidad
     */
    List<Venta> listarOrdenadoVentasDebito(); 
    
    /**
     * Determinar si el vendedor X realizó la venta del producto Y. En tal caso,
     * mostrar dicha información junto con el precio total de la venta. Si por el contrario no existe, informar sobre ello
     * @param venta
     * @return 
     */
    //List<Venta> comprobarVentaRealizadaPorVendedor(); // Devuelve la información de la venta con el id que estamos buscando
    
    /**
     * Calcular el monto total de las ventas realizadas
     * @return 
     */
    float montoTotalVentas();
    
    /**
     * Mostrar los datos de la mayor venta abonada con tarjetade crédito
     */
    float ventaMayorTarjetaCredito();

    
    Optional<Producto> obtenerProductoPorId(int id); //Nos pide que devolvamos una lista, sino da error. Le pasamos el id deseado
    //También nos vale, para buscarlo y mostrarlo, buscarlo y y actualizarlo, buscarlo y borrarlo
    void borrarProducto(int id);
    
    //Optional<Venta> obtenerVentaPorId(int id);
    
    boolean comprobarNumeroTeclado(String codigo);
    boolean comprobarFloatTeclado(String precio);
    //String comprobarCodigoProducto(String codigoAComprobar);
    
    Optional<Venta> obtenerVentaPorVendedorYCodigo(int numero_vendedor, int codigo_producto);

    List<VentaVendedor> ventasRealizadasPorVendedores();
    
    
    //Optional<Venta> comprobarVentaPorId(int idVenta);

    boolean comprobarProductoPorId(String idProducto);

    //Optional<Vendedor> comprobarVendedorPorId(int idVendedor);
    
    List<Producto> listaDeProductos();

    float montoTotalMes(Date fechaInicial, Date fechaFin);

    //boolean comprobarParteDni(int digitosDniVendedor);

    List<Vendedor> vendedorDniBuscado(int digitosDniVendedor);

    float menorVentaEfectivo();

    int cantidadProuctoMasVendido();

    Optional<Venta> comprobarCodigoVendido(int codigo);
}
