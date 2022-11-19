
package tienda.servicios;

import java.util.Scanner;


public class ServicioMenu {
   ServicioProducto sp = new ServicioProducto();
    
    private Scanner scan = new Scanner(System.in).useDelimiter("\n");
    
    public void menu(){
         System.out.println("Bienvenodo al sistema de Tienda ");
        int opcion = 20;
        do {
            do {
             System.out.println("Ingrese la operacion a realizar:"
                     + "\n1. Lista el nombre de todos los productos que hay en la tabla producto."
                     + "\n2. Lista los nombres y los precios de todos los productos de la tabla producto."
                     + "\n3. Listar aquellos productos que su precio esté entre 120 y 202"
                     + "\n4. Buscar y listar todos los Portátiles de la tabla producto"
                     + "\n5. Listar el nombre y el precio del producto más barato"
                     + "\n6. Ingresar un producto a la base de datos "
                     + "\n7. Ingresar un fabricante a la base de datos"
                     + "\n8. Editar un producto con datos a elección."
                     + "\n0. Salir");
             
            try {
                opcion = 20; // se reinicia con una opcion diferente a una valida
                opcion=Integer.parseInt(scan.next());
                break;
                }catch(Exception ex) {
                    System.out.println("Error, ingrese un numero ");
            }
            
            
        } while (opcion!=1 && opcion!=2 && opcion!=3 && opcion!=4 && opcion !=5 
                 && opcion !=6 && opcion !=7 && opcion !=8 && opcion!=0 );
        
       
            switch(opcion)
            {
                case 1:    
                     try {
                        sp.listaProductos();
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }  
                    break;
                case 2:  
                    try {
                        sp.listaProductosMasPrecio();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                break;
                case 3: 
                    try {
                        System.out.println("Ingrese valores maximos y minimos de precios");
                        int min = scan.nextInt();
                        int max = scan.nextInt();
                        sp.listaProductos120y202(min,max);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                break;
                case 4:
                    try {
                        sp.listaProductosPortatil();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        sp.buscarProductosMasBarato();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    
                    break;
                case 7:
                    
                    break;
                case 8:
                    
                    break;
                case 0: 
                    break;
            }
        } while (opcion != 0);
        
    }
    
}
