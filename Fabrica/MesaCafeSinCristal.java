import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 * Write a description of class MesaCafeSinCristal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MesaCafeSinCristal extends MesaCafe
{
    private int flexo;
    private String nombre;
    
    public MesaCafeSinCristal( int al, int an, int l, int c, int tablero, String nombre, int numRuedas, int flexo){
        super(al,an,l,c,tablero,nombre,numRuedas);
        this.flexo=flexo;
        this.nombre = nombre; 
    }
    
     public double calcularPrecioFinal(){
        return precioBase;    
    }
    
     public void setFlexo(int flexo){
        flexo=flexo;
    }
    
    public int getFlexo(){
        return  flexo;
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
        return  "Mesa cafe sin cristal:" + 
                 super.toString()+
                "\n Cantidad Flexo: " + getFlexo();
                
    }
    public void SetDatos(){
        super.SetDatos();
        setNombre(nombre=JOptionPane.showInputDialog(null,"Indica el nombre: "));
        setFlexo(flexo=Integer.parseInt(JOptionPane.showInputDialog(null,"Indica cant. flexo (int): ")));
        
    }
    
    public void SetActualizarDatos(){
       super.SetActualizarDatos();
       
        char tipo = JOptionPane.showInputDialog(null, "¿Desea modificar el nombre? \"s\" , \"n\" :").charAt(0);
         if(tipo == 's'){
         setNombre(nombre=JOptionPane.showInputDialog(null,"Nombre actual" + getNombre() + " .Indica el nombre: "));
       }
       
         tipo = JOptionPane.showInputDialog(null, "¿Desea modificar el nº del flexo? \"s\" , \"n\" :").charAt(0);
         if(tipo == 's'){
         setFlexo(flexo=Integer.parseInt(JOptionPane.showInputDialog(null,"Nº flexo actual: " + getFlexo() +  " .Indica cant. flexo (int): ")));
       }
     }
}
