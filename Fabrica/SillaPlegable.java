import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 * Write a description of class SillaPlegable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SillaPlegable extends Silla implements Informes
{
    private int muelles;
    private String nombre;
        
    public SillaPlegable(int al, int an, int l, int c, String nombre, int patas, int muelles){
      super(al,an,l,c, nombre, patas);
      this.muelles = muelles;
      this.nombre = nombre; 
    }
    
    public void setMuelles(int muelles){
     muelles = muelles;   
    }
    public int getMuelles(){
      return muelles;
    }
    
    public double calcularPrecioFinal(){
        return precioBase;    
    }
      public void  ListarPrecioFinal(){
        System.out.println("El precio de la mesa de cafe es: " + calcularPrecioFinal());
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
        return  "Silla Plegable" +
                "\n Nombre:"+ getNombre() +  
                 super.toString() +
                "\n Nº de muelles: " + getMuelles();
               
                
    }
    public void SetDatos(){
        super.SetDatos();
        setNombre(nombre=JOptionPane.showInputDialog(null,"Indica el nombre: "));
        setMuelles(muelles=Integer.parseInt(JOptionPane.showInputDialog(null,"Indica cantidad muelles (int): ")));
    }
    
    public void SetActualizarDatos(){
       super.SetActualizarDatos();
       
       char tipo = JOptionPane.showInputDialog(null,"¿Desea modificar el nombre? \"s\" , \"n\" :").charAt(0); 
       if(tipo == 's'){
         setNombre(nombre=JOptionPane.showInputDialog(null,"Nombre actual" + getNombre() + " .Indica el nombre: "));
       }
       
       tipo = JOptionPane.showInputDialog(null,"¿Desea modificar el nº de muelles? \"s\" , \"n\" :").charAt(0);
       if(tipo == 's'){
         setMuelles(muelles=Integer.parseInt(JOptionPane.showInputDialog(null,"Nº de muelles actual: " + getMuelles() + " .Indica cantidad muelles (int): ")));
       }
     }
}

  
