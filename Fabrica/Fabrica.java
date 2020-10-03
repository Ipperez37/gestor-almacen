 
import java.util.Scanner;
import java.io.*;
import java.io.IOException;
import java.util.*;
import javax.swing.JOptionPane;

/**
 * Clase principal de la aplicación Fabrica
 * Aquí se encuentra todos los menús desde donde va a interactuar el usuario
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fabrica
{
    
    /*Bloque relacionado con la gestión de los muebles
     * Metodo que trabaja el crud de los muebles
     * crear, actualizar, eliminar y buscar
     */
    static ArrayList<Mueble> muebles;
    static ArrayList<Personas> personal;
    static ArrayList<Cliente> clientes;
    static ArrayList<Mueble>  MueblePedido;
    static HashMap<Integer, HashMap<Cliente, Mueble[]>> pedido = new HashMap<Integer, HashMap<Cliente, Mueble[]>>();
    
    static Pedido pedidos = new Pedido();
    
    static Almacen almacenes = new Almacen();
    static Administracion admin = new Administracion();
    static Fabrica fabrica = new Fabrica();
        
    static Mueble NuevoMueblePedido;
    static int nPedido=0;
    static String NombreCliente = "";
    
    static MesaCafeConCristal MesaCafeConCristal = new MesaCafeConCristal( 0, 0, 0, 0, 0, "",0,0);
    static MesaCafeSinCristal MesaCafeSinCristal =new MesaCafeSinCristal( 0,0,0,0,0,"",0,0);
    static MesaComedor MesaComedor = new MesaComedor( 0,0,0,0,0, "",true);
    static MesaDormitorio MesaDormitorio = new MesaDormitorio( 0,0,0,0,0,0,"",0);
    static SillaCocina SillaCocina = new SillaCocina(0,0,0,0,"",0,0);
    static SillaPlegable SillaPlegable = new SillaPlegable(0,0,0,0,"",0,0);
    static SillaOficinaConRueda SillaOficinaConRueda = new SillaOficinaConRueda( 0,0,0,0,"",0,0,0);
    static SillaOficinaSinRueda SillaOficinaSinRueda = new SillaOficinaSinRueda(0,0,0,0,"",0,0,0);
    static Jefe jefe = new Jefe("","","",0,"",0);
    static Comercial comercial = new Comercial("","","",0,0);
    static ArtesanoContrato artesanoContratado = new ArtesanoContrato("","","",0,0,0);
    static ArtesanoPorHoras artesanoSubcontrato = new ArtesanoPorHoras("","","",0,0,0);
    static Empresa empresa = new Empresa("","","",0,0);
    static Persona persona = new Persona("","","",0,0);
    static Cliente cliente = new Cliente("","","",0);
    
    
    //contiene un menú donde seleccionar el tipo de mueble que se desea crear
    //y la llamada a sus métodos correspondientes.
    public void crearMueble()throws IOException{
         
        int opcion;
        char eleccion,respuesta;
        String nombreActualizar, nombreDeBusqueda, nombreEliminar;
     do{
         try{
        opcion = Integer.parseInt(JOptionPane.showInputDialog(null, 
        "Menú de Opciones\n\n"
        +"1. Mesa de cafe con cristal \n"
        +"2. Mesa de cafe sin cristal \n"
        +"3. Mesa de comedor \n"
        +"4. Mesa de Dormitorio \n"
        +"5. Silla Cocina \n"
        +"6. Silla Plegable \n"
        +"7. Silla Silla oficina con ruedas \n"
        +"8. Silla oficina sin ruedas \n"
        +"0. Volver \n")); 
         
        } catch(java.util.InputMismatchException e){
                JOptionPane.showMessageDialog(null,"Error: valor no válido. Vuelve a indicar una opción ");
                opcion=0;
        }
        
        switch(opcion){
            case 0: mostrarMenu(); break;
            case 1: Fabrica.añadirMueble(1); break;//mueble cafe cristal
            case 2: Fabrica.añadirMueble(2); break;//mueble cafe sin cristal
            case 3: Fabrica.añadirMueble(3); break;//mesa dormitorio
            case 4: Fabrica.añadirMueble(4); break;//mesa comedor
            case 5: Fabrica.añadirMueble(5); break;//silla cocina
            case 6: Fabrica.añadirMueble(6); break;//silla plegable
            case 7: Fabrica.añadirMueble(7); break;//silla oficina ruedas
            case 8: Fabrica.añadirMueble(8); break;//silla oficina sin ruedas
                    
                
            
        }
    }while(opcion != 0);
}

