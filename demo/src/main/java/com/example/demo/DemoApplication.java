package com.example.demo;

import com.example.demo.modelo.Producto;
import com.example.demo.modelo.Vendedor;
import com.example.demo.modelo.Venta;
import com.example.demo.servicios.ILocalComercial;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;

@SpringBootApplication
public class DemoApplication {
    
    @Autowired
    ILocalComercial localComercial;
    
    
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    
    @PostConstruct  //Hemos necesitado hacer esto porque nos daba error . Internet
    public void init(){
          int opcion = -1;
          Scanner scanner = new Scanner(System.in);

while(opcion != 0){
        System.out.println("Elige una opcion : \n"

                        + "1. Ingrese los datos de los productos a la venta que dispone dicho local.\n"
                        + "2. Ingrese los datos de las ventas registradas.\n"
                        + "3. Determinar cuál fue el vendedor que realizó la mayor cantidad de ventas.\n"
                        + "4. Generar un listado, ordenado por número de vendedor, de todas las ventas realizadas por débito.\n"
                        + "5. Determinar si el vendedor X realizó una venta del producto Y.\n"
                        + "6. Determinar el monto total de ventas realizadas.\n"
                        + "7. Mostrar los datos de la venta de mayor importe abonada con tarjeta de crédito.\n"
                        + "8. Borrar un producto.\n"
                        + "9. Actualizar un producto determinado.\n"
                        + "10. Calcular el monto total de ventas de un determinado mes.\n"
                        + "11. Mostrar el nombre de los vendedores que compartan X dígitos en su dni.\n"
                        + "12. Mostrar la menor venta abonada en efectivo.\n"
                        + "13. Producto más vendido en el local.\n"
                        + "0. Salir");
        opcion = Integer.parseInt(scanner.nextLine());


  
        
        
       
        switch (opcion) {
                case 1: //El id no se pide por teclado, es autoincremento
                        String codigoProductoString = " ";
                        while(localComercial.comprobarNumeroTeclado(codigoProductoString)){
                            System.out.println("Introduce el codigo del producto con los números que lo identifican: ");
                            codigoProductoString = scanner.nextLine();
                        }
                        int codigoProducto = Integer.parseInt(codigoProductoString);
                        
                        String descripcionProducto = "1234";
                        while(!descripcionProducto.matches("^[A-Za-z ]*$")){
                            System.out.println("Introduce la descripcion del producto: ");
                            descripcionProducto = scanner.nextLine();
                        }
                        
                        String precioProductoString = " ";
                        while(localComercial.comprobarFloatTeclado(precioProductoString)){
                            System.out.println("Introduce el precio del producto con sus correspondientes cifras decimales: ");
                            precioProductoString = scanner.nextLine();
                        }
                        float precioUnitarioProducto = Float.parseFloat(precioProductoString);

                        Producto productoAAgregar = new Producto(codigoProducto,descripcionProducto,precioUnitarioProducto);
                        
                        //Insertar
                       
                        localComercial.ingresarProductos(productoAAgregar);
                        
                        System.out.println("El producto se ha insertado con éxito ");
                        break;

                case 2:
                        //El id no se pide por teclado, es autoincremento
                        List<Producto> listadoDeProductos = localComercial.listaDeProductos();
                        System.out.println("-- LISTA DE PRODUCTOS A LA VENTA");
                            for(int i = 0; i<listadoDeProductos.size(); i++){
                                        System.out.println("-- PRODUCTO Nº --" + i + " " + listadoDeProductos.get(i).getIdProducto() + listadoDeProductos.get(i).getCodigo() + listadoDeProductos.get(i).getPrecio());
                        }
                        System.out.println("-- FIN DE PRODUCTOS A LA VENTA -- \n");
                        
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        System.out.println("Introduce la fecha de Venta del producto en el siguiente formato (dd/MM/yyyy): ");
                        String fechaVentaString = scanner.nextLine();
                        Date fechaVenta = null;
                        try {
                                fechaVenta = formato.parse(fechaVentaString);  //NECESARIO EXCEPCIÓN PARA ERRORES
                        } catch (ParseException e) {
                                e.printStackTrace();
                        }

                        String numeroVendedorString = " ";
                        while(/*localComercial.comprobarNumeroTeclado(numeroVendedorString) &&*/ !numeroVendedorString.equals("1") && !numeroVendedorString.equals("2") && !numeroVendedorString.equals("3")){
                            System.out.println("Introduce el número del vendedor que va a realizar la venta de este producto (1- JUAN PEREZ GARCIA; 2- MANUEL ALBERTO MARTINEZ SANCHEZ; 3- JESUS DE LA CUEVA RODARTE): ");
                            numeroVendedorString = scanner.nextLine();
                        }
                        int numeroVendedor = Integer.parseInt(numeroVendedorString);

                        
                         // AQUÍ DEBEMOS DE VALIDAR QUE EXISTE EL PRODUCTO QUE SE DESEA VENDER EN EL LOCAL COMERCIAL (CON BOOLEAN)
                        String codigoString = " ";
                        while(localComercial.comprobarNumeroTeclado(codigoString)){
                            System.out.println("Introduce el codigo del producto que va a ser vendido. Recuerda que dicho código se corresponde con el id del producto a vender.\n");
                            codigoString = scanner.nextLine();
                        }
                        int codigo = Integer.parseInt(codigoString);
                       

                        String cantidadVendidaString = " ";
                        while(localComercial.comprobarNumeroTeclado(cantidadVendidaString)){
                            System.out.println("Introduce el numero de unidades a vender de dicho producto: ");
                            cantidadVendidaString = scanner.nextLine();
                        }
                        int cantidadVendidaProducto = Integer.parseInt(cantidadVendidaString);
                        
                        
                        String formaPagoString = " ";
                        while(!formaPagoString.equals("0") && !formaPagoString.equals("1") && !formaPagoString.equals("2")){
                            System.out.println("Introduce la forma de pago con la que desea abonar esta venta(0- Efectivo; 1- Débito; 2- Tarjeta ): ");
                            formaPagoString = scanner.nextLine();
                        }
                        int formaPago = Integer.parseInt(formaPagoString);


                        Venta ventaAAgregar = new Venta(fechaVenta,numeroVendedor,codigo,cantidadVendidaProducto,formaPago);
                        
                        localComercial.ingresarVentas(ventaAAgregar);
                        System.out.println("La venta se ha insertado con éxito");
                        
                        break;
                case 3:
                        //int id=0; //PEDIR POR TECLADO EL id. NO PUEDO PASARLE un id que no CONOZCO CUÁL ES
                        //Optional<Producto> productoObtenido = localComercial.obtenerProductoPorId(id);
                        //Producto prod2 = productoObtenido.get(); //ASÍ GUARDA MEJOR EL VALOR
                        //prod2.(ya puedo acceder a todos los campos que quiera y hacer el get.())
                        //Devolver el número del vendedor que realizó mayor cantidad de ventas
                        //vendedor =localComercial.
                        
                        //Devuelve el número de ventas realizadas por cada vendedor. NECESITO DEVOLVER TODOS LOS CAMPOS????
                        List<Vendedor> listadoVentasRealizadas = localComercial.VentasRealizadasPorVendedores();
                        System.out.println("-- Listado de ventas realizadas por los vendedores del Local Comercial --");
                            for(int i = 0; i<listadoVentasRealizadas.size(); i++){
                                System.out.println("numero vendedor: " + listadoVentasRealizadas.get(i).getNumeroTotalVentas());
                                System.out.println("precio final venta = " + listadoVentasRealizadas.get(i).getNombreVendedor());
                                System.out.println("-- Fin Ventas Realizadas --");
                        }
                        
                        break;

                case 4:  
                        //Listado ordenado por nº vendedor de las ventas realizadas por débito. (PrecioFinal= precioUnitario* cantidadVendidaProducto)
                        //Utilizamos el lengh solo para cadenas. Size para el resto
                        List<Venta> listaVentas = localComercial.listarOrdenadoVentasDebito();
                        
                        for(int i = 0; i<listaVentas.size(); i++){
                            System.out.println("-- Venta --");
                            System.out.println("id: " + listaVentas.get(i).getIdVenta());
                            System.out.println("fecha: " + listaVentas.get(i).getFechaVenta());
                            System.out.println("numero vendedor: " + listaVentas.get(i).getNumeroVendedor());
                            System.out.println("codigo: " + listaVentas.get(i).getCodigo());
                            System.out.println("cantidad: " + listaVentas.get(i).getCantidadVendidaProducto());
                            //System.out.println("precio final venta = " + listaVentas.get(i).getPrecioFinalVenta());
                            System.out.println("-- Fin Venta --");
                        }
                        break;
                case 5:
                        // Devuelve el resultado de buscar un vendedor y una venta determinada, si existe, la mostramos junto con su PrecioFinal y sino, mostramos mensaje error
                        //Buscar por id al vendedor y por otro lado la venta y si existen, mostarlo. Sino mostrar error
                        //AQUÍ TAMBIÉN DEBERÍA DE CONTROLAR SI EXISTE EL ID Y EL CODIGO QUE SE PIDEN POR TECLADO EN LAS DIFERENTES TABLAS
                        String numero_Vendedor_verificar_String = " ";
                        String codigo_Producto_verificar_String = "hola";
                        while(localComercial.comprobarNumeroTeclado(numero_Vendedor_verificar_String) && localComercial.comprobarProductoPorIdVentas(codigo_Producto_verificar_String)){
                            System.out.println("Introduce el numero del vendedor cuya venta deseas verificar:");
                            numero_Vendedor_verificar_String = scanner.nextLine();
                            System.out.println("Introduce el codigo del producto cuya venta deseas verificar");
                            codigo_Producto_verificar_String = scanner.nextLine();
                        }
                        int numero_Vendedor_verificar = Integer.parseInt(numero_Vendedor_verificar_String);
                        int codigo_Producto_verificar = Integer.parseInt(codigo_Producto_verificar_String);
                        
                        Optional<Venta> ventaAVerificar = localComercial.obtenerVentaPorVendedorYCodigo(numero_Vendedor_verificar, codigo_Producto_verificar);

                        Venta ventaEncontrada = ventaAVerificar.get();
                        System.out.println("-- Venta buscada --");
                        System.out.println("id: " + ventaEncontrada.getIdVenta());
                        System.out.println("fechaVenta: " + ventaEncontrada.getFechaVenta());
                        System.out.println("numeroVendedor: " + ventaEncontrada.getNumeroVendedor());
                        System.out.println("codigoProducto: " + ventaEncontrada.getCodigo());
                        System.out.println("cantidadVendidaProducto: " + ventaEncontrada.getCantidadVendidaProducto());
                        System.out.println("formaPago: " + ventaEncontrada.getFormaPago());
                        
                         
                        //while(ventaAVerificar) Tengo que validar que si no lo encuentra devuelve un error
                        
                        
                        break;
                case 6:
                        // Devuelve el monto total de ventas realizadas por los vendedores
                        float montoTotal = localComercial.montoTotalVentas();
                        System.out.println("El monto total de ventas realizadas es:  " + montoTotal);
                        
                        break;
                case 7:
                        //Devuelve los datos de la venta de mayor importe de la venta abonada con tarjeta de crédito
                        float ventaMayorTarjeta = localComercial.VentaMayorTarjetaCredito();
                        System.out.println("La venta de mayor importe abonada con tarjeta de crédito es: " + ventaMayorTarjeta);
                       
                                
                        break;     
                        
                case 8: //HAY QUE COMPROBAR PREVIAMENTE QUE ESE ID EXISTE DENTRO DE LA TABLA QUE SE DESEA ACTUALIZAR.
                       // AQUÍ PODRÍAMOS MOSTRAR ADEMÁS UNA LISTA DE LOS PRODUCTOS QUE HAY ANTES DE INTRODUCIR EL QUE DESEA BORRAR
                    boolean identificadorOK = false;
                    while (identificadorOK){
                        System.out.println("Introduce el id del producto que deseas borrar. COMPRUEBE que dicho producto existe en este localComercial antes de INTENTAR BORRARLO:");
                        String id_borrar_Producto = scanner.nextLine();
                        if(localComercial.comprobarNumeroTeclado(id_borrar_Producto) && localComercial.comprobarProductoPorIdVentas(id_borrar_Producto)){
                            identificadorOK = true;
                            int id_Producto_Borrar = Integer.parseInt(id_borrar_Producto); //Deberia pasarle el entero al método aunque si no es un entero igual no va

                        }

                    }

                        
                        Optional<Producto> productoABorrar = localComercial.obtenerProductoPorId(id_Producto_Borrar);
                        
                        
                        /*if(productoABorrar != null){*/
                            Producto productoBuscado = productoABorrar.get();
                            System.out.println("El producto buscado es: \n");
                            System.out.println("id: " + productoBuscado.getIdProducto());
                            System.out.println("codigoProducto: " + productoBuscado.getCodigo());
                            System.out.println("descripcion: " + productoBuscado.getDescripcion());
                            System.out.println("precioUnitario: " + productoBuscado.getPrecio());


                            localComercial.borrarProducto(id_Producto_Borrar);
                            System.out.println("El producto se ha borrado correctamente. \n");
                       //}else{
                         //   System.out.println("El producto no existe ");
                        
                      // }
                        break;
                case 9:
                       //String id_actualizar_Producto_String = " ";
                       //while(localComercial.comprobarNumeroTeclado(id_actualizar_Producto_String)){
                         //   System.out.println("Introduce el id del producto que deseas actualizar:");
                           // id_actualizar_Producto_String = scanner.nextLine();
                       //}
                       //int id_Producto_actualizar = Integer.parseInt(id_actualizar_Producto_String);

                       //Optional<Producto> productoAActualizar = localComercial.comprobarProductoPorId(id_Producto_actualizar);
                       //System.out.println("El producto que se desea actualizar: ");
                       //Producto productoEncontrado = productoAActualizar.get();
                       
                       //System.out.println("productoEncontrado = " + productoEncontrado.toString());
                       
                       //String descripcionNueva = "1234132234345456523111165554545484841651511166466513120065131311651320311666303203201545610306565555661165165653565657787989834534564565667878685435353536577686781232234234";
                       
                       //while(!descripcionNueva.matches("^[A-Za-z ]*$") && descripcionNueva.length()>50 ){
                         //   System.out.println("Introduce la nueva descripcion del producto que deseas actualizar: ");
                           // descripcionNueva = scanner.nextLine();
                            
                       //}
                       //productoEncontrado.setDescripcion(descripcionNueva);
                       //localComercial.ingresarProductos(productoEncontrado);
                       //System.out.println("Producto modificado con éxito ");
                       
                       break;
                case 10:

                    break;

                case 11:

                    break;

                case 12:
                    break;

                case 0:
                        System.out.println("Hasta pronto!!");
                        break;
                default:
                        System.out.println("Opcion no reconocida");
                        break;

        }
        }
    }
}
