import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 * Write a description of class SillaOficinaSinRueda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SillaOficinaSinRueda extends SillaOficina
{
    private int tacosPata;
    private String nombre;
    public SillaOficinaSinRueda(int al, int an, int l, int c, String nombre, int patas,int apoyaBrazos,int tacosPata){
      super(al,an,l,c,nombre, patas,apoyaBrazos);
      this.tacosPata = tacosPata;
      this.nombre = nombre; 
    }
    
    public void setTacos(int tacosPataoRuedas)
    {
        tacosPata = tacosPata;
    }
    
    public int getTacos(){
      return tacosPata;
    }
    
    public double calcularPrecioFinal(){
        return precioBase;    
    }
    
     public void  ListarPrecioFinal(){
        System.out.println("El precio de la silla de oficina sin ruedas es: " + calcularPrecioFinal());
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
        return   "Silla oficina sin ruedas" + 
                 super.toString() +
                "\n Nº de tacos: " + getTacos();
               
                
    }
    public void SetDatos(){
        super.SetDatos();
        setNombre(nombre=JOptionPane.showInputDialog(null,"Indica el nombre: "));
        setTacos(tacosPata=Integer.parseInt(JOptionPane.showInputDialog(null,"Indica cant. tacos (int): ")));
        
    }
    
    public void SetActualizarDatos(){
       super.SetActualizarDatos();
       
        char tipo = JOptionPane.showInputDialog(null,"¿Desea modificar el nombre? \"s\" , \"n\" :").charAt(0); 
       if(tipo == 's'){
         setNombre(nombre=JOptionPane.showInputDialog(null,"Nombre actual" + getNombre() + " .Indica el nombre: "));
       }
       
       tipo = JOptionPane.showInputDialog(null,"¿Desea modificar el nº de tacos ? \"s\" , \"n\" :").charAt(0);
       if(tipo == 's'){
         setTacos(tacosPata=Integer.parseInt(JOptionPane.showInputDialog(null,"Nº tacos actual:  " + getTacos() + " .Indica cant. tacos (int): ")));
       }
     }
}
