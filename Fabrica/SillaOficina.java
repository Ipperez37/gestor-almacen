import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 * Write a description of class SillaOficina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SillaOficina extends Silla implements Informes
{
    
    private int apoyaBrazos;
    private String nombre;
        
    public SillaOficina(int al, int an, int l, int c, String nombre, int patas,int apoyaBrazos){
      super( al,an,l,c, nombre, patas);
      this.apoyaBrazos=apoyaBrazos;
      this.nombre = nombre; 
    }
    
    public void setApoyaBrazos(int apoyaBrazos){
     apoyaBrazos= apoyaBrazos;
    }
    public int getApollabrazos(){
      return apoyaBrazos;
    }
        
    public double calcularPrecioFinal(){
        return precioBase;    
    }
    
      public void  ListarPrecioFinal(){
        System.out.println("El precio de la silla de oficina es: " + calcularPrecioFinal());
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
        return  
                "\n Nombre:" + getNombre() +
                super.toString() +
                "\n Nº de apoyabrazos: " + getApollabrazos();
               
                
    }
    
    public void SetDatos(){
        super.SetDatos();
        setApoyaBrazos(apoyaBrazos=Integer.parseInt(JOptionPane.showInputDialog(null,"Indica cantidad apoyabrazos (int): ")));
    }
    
    public void SetActualizarDatos(){
       super.SetActualizarDatos();
       
       char tipo = JOptionPane.showInputDialog(null,"¿Desea modificar el nº de apoyabrazos ? \"s\" , \"n\" :").charAt(0); 
       if(tipo == 's'){
         setApoyaBrazos(apoyaBrazos=Integer.parseInt(JOptionPane.showInputDialog(null,"Nº de apoyabrazos actual: " + getApollabrazos() +  " .Indica cantidad apoyabrazos (int): ")));
       }
     }
}
