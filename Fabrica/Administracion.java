import java.util.*;
import javax.swing.JOptionPane;
/**
 * Write a description of class Almacen here.
 * Aqui se guardara el stock de los muebles que se estén fabricando
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Administracion 
 
{
    private static ArrayList<Empleado> personal;
    private static ArrayList<Cliente> clientes;
    private ArrayList<Cliente> ClienteRetorno;
    private int tamaño;
    
    public Administracion(){
        personal = new ArrayList<Empleado> ();
        clientes = new ArrayList<Cliente>();
    }
    
    //Añade los primeros registros de las clases personal,
    //en el momento que se ejecuta la aplicación
    public void ListadoPersonal(Empleado e){
        personal.add(e);
    }
    //Añade los primeros registros de las clases cliente,
    //en el momento que se ejecuta la aplicación
    public void ListadoCliente(Cliente e){
        clientes.add(e);
    }
    
    //en este método se añade los distintos tipos de personal que existe.
    public void AñadirPersonal(Empleado e){
        boolean existe = false;
        for (int i = 0; i < personal.size(); i++) 
        {
            if(String.valueOf(e.getNombres()).equals(personal.get(i).getNombres()))
            {
                existe = true;
            }
        }  
        if(existe == true)
        {
                JOptionPane.showMessageDialog(null,"La persona indicada no se ha creado porque ya existe");
        }else{
                personal.add(e);
                JOptionPane.showMessageDialog(null,"Personal creado correctamente");
        }
    }
    //en este método se añade los distintos tipos de personal que existe.
    public void AñadirCliente(Cliente e){
        boolean existe = false;
        for (int i = 0; i < clientes.size(); i++) 
        {
            if(String.valueOf(e.getNombres()).equals(clientes.get(i).getNombres()))
            {
                existe = true;
            }
        }  
        if(existe == true)
        {
                JOptionPane.showMessageDialog(null,"El cliente indicado no se ha creado porque ya existe");
        }else{
                clientes.add(e);
                JOptionPane.showMessageDialog(null,"Cliente creado correctamente");
        }
    }
    
    //Este método devuelve el cliente que se añadirá a cada pedido. 
    //Para acceder a él hay que buscarlo por el nombre con el que se creo.
    public Cliente getDevolverCliente(){
        String nombreBuscar = JOptionPane.showInputDialog(null,"Indica el nombre del cliente que desea buscar: ");
        for (Cliente c: clientes)
        {
                
             if(String.valueOf(nombreBuscar).equals(c.getNombres()) )
                { 
                    if (c instanceof Empresa){
                        JOptionPane.showMessageDialog(null,c); 
                        return ((Empresa)c);
                    }
                    if (c instanceof Persona){
                        return ((Persona)c);
                    }
                                    
                } 
                
        }
         return null;    
    }
    //retorna el arraylist para gestionar los pedidos
    public static  ArrayList<Cliente> getClientes() {
      return clientes;
    }
    //retorna los empleados para poder gestionar la asignación de pedidos
    public static  ArrayList<Empleado> getPersonal() {
      return personal;
    }
    //Elimina el registro que se indique por nombre en relación al personal.
    //Búsqueda  por nombre
    public void DarBajaPersonal(String nombreEliminar){
        boolean encontrado = false;
           for (int i = 0; i < personal.size(); i++) {
                                      
                if(String.valueOf(nombreEliminar).equals(personal.get(i).getNombres()) )
                {   
                       personal.remove(personal.get(i)); 
                       encontrado = true;
                       i--;
                       JOptionPane.showMessageDialog(null,"Registro eliminado correctamente");
                }
           }
        if (encontrado == false){
            JOptionPane.showMessageDialog(null,"Registro no encontrado");
        }
    }
    
    //Elimina el registro que se indique por nombre en relación al cliente. 
    //Búsqueda  por nombre
    public void DarBajaCliente(String nombreEliminar){
        boolean encontrado = false;
           for (int i = 0; i < clientes.size(); i++) {
                                      
                if(String.valueOf(nombreEliminar).equals(clientes.get(i).getNombres()) )
                {   
                       clientes.remove(clientes.get(i)); 
                       encontrado = true;
                       i--;
                       JOptionPane.showMessageDialog(null,"Registro eliminado correctamente");
                }
           }
        if (encontrado == false){
            JOptionPane.showMessageDialog(null,"Registro no encontrado");
        }
    }
    //Muestra todo el personal que hay registrado
    public void BuscarInfoPersonal(){
        if (personal.isEmpty())
       {    
           JOptionPane.showMessageDialog(null,"No hay ningún usuario con este nombre");
       }else{
            for (Personas m: personal)
            {
             JOptionPane.showMessageDialog(null,m);
            }
       }
    }
    //Muestra todos los clientes que hay registrado
    public void BuscarInfoCliente(){
        if (clientes.isEmpty())
       {    
           JOptionPane.showMessageDialog(null,"No hay ningún usuario con este nombre");
       }else{
            for (Cliente m: clientes)
            {
             JOptionPane.showMessageDialog(null,m);
            }
       }
    }
    //Realiza una búsqueda por nombre, en este caso del personal.
    public void ConsultarPersona(String nombre){
        boolean encontrado = false;
        for (int i = 0; i < personal.size(); i++)
        {
            if(String.valueOf(nombre).equals(personal.get(i).getNombres()) )
            {   
                    JOptionPane.showMessageDialog(null,personal.get(i));
                    encontrado = true;
            }
         
        }
        if (encontrado == false){
            JOptionPane.showMessageDialog(null,"Registro no encontrado");
        }
    }
    //Realiza una búsqueda por nombre, en este caso del cliente.
    public void ConsultarCliente(String nombre){
        boolean encontrado = false;
        for (int i = 0; i < clientes.size(); i++)
        {
            if(String.valueOf(nombre).equals(clientes.get(i).getNombres()) )
            {   
                    JOptionPane.showMessageDialog(null,clientes.get(i));
                    encontrado = true;
            }
         
        }
        if (encontrado == false){
            JOptionPane.showMessageDialog(null,"Registro no encontrado");
        }
    }
    
    //Actualiza cada atributo de cada clase cliente.
    //La búsqueda del artículo se hace por nombre       
    public void ActualizarDatosCliente(String nombre){
       boolean encontrado = false; 
            
      for (Cliente c: clientes){
            if(String.valueOf(nombre).equals(c.getNombres())){
            encontrado=true;
                if (c instanceof Persona ){
                    ((Persona)c).SetActualizadorDatos();
                    JOptionPane.showMessageDialog(null,"Datos actualizados " + ((Persona)c). toString());
                }
                
                if (c instanceof Empresa ){
                    ((Empresa)c).SetActualizadorDatos();
                    JOptionPane.showMessageDialog(null,"Datos actualizados " + ((Empresa)c). toString());
                }
            }
      }
       
      if (encontrado == false)
        {
        JOptionPane.showMessageDialog(null,"Cliente no encontrado\n");   
      } 
    }
    //Actualiza cada atributo de cada clase personal.
    //La búsqueda del artículo se hace por nombre 
    public void ActualizarDatosPersonal(String nombre){
       boolean encontrado = false; 
            
      for (Empleado p: personal){
            if(String.valueOf(nombre).equals(p.getNombres())){
            encontrado=true;
                if (p instanceof Jefe ){
                    ((Jefe)p).SetActualizadorDatos();
                    JOptionPane.showMessageDialog(null,"Datos actualizados " + ((Jefe)p). toString());
                }
                
                if (p instanceof Comercial ){
                    ((Comercial)p).SetActualizadorDatos();
                    JOptionPane.showMessageDialog(null,"Datos actualizados " + ((Comercial)p). toString());
                }
                
                if (p instanceof ArtesanoContrato ){
                    ((ArtesanoContrato)p).SetActualizadorDatos();
                    JOptionPane.showMessageDialog(null,"Datos actualizados " + ((ArtesanoContrato)p). toString());
                }
                
                if (p instanceof ArtesanoPorHoras ){
                    ((ArtesanoPorHoras)p).SetActualizadorDatos();
                    JOptionPane.showMessageDialog(null,"Datos actualizados " + ((ArtesanoPorHoras)p). toString());
                }
            }
      }
       
      if (encontrado == false)
        {
        JOptionPane.showMessageDialog(null,"Cliente no encontrado\n");   
      } 
    }
}
