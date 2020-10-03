import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 * Write a description of class MesaCafe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MesaCafe extends Mesa implements Informes
{
    public final int DESCUENTO=5;
    private int numRuedas;
    private String nombre;
    ArrayList<MesaCafe> MesaDeCafe = new ArrayList();                                                                                                                                                                      
    
    public MesaCafe( int al, int an, int l, int c, int tablero, String nombre, int numRuedas){
        super(al,an,l,c,tablero,nombre);
        this.numRuedas=numRuedas;
        this.nombre = nombre;  
    }
    
    
    public double calcularPrecioFinal(){
        return precioBase-(precioBase*DESCUENTO/100);    
    }
    
    public void  ListarPrecioFinal(){
        System.out.println("El precio de la mesa de cafe es: " + calcularPrecioFinal());
    }
        
    public void setRuedas(int rueda){
           numRuedas = rueda;
    }
    public int getRuedas(){
        return  numRuedas;
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
        return   "\n Nombre:" + getNombre() +  
                 super.toString()+
                 "\n Nº ruedas (int): " + getRuedas();
                
    }
    public void SetDatos(){
        super.SetDatos();
        setRuedas(numRuedas=Integer.parseInt(JOptionPane.showInputDialog(null,"Indica el numero de ruedas (int): ")));
    
    }
    
    public void SetActualizarDatos(){
       super.SetActualizarDatos();
       
       char tipo = JOptionPane.showInputDialog(null,"¿Desea modificar el nº de ruedas? \"s\" si,  \"n\" no:").charAt(0); 
       if(tipo == 's'){
         setRuedas(numRuedas=Integer.parseInt(JOptionPane.showInputDialog(null,"Nº ruedas actual: " + getRuedas() + " .Indica el numero de ruedas (int): ")));
       }
     }
   
}