//dependiendo de la opción que se haya seleccionado en el método anterior, creara un mueble u otro. 
public static void añadirMueble(int opcion){
                                              
                    if (opcion == 1){  
                             MesaCafeConCristal.SetDatos();
                             almacenes.insertarMueble(MesaCafeConCristal);
                            }
                    if (opcion == 2){  
                             MesaCafeSinCristal.SetDatos();
                             almacenes.insertarMueble(MesaCafeSinCristal);
                            }
                    if (opcion == 3){  
                             MesaComedor.SetDatos();
                             almacenes.insertarMueble(MesaComedor);
                            }
                    if (opcion == 4){  
                             MesaDormitorio.SetDatos();
                             almacenes.insertarMueble(MesaDormitorio);
                            }
                    if (opcion == 5){ 
                             SillaCocina.SetDatos();
                             almacenes.insertarMueble(SillaCocina);
                            }
                    if (opcion == 6){ 
                             SillaPlegable.SetDatos();
                             almacenes.insertarMueble(SillaPlegable);
                            }
                    if (opcion == 7){ 
                             SillaOficinaConRueda.SetDatos();
                             almacenes.insertarMueble(SillaOficinaConRueda);
                            }
                    if (opcion == 8){ 
                             SillaOficinaSinRueda.SetDatos();
                             almacenes.insertarMueble(SillaOficinaSinRueda);
                          
                      }
                    
                         

}

//Realiza la llamada al método que elimina el registro del mueble indicado por su nombre.
public void EliminarMueble(){
String nombreEliminar = JOptionPane.showInputDialog(null,"Indica el nombre del mueble que desea eliminar: ");
almacenes.EliminarMueble(nombreEliminar);
}
//Realiza la llamada al método que busca el registro del mueble indicado por su nombre.
public void BuscarMueble(){
String nombreBuscar = JOptionPane.showInputDialog(null,"Indica el nombre del mueble que desea buscar: ");
almacenes.ConsultarMueble(nombreBuscar);
}

//Realiza la llamada al método que actualiza los atributos, según el registro del mueble indicado por su nombre.
public void ActualizarNombre(){
String nombreActualizar = JOptionPane.showInputDialog(null,"Indica el nombre del mueble que desea Actualizar: ");
almacenes.ActualizarAlmacen(nombreActualizar);
}

//Muestra el catalogo el detalle de todos los muebles que se fabrican en el almacén
public void listarMuebles()throws IOException {
  almacenes.MostrarMueble();     
    }


/*contiene un menú donde dependiendo de la opción que se elija, puede añadir un empleado o un cliente 
 * y la llamada al método que crea cada clase.
 * Llamada de los metodos relacionados a la gestión de 
 * clientes y empleados
 */
public void CrearPersonas()throws IOException{
    char tipo = JOptionPane.showInputDialog(null,"Pulsa \"e\" para dar de alta al empleado o \"c\" para cliente ").charAt(0);
       
    if(tipo == 'e'){
            int opcion = Integer.parseInt(JOptionPane.showInputDialog(null,"Indica el tipo de empleado que desea añadir:"+  
            "\n"
            +"1. Jefe \n"
            +"2. Comercial \n"
            +"3. Artesano por empresa \n"
            +"4. Artesano subcontratado \n"
            +"0. Volver \n"));
            
            if (opcion == 1){
                jefe.SetDarDeAlta();
                admin.AñadirPersonal(jefe);
            }else if (opcion == 2){
                comercial.SetDarDeAlta();
                admin.AñadirPersonal(comercial);
            }else if (opcion == 3){
                artesanoContratado.SetDarDeAlta();
                admin.AñadirPersonal(artesanoContratado);
            }else if (opcion == 4){
                artesanoSubcontrato.SetDarDeAlta();
                admin.AñadirPersonal(artesanoSubcontrato);
            } else if (opcion == 0){
                mostrarMenu();
            }else{
                JOptionPane.showMessageDialog(null,"Debe seleccionar un nº entre 0 y 4");
            }
            
            
            
            
    }else{
            //alta cliente
             int opcion = Integer.parseInt(JOptionPane.showInputDialog(null,"Indica el tipo de cliente que desea añadir:"+  
            "\n"
            +"1. Empresa \n"
            +"2. Persona \n"
            +"0. Volver \n"));
            
            if (opcion == 1){
                empresa.SetDarDeAlta();
                admin.AñadirCliente(empresa);
            }else if (opcion == 2){
                persona.SetDarDeAlta();
                admin.AñadirCliente(persona);
            }else if (opcion == 0){
                mostrarMenu();
            }else{
                JOptionPane.showMessageDialog(null,"Debe seleccionar un nº entre 0 y 2");
            }
            
    }
}

