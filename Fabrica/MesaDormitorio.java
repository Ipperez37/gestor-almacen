import java.util.*;
import javax.swing.JOptionPane;
/**
 * Write a description of class MesaDormitorio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MesaDormitorio extends Mesa implements Informes
{
     private int  numCajones;
     private String nombre;
     public MesaDormitorio( int al, int an, int l, int c, int tablero, String nombre){
        super(al,an,l,c, tablero, nombre);
        this.numCajones = 0;
        this.nombre = nombre; 
     }
    
    public MesaDormitorio (int id, int al, int an, int l, int c, int tablero, String nombre,  int numCajones ){
        super( al,an,l,c, tablero, nombre);
        this.numCajones = numCajones;
        this.nombre = nombre; 
    }
    
    public double calcularPrecioFinal(){
        return precioBase;    
    }
    
    public void ListarPrecioFinal(){
        System.out.println("El precio de la mesa de dormitorio es: " + calcularPrecioFinal());
    }
    
    public void  ListarCaracteristicas(){
        System.out.println("Las caracteristicas de la mesa de dormitorio son: ");
        
        super.ListarCaracteristicas();
        System.out.println("Numero de cajones: " + getCajones());
        //System.out.println(encimeraCristal?"Con cristal":"Sin cristal");
       

    }
    
    public void setCajones(int nCajon){
        numCajones=nCajon;
    }
    
    public int getCajones(){
        return  numCajones;
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
        return   "Mesa Dormitorio:" +
                "\n Nombre:"+ getNombre() +  
                 super.toString()+
                "\n Nº cajones: " + getCajones();
                
    }
    
    public void SetDatos(){
        super.SetDatos();
        setNombre(nombre=JOptionPane.showInputDialog(null,"Indica el nombre: "));
        setCajones(numCajones=Integer.parseInt(JOptionPane.showInputDialog(null,"Indica cant. cajones (int): ")));
    }
    
    public void SetActualizarDatos(){
       super.SetActualizarDatos();
       
       char tipo = JOptionPane.showInputDialog(null,"¿Desea modificar el nombre? \"s\" , \"n\" :").charAt(0); 
       if(tipo == 's'){
         setNombre(nombre=JOptionPane.showInputDialog(null,"Nombre actual" + getNombre() + " .Indica nombre: "));
       }
       
       tipo = JOptionPane.showInputDialog(null,"¿Desea modificar el nº de cajones? \"s\" , \"n\" :").charAt(0); 
       if(tipo == 's'){
         setCajones(numCajones=Integer.parseInt(JOptionPane.showInputDialog(null,"Indica cant. cajones (int): ")));
       }
    }
    
    
}
