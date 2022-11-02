/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.servicios;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;


public class ServicioProducto {
    private ProductoDAO dao;
    
    public ServicioProducto(){
        this.dao = new ProductoDAO();
    }
    
     public void crearProducto(int codigo, String nombre, double precio, int codigoFabricante) throws Exception {

        try {
            //Validamos

            if (nombre  == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar en nombre");
            }
            //Creamos el producto
            Producto producto = new Producto();
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(codigoFabricante);
           

            dao.guardarProducto(producto);

        } catch (Exception e) {
            throw e;
        }
    }
     public void modificarCodigoProducto(int codigo, String nombre, double precio, int codigoFabricante) throws Exception {

        try {

            //Validamos
            if (codigo > 0) {
                throw new Exception("Debe indicar el codigo");
            }

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
            //Buscamos
            Producto producto = buscarProductoPorCodigo(codigo);

            dao.modificarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
    }
      public void eliminarProducto(int codigo) throws Exception {

        try {

            //Validamos 
            if (codigo < 0) {
                throw new Exception("Debe indicar el codigo");
            }
            dao.eliminarProducto(codigo);
        } catch (Exception e) {
            throw e;
        }
    }
      
      public Producto buscarProductoPorCodigo(int codigo) throws Exception {

        try {

            //Validamos
            if (codigo < 0) {
                throw new Exception("Debe indicar el codigo");
            }
            Producto producto = dao.buscarProductoPorCodigo(codigo);
            //Verificamos
            if (producto == null) {
                throw new Exception("No se econtró producto para el codigo indicado");
            }

            return producto;
        } catch (Exception e) {
            throw e;
        }
    }
     
      public Collection<Producto> listarProducto() throws Exception {

        try {

            Collection<Producto> productos = dao.listarProductos();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }
      public void imprimirProductos() throws Exception {

        try {

            //Listamos los Productos
            Collection<Producto> productos = listarProducto();

            //Imprimimos los mascotas
            if (productos.isEmpty()) {
                throw new Exception("No existen mascotas para imprimir");
            } else {
                for (Producto u : productos) {
                    System.out.println(u.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
      
    //metodos del menu
      
    void listaProductos() throws Exception{  ///1
        try {
            Collection<Producto> lista = dao.listarProductos();
            if(lista.isEmpty()){
                throw new Exception("La lista esta vacia;");
            }
            for (Producto aux : lista){
                System.out.println(aux.toString());
            }
        } 
        catch (Exception e){
            throw e;
        }
    }
      
    void listaProductosMasPrecio() throws Exception{  ///2
        try {
            HashMap<String,Double> lista = dao.listarProductosMasPrecio();
            if(lista.isEmpty()){
                throw new Exception("La lista esta vacia;");
            }
            for (Map.Entry<String, Double> entry : lista.entrySet()) {
                String key = entry.getKey();
                Double value = entry.getValue();
                System.out.println("nombre: " + key + " precio " + value);    
            }
        } 
        catch (Exception e){
            throw e;
        }
    }
    
    void listaProductos120y202(int min, int max) throws Exception{  ///3
        try {
            Collection<Producto> lista = dao.listarProductos120y202( min, max);
            if(lista.isEmpty()){
                throw new Exception("La lista esta vacia;");
            }
            for (Producto aux : lista){
                System.out.println(aux.toString());
            }
        } 
        catch (Exception e){
            throw e;
        }
    }
    
     void listaProductosPortatil() throws Exception{  ///4
        try {
            Collection<Producto> lista = dao.listarProductosPortatiles();
            if(lista.isEmpty()){
                throw new Exception("La lista esta vacia;");
            }
            for (Producto aux : lista){
                System.out.println(aux.toString());
            }
        } 
        catch (Exception e){
            throw e;
        }
    }
    
      void buscarProductosMasBarato() throws Exception{  ///5
        try {
            HashMap<String,Double> lista = dao.buscarProductoMasBarato();
            if(lista.isEmpty()){
                throw new Exception("La lista esta vacia;");
            }
            for (Map.Entry<String, Double> entry : lista.entrySet()) {
                String key = entry.getKey();
                Double value = entry.getValue();
                System.out.println("nombre: " + key + " precio " + value);    
            }
        } 
        catch (Exception e){
            throw e;
        }
    } 
}         
