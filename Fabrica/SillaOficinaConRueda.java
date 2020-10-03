import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 * Write a description of class SillaOficinaConRueda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SillaOficinaConRueda extends SillaOficina
{
    private int numRuedas;
    private String nombre;
    public SillaOficinaConRueda(int al, int an, int l, int c, String nombre, int patas,int apoyaBrazos, int numRuedas){
      super(al,an,l,c, nombre, patas,apoyaBrazos);
      this.numRuedas=numRuedas;
      this.nombre = nombre; 
    }
    
    public void setNumRuedas(int numeroRuedas)
    {
        numRuedas = numeroRuedas;
    }
    
    public int getNumRuedas(){
      return numRuedas;
    }
    
    public double calcularPrecioFinal(){
        return precioBase;    
    }
        
    public void  ListarPrecioFinal(){
        System.out.println("El precio de la silla de oficina con ruedas es: " + calcularPrecioFinal());
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
        return  "Silla oficina con ruedas" +
                 super.toString() +
                "\n Nº de ruedas: " + getNumRuedas();
               
                
    }
    public void SetDatos(){
        super.SetDatos();
        setNombre(nombre=JOptionPane.showInputDialog(null,"Indica el nombre: "));
        setNumRuedas(numRuedas=Integer.parseInt(JOptionPane.showInputDialog(null,"Indica cantidad de ruedas (int): ")));
    }
    
    public void SetActualizarDatos(){
       super.SetActualizarDatos();
       
       char tipo = JOptionPane.showInputDialog(null, "¿Desea modificar el nombre? \"s\" , \"n\" :").charAt(0); 
       if(tipo == 's'){
         setNombre(nombre=JOptionPane.showInputDialog(null,"Nombre actual" + getNombre() + " .Indica el nombre: "));
       }
       
       tipo = JOptionPane.showInputDialog(null, "¿Desea modificar el nº de ruedas? \"s\" , \"n\" :").charAt(0); 
       if(tipo == 's'){
         setNumRuedas(numRuedas=Integer.parseInt(JOptionPane.showInputDialog(null,"Nº de ruedas actual: " + getNumRuedas()  + " .Indica cantidad de ruedas (int): ")));
       }
     }
}
