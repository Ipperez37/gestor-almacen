import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 * Write a description of class SillaCocina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SillaCocina extends Silla implements Informes
{
    private int material;
    private String nombre;
        
    public SillaCocina( int al, int an, int l, int c, String nombre, int patas, int material){
      super(al,an,l,c,nombre, patas);
      this.material=material;
      this.nombre = nombre; 
    }
    
        
    public double calcularPrecioFinal(){
        return precioBase;    
    }
    
      public void  ListarPrecioFinal(){
        System.out.println("El precio de la mesa de cafe es: " + calcularPrecioFinal());
    }
    
    public void setMaterial(int material){
     material= material;
    }
    public int getMaterial(){
     return material;
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
        return  "Silla Cocina" +
                "\n Nombre:"+ getNombre() +  
                 super.toString() +
                "\n Tipo material (int): " + getMaterial();
               
                
    }
    
     public void SetDatos(){
        super.SetDatos();
        setNombre(nombre=JOptionPane.showInputDialog(null,"Indica el nombre: "));
        setMaterial(material=Integer.parseInt(JOptionPane.showInputDialog(null,"Indica tipo material (int): ")));
    }
    
     public void SetActualizarDatos(){
       super.SetActualizarDatos();
       
       char tipo = JOptionPane.showInputDialog(null,"¿Desea modificar el nombre? \"s\" , \"n\" :").charAt(0); 
       if(tipo == 's'){
         setNombre(nombre=JOptionPane.showInputDialog(null,"Nombre actual" + getNombre() + " .Indica el nombre: "));
       }
       
       tipo = JOptionPane.showInputDialog(null,"¿Desea modificar el nº de material ? \"s\" , \"n\" :").charAt(0); 
       if(tipo == 's'){
         setMaterial(material=Integer.parseInt(JOptionPane.showInputDialog(null,"Nº de material actual: " + getMaterial() + " .Indica tipo material (int): ")));
       }
     }
}
