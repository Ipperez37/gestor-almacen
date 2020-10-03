import javax.swing.JOptionPane;
/**
 * Write a description of class Empleado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Empleado extends Personas implements Admin
{
    protected int edad;
    
    public Empleado(String nombre, String correo, String ciudad){
        super(nombre, correo, ciudad);
        
    }
    public Empleado(String nombre, String correo, String ciudad, int edad){
        super(nombre, correo, ciudad);
        this.edad = edad;
    }
    
        
    //abstract public double calcularSueldo();
    
    
    
    public int getEdad(){
        return  edad;
    }
    
     public void setEdad(int edad){
        edad=edad;
    }
     @Override
    public String toString() {
        // TODO Auto-generated method stub
        return   super.toString() +
                "\n Edad: " + getEdad();
               
                
    }
    
    public void SetDarDeAlta(){
        setEdad(edad=Integer.parseInt(JOptionPane.showInputDialog(null,"Indica la edad: ")));        
            
        
    }
    public void SetActualizadorDatos(){
       char  tipo = JOptionPane.showInputDialog(null,  "¿Desea modificar la edad? \"s\" si,  \"n\" no:").charAt(0);
       if(tipo == 's'){
           setEdad(edad=Integer.parseInt(JOptionPane.showInputDialog(null,"Edad actual: " + getEdad() + " . Indica la edad: ")));        
       }
       
    }
    
    
    
}