//Realiza la llamada al método que elimina el registro del personal indicado por su nombre, ya sea personal o cliente.
public void BajaPersonas(){
 String nombreEliminar;
    char tipo = JOptionPane.showInputDialog(null,"Pulsa \"e\" para dar de baja al empleado o \"c\" para cliente ").charAt(0);
       
    if(tipo == 'e'){
        nombreEliminar = JOptionPane.showInputDialog(null,"Indique el nombre del empleado: ");
        admin.DarBajaPersonal(nombreEliminar);
    }else{
        nombreEliminar = JOptionPane.showInputDialog(null,"Indique el nombre del cliente: ");
        admin.DarBajaCliente(nombreEliminar);
    }
}

//Realiza la llamada al método que busca un registro concreto de persona indicado por su nombre, ya sea personal o cliente.
public void BuscarPersonas(){
 String nombreBuscar;
    char tipo = JOptionPane.showInputDialog(null,"Pulsa \"e\" para buscar empleados o \"c\" para cliente ").charAt(0);
       
    if(tipo == 'e'){
        nombreBuscar = JOptionPane.showInputDialog(null,"Indique el nombre del empleado: ");
        admin.ConsultarPersona(nombreBuscar);
    }else{
        nombreBuscar = JOptionPane.showInputDialog(null,"Indique el nombre del cliente: ");
        admin.ConsultarCliente(nombreBuscar);
    }
}

//lista todo el personal o cliente registrado indicando que tipo es (Personal o cliente).   
public void ListarPersonal(){
 String nombreBuscar;
    char tipo = JOptionPane.showInputDialog(null,"Pulsa \"e\" para listar los empleados o \"c\" para los cliente ").charAt(0);
       
    if(tipo == 'e'){
          admin.BuscarInfoPersonal();
    }else{
          admin.BuscarInfoCliente();
    }
}
//Actualiza los atributos del personal o cliente existente. 
//Indicando de que tipo es y el nombre de la persona o empresa que se desea actualizar.
public void ActualizarPersonal(){
    String nombreActualizar;
    char tipo = JOptionPane.showInputDialog(null,"Pulsa \"e\" para actualizar tipo empleados o \"c\" para tipo cliente ").charAt(0);
       
    if(tipo == 'e'){
        nombreActualizar = JOptionPane.showInputDialog(null,"Indica el nombre de la persona que desea Actualizar: ");
        admin.ActualizarDatosPersonal(nombreActualizar);
    }else{
        nombreActualizar = JOptionPane.showInputDialog(null,"Indica el nombre del cliente que desea Actualizar: ");
        admin.ActualizarDatosCliente(nombreActualizar);
    }
}
//menú que gestiona la llamada a los métodos relacionados con los distintos informes que incluye la aplicación.
public static void MenuInformes() throws IOException{

   
            int opcion = Integer.parseInt(JOptionPane.showInputDialog(null,"Indica el tipo de informe que desea ver:"+  
            "\n"
            +"1. Visualizar pedidos creados \n"
            +"2. Listar pedidos (Estados asignación)  \n"
            +"3. Mostrar pedidos situación de fabricación \n"
            +"0. Volver al menu \n"));
            
            if (opcion == 1){ pedidos.MostrarPedido();}
            else if (opcion == 2){pedidos.EstadoAsignacionPedidos();}
            else if (opcion == 3){pedidos.MostrarEstadoFabricacionPedidos();}
            else if (opcion == 0){ mostrarMenu();}
            else{JOptionPane.showMessageDialog(null,"Debe seleccionar un nº entre 0 y 3");}
  }
