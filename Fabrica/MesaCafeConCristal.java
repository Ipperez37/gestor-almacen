import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 * Write a description of class MesaCafeConCristal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MesaCafeConCristal extends MesaCafe
{   
    private int numCristal;
    private String nombre;
    public MesaCafeConCristal( int al, int an, int l, int c, int tablero, String nombre, int numRuedas, int numCristal){
        super(al,an,l,c,tablero,nombre,numRuedas);
        this.numCristal = numCristal;
        this.nombre = nombre; 
    }
        
     public double calcularPrecioFinal(){
        return precioBase;    
    }
    
    public void setNumCristales(int cristales){
        numCristal=cristales;
    }
    
    public int getNumCristales(){
        return  numCristal;
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
        return  "Mesa cafe Con Cristal:" + 
                 super.toString()+
                "\n Nº de cristales: " + getNumCristales();
                
    }
    public void SetDatos(){
        super.SetDatos();
        setNombre(nombre=JOptionPane.showInputDialog(null,"Indica el nombre: "));
        setNumCristales(numCristal=Integer.parseInt(JOptionPane.showInputDialog(null,"Indica cant. cristales (int): ")));
        
    }
    
    public void SetActualizarDatos(){
       super.SetActualizarDatos();
       
       char tipo = JOptionPane.showInputDialog(null,"¿Desea modificar el nombre? \"s\" , \"n\" :").charAt(0);
       if(tipo == 's'){
         setNombre(nombre=JOptionPane.showInputDialog(null,"Nombre actual" + getNombre() + " .Indica el nombre: "));
       }
       
       tipo = JOptionPane.showInputDialog(null,"¿Desea modificar el nº de cristales? \"s\" , \"n\" :").charAt(0);
       if(tipo == 's'){
         setNumCristales(numCristal=Integer.parseInt(JOptionPane.showInputDialog(null,"Nº cristales actual: " + getNumCristales() + " .Indica cant. cristales (int): ")));
       }
     }
}
