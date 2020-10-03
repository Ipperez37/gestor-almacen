import java.util.*;
import javax.swing.JOptionPane;
/**
 * Write a description of class Almacen here.
 * Aqui se guardara el stock de los muebles que se estén fabricando
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Almacen 
 
{
    private static  ArrayList<Mueble> muebles;
    private ArrayList<Mueble> mueblesPedido;
    private int tamaño;
    
    public Almacen(){
        muebles = new ArrayList<Mueble> ();
    }
    
    public void CargarCatalogo(Mueble e){
        muebles.add(e);
    }
    
    public static  ArrayList<Mueble> getMuebles() {
      return muebles;
    }
    
    //retorna el mueble que se va a insertar en el pedido.
    public static Mueble getDevolverMueble(){
        
        String nombreBuscar = JOptionPane.showInputDialog(null,"Indica el nombre del mueble que desea buscar: ");
        
        for (Mueble e: muebles)
            {
             if(String.valueOf(nombreBuscar).equals(e.getNombre()) )
                { 
                               
                    if (e instanceof MesaComedor){
                        return ((MesaComedor)e);
                    }
                    if (e instanceof MesaDormitorio){
                        return((MesaDormitorio)e);
                    }
                    if (e instanceof SillaCocina){
                        return((SillaCocina)e);
                    }
                    if (e instanceof SillaPlegable){
                       return ((SillaPlegable)e);
                    }
                    if (e instanceof MesaCafeConCristal){
                       return ((MesaCafeConCristal)e);
                    }
                    if (e instanceof MesaCafeSinCristal){
                        return((MesaCafeSinCristal)e);
                    }
                    if (e instanceof SillaOficinaConRueda){
                        return((SillaOficinaConRueda)e);
                    }
                    if (e instanceof SillaOficinaConRueda){
                        return((SillaOficinaConRueda)e);
                    }
                } 
            
         
        } 
        return null;    
    }
    
    //crea los muebles desde el menú añadiendo los atributos por pantalla.
    public void insertarMueble(Mueble e){
        boolean existe = false;
        for (int i = 0; i < muebles.size(); i++) 
        {
            if(String.valueOf(e.getNombre()).equals(muebles.get(i).getNombre()))
            {
                existe = true;
            }
        }  
        if(existe == true)
        {
                JOptionPane.showMessageDialog(null,"El mueble indicado no se ha creado porque ya existe");
        }else{
                muebles.add(e);
                JOptionPane.showMessageDialog(null,"Mueble creado correctamente");
        }
    }
    
    //Elimina  el mueble del catálogo del almacén. La búsqueda se hace por el nombre del mueble.
    public void EliminarMueble(String nombreEliminar){
        boolean encontrado = false;
           for (int i = 0; i < muebles.size(); i++) {
                                      
                if(String.valueOf(nombreEliminar).equals(muebles.get(i).getNombre()) )
                {   
                       muebles.remove(muebles.get(i)); 
                       encontrado = true;
                       i--;
                       JOptionPane.showMessageDialog(null,"Registro eliminado correctamente");
                }
           }
        if (encontrado == false){
            JOptionPane.showMessageDialog(null,"Registro no encontrado");
        }
    }
    //Lista todos los muebles creados en el almacén
    public void MostrarMueble(){
        if (muebles.isEmpty())
       {    
           JOptionPane.showMessageDialog(null,"No hay ningún mueble en el catalogo");
       }else{
            for (Mueble m: muebles)
            {
             JOptionPane.showMessageDialog(null,m);
            }
       }
    }
    
    //Consulta un mueble en específico, buscado por el atributo “nombre”. 
    public void ConsultarMueble(String nombre){
        boolean encontrado = false;
        for (int i = 0; i < muebles.size(); i++)
        {
            if(String.valueOf(nombre).equals(muebles.get(i).getNombre()) )
            {   
                    JOptionPane.showMessageDialog(null,muebles.get(i));
                    encontrado = true;
            }
         
        }
        if (encontrado == false){
            JOptionPane.showMessageDialog(null,"Registro no encontrado");
        }
    }
    
    //Actualiza los atributos de cada mueble ya creado en el almacén
    public void ActualizarAlmacen(String nombre){
       boolean encontrado = false; 
            
        for (Mueble e: muebles){
                  
            //realizar un instanceof de cada objeto
            if(String.valueOf(nombre).equals(e.getNombre()))
            {
            encontrado=true;
                if (e instanceof MesaComedor){
                    ((MesaComedor)e).SetActualizarDatos();
                    JOptionPane.showMessageDialog(null,"Datos actualizados " + ((MesaComedor)e). toString());
                }
                if (e instanceof MesaDormitorio){
                    ((MesaDormitorio)e).SetActualizarDatos();
                    JOptionPane.showMessageDialog(null,"Datos actualizados " + ((MesaDormitorio)e). toString());
                }
                if (e instanceof SillaCocina){
                    ((SillaCocina)e).SetActualizarDatos();
                    JOptionPane.showMessageDialog(null,"Datos actualizados " + ((SillaCocina)e). toString());
                }
                if (e instanceof SillaPlegable){
                    ((SillaPlegable)e).SetActualizarDatos();
                    JOptionPane.showMessageDialog(null,"Datos actualizados " + ((SillaPlegable)e). toString());
                }
                if (e instanceof MesaCafeConCristal){
                    ((MesaCafeConCristal)e).SetActualizarDatos();
                    JOptionPane.showMessageDialog(null,"Datos actualizados " + ((MesaCafeConCristal)e). toString());
                }
                if (e instanceof MesaCafeSinCristal){
                    ((MesaCafeSinCristal)e).SetActualizarDatos();
                    JOptionPane.showMessageDialog(null,"Datos actualizados " + ((MesaCafeSinCristal)e). toString());
                }
                if (e instanceof SillaOficinaConRueda){
                    ((SillaOficinaConRueda)e).SetActualizarDatos();
                    JOptionPane.showMessageDialog(null,"Datos actualizados " + ((SillaOficinaConRueda)e). toString());
                }
                if (e instanceof SillaOficinaConRueda){
                    ((SillaOficinaConRueda)e).SetActualizarDatos();
                    JOptionPane.showMessageDialog(null,"Datos actualizados " + ((SillaOficinaConRueda)e). toString());
                }
           }   
        
     
        }
        
       if (encontrado == false)
       {
        JOptionPane.showMessageDialog(null,"Mueble no encontrado\n");   
       } 
        
    }
    
    
       
    
    
}