//gestiona el menú principal de la aplicación con todas sus opciones.
public static void mostrarMenu() throws IOException {
    int opcion;
    
 do{
     
    opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
    "Menú de Opciones\n\n"
    +"1. Crear un mueble \n"
    +"2. Eliminar mueble \n"
    +"3. Buscar un mueble \n"
    +"4. Listar muebles \n"
    +"5. Actualizar mueble \n"
    +"***************************** \n"
    +"6. Crear Cliente/ Personal \n"
    +"7. Dar de baja usuario \n"
    +"8. Buscar Usuario \n"
    +"9. Listar personal \n"
    +"10. Actualizar Usuario \n"
    +"***************************** \n"
    +"11. Crear Pedido \n"
    +"12. Asignar Pedidos \n"
    +"13. Proceso de fabricación \n"
    +"14. Menú informes \n"
    +"0. Salir \n"));
   
    
    switch(opcion){
        case 0: break;
        case 1: fabrica.crearMueble();
                break;
        case 2: fabrica.EliminarMueble();
                break;  
        case 3: fabrica.BuscarMueble();
                break;
        case 4: fabrica.listarMuebles();
                break;
        case 5: fabrica.ActualizarNombre();
                break;
        case 6: fabrica.CrearPersonas();
                break;
        case 7: fabrica.BajaPersonas();
                break;
        case 8: fabrica.BuscarPersonas();
                break;
        case 9: fabrica.ListarPersonal();
                break;   
        case 10: fabrica.ActualizarPersonal();
                break; 
        case 11: pedidos.CrearPedido();
                break; 
        case 12: pedidos.AsignarPedido();
                break; 
        case 13: pedidos.EstadoFabricacion();
                break;
        case 14: MenuInformes();
                break;
        
                                
        //resto opciones
        default: JOptionPane.showMessageDialog(null,"Debe seleccionar un nº entre 0 y 16");
    
    }
}while(opcion != 0);

}
    
    
    public static void main(String args[]) throws IOException {
        //añadir algunos muebles    
        MesaCafeConCristal MesaCafeConCristal1 = new MesaCafeConCristal( 40, 30, 60, 0, 2, "MesadeCafeCristal",0,2);
        almacenes.CargarCatalogo(MesaCafeConCristal1);
        MesaCafeSinCristal MesaCafeSinCristal1 =new MesaCafeSinCristal( 40, 30, 60, 0, 2, "MesadeCafeSinCristal1",0,1);
        almacenes.CargarCatalogo(MesaCafeSinCristal1);
        MesaComedor MesaComedor1 = new MesaComedor( 60, 60 , 180, 0 , 2, "MesaComedor1",true);
        almacenes.CargarCatalogo(MesaComedor1);
        MesaDormitorio MesaDormitorio1 = new MesaDormitorio( 40 , 30, 50, 0 , 2, 2, "MesaDormitorio1",0);
        almacenes.CargarCatalogo(MesaDormitorio1);
        SillaCocina SillaCocina1 = new SillaCocina( 30, 30, 40, 0, "SillaCocina1",2,0);
        almacenes.CargarCatalogo(SillaCocina1);
        SillaPlegable SillaPlegable1 = new SillaPlegable( 40, 30, 40, 0,"SillaPlegable1",2,0);
        almacenes.CargarCatalogo(SillaPlegable1);
        SillaOficinaConRueda SillaOficinaConRueda1 = new SillaOficinaConRueda( 30, 40, 75, 0,"SillaOficinaConRueda1",0,2,1);
        almacenes.CargarCatalogo(SillaOficinaConRueda1);
        SillaOficinaSinRueda SillaOficinaSinRueda1 = new SillaOficinaSinRueda( 35, 35, 80, 0,"SillaOficinaSinRueda1",0,2,2);
        almacenes.CargarCatalogo(SillaOficinaSinRueda1);
        
        
        //añadir algunos empleados y clientes
        
        Jefe jefe = new Jefe("Manuel","manuel@muebles.com","Madrid",57,"Gonzalez",678558855);
        admin.ListadoPersonal(jefe);
        Comercial comercial = new Comercial("Jose Luis","joseluis@muebles.com","Caceres",40,2);
        admin.ListadoPersonal(comercial);
        ArtesanoContrato artesanoContratado = new ArtesanoContrato("Maria","maria@muebles.com","Madrid",35,1,2);
        admin.ListadoPersonal(artesanoContratado);
        ArtesanoPorHoras artesanoSubcontrato = new ArtesanoPorHoras("Mario","mario@muebles.com","Madrid",26,2,60);
        admin.ListadoPersonal(artesanoSubcontrato);
        Empresa empresa = new Empresa("Tiendas Rodriguez","tiendas.rodriguez@gmail.com","Barcelona",1,15);
        admin.ListadoCliente(empresa);
        Persona persona = new Persona("Sonia","sonia.perez@gmail.com","Madrid",1,29);
        admin.ListadoCliente(persona);
        
        //Cargar menu
        mostrarMenu();
        
    }
}

