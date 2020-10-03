import java.util.*;
import javax.swing.JOptionPane;
/**
 * Write a description of class MesaComedor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MesaComedor extends Mesa implements Informes
{
    private boolean cristal;
    private String nombre;
    
     public MesaComedor( int al, int an, int l, int c,int tablero, String nombre){
        super(al,an,l,c,tablero,nombre);
        this.nombre = nombre; 
    }
    
    public MesaComedor( int al, int an, int l, int c,int tablero, String nombre, boolean cristal ){
        super( al,an,l,c,tablero, nombre);
        this.cristal = true;
        this.nombre = nombre; 
    }
    
    public double calcularPrecioFinal(){
        return precioBase;    
    }
    
      public void  ListarPrecioFinal(){
        System.out.println("El precio de la mesa de cafe es: " + calcularPrecioFinal());
    }
     public void setCristal(boolean cristal){
           cristal = cristal;
    }
    public boolean getCristal(){
        return  cristal;
    }
    
    public void setNombre(String Nombre){
           nombre = Nombre;
    }
    public String getNombre(){
        return  nombre;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return   "Mesa Comedor:" +
                "\n Nombre:"+ getNombre() +  
                 super.toString()+
                "\n Nº de cristales: " + getCristal();
                
    }
      public void SetDatos(){
        super.SetDatos();
        setNombre(nombre=JOptionPane.showInputDialog(null,"Indica el nombre: "));
        String quiere =JOptionPane.showInputDialog(null,"Añadir cristal (SI/NO):");
        
       if(quiere.toUpperCase() == "SI"){
           setCristal(true);
        }else{
            setCristal(false);
        }
       
        
     }
     
     public void SetActualizarDatos(){
       super.SetActualizarDatos();
       
       char tipo = JOptionPane.showInputDialog(null,"¿Desea modificar el nombre? \"s\" , \"n\" :").charAt(0); 
       if(tipo == 's'){
         setNombre(nombre=JOptionPane.showInputDialog(null,"Nombre actual" + getNombre() + " .Indica el nombre: "));
       }
       
       tipo = JOptionPane.showInputDialog(null,"¿Desea modificar el cristal (SI/NO)? \"s\" , \"n\" :").charAt(0);
       if(tipo == 's'){
         setCristal((true));
       }
     }
}

