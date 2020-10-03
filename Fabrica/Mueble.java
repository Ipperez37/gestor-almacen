import javax.swing.JOptionPane;
import java.util.*;
/**
 * Abstract class Mueble - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class Mueble implements Informes
{
    protected double precioBase;
    private int largo,ancho,alto;
    private int numColor;
    private double precioFinal;
    private String nombre;
    private ArrayList<Mueble> muebles;
   
    
    public Mueble( int al, int l, int an, int c,String nombre){
      
      largo=l;
      ancho=an;
      alto=al;
      numColor=c;
      nombre=nombre;
    }
    
    abstract public double calcularPrecioFinal();
    
    public double getPrecioBase(){
     return precioBase;
    
    }
    
    public void setPrecioBase(double preciob){
     precioBase=preciob;
    }
    
      
    public void ListarCaracteristicas(){
        System.out.println("Largo / ancho / alto : " + getLargo() + " / " + getAncho() +" / "+ getAlto());
        System.out.println("El color : " + getColor());
    }
    
    public void setLargo(int LargoMesa){
     largo= LargoMesa;
    }
    public int getLargo(){
     return largo;
    }
     public void setAlto(int AltoMesa){
     alto=AltoMesa;
    }
    
    public int getAlto(){
     return alto;
    }
     public void setAncho(int AnchoMesa){
     ancho=AnchoMesa;
    }
    
    public int getAncho(){
     return ancho;
    }
    
     public void setColor(int ColorMesa){
     numColor=ColorMesa;
    }
    
    public int getColor(){
     return numColor;
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
        return  "\n Altura: " +getAlto() +
                "\n Ancho: " + getAncho() + 
                "\n Largo: " + getLargo() + 
                "\n Color: " + getColor();
               
                
    }
    
    public void SetDatos(){
        setLargo(largo=Integer.parseInt(JOptionPane.showInputDialog(null,"Indica el largo: ")));        
        setAncho(ancho=Integer.parseInt(JOptionPane.showInputDialog(null,"Indica el ancho: ")));
        setAlto(alto=Integer.parseInt(JOptionPane.showInputDialog(null,"Indica el alto: ")));
        setColor(numColor=Integer.parseInt(JOptionPane.showInputDialog(null,"Indica el color: ")));
        
    }
    public void SetActualizarDatos(){
       
       char  tipo = JOptionPane.showInputDialog(null,  "¿Desea modificar el largo? \"s\" si,  \"n\" no:").charAt(0);
       if(tipo == 's'){
           setLargo(largo=Integer.parseInt(JOptionPane.showInputDialog(null,"Largo actual: "+ getLargo() + ". Indica el largo: "))); 
       }
          tipo = JOptionPane.showInputDialog(null,  "¿Desea modificar el ancho? \"s\" si,  \"n\" no:").charAt(0);
       if(tipo == 's'){
           setAncho(ancho=Integer.parseInt(JOptionPane.showInputDialog(null,"Ancho actual: " + getAncho() + " .Indica el ancho: ")));
       }
          tipo = JOptionPane.showInputDialog(null,  "¿Desea modificar el alto? \"s\" si,  \"n\" no:").charAt(0);
       if(tipo == 's'){
           setAlto(alto=Integer.parseInt(JOptionPane.showInputDialog(null,"Alto actual: " + getAlto() + " .Indica el alto: ")));
       }
         tipo = JOptionPane.showInputDialog(null,  "¿Desea modificar el tipo de color? \"s\" si,  \"n\" no:").charAt(0);
       if(tipo == 's'){
         setColor(numColor=Integer.parseInt(JOptionPane.showInputDialog(null,"Color actual " + getColor()  + " .Indica el color: ")));  
        }
    }
    
 
}
