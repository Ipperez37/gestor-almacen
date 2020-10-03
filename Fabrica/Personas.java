import javax.swing.JOptionPane;
/**
 * Abstract class Personas - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class Personas implements Admin
{
    private String nombre;
    private String correo;
    private String ciudad;
    
    public Personas(){}
    
    public Personas(String nombre, String correo, String ciudad){
        nombre=nombre;
        correo=correo;
        ciudad=ciudad;
    }
  
       
    public void setNombres(String nombre){
        nombre=nombre;
    }
    
    public String getNombres(){
        return nombre;
    }
    
    public void setCiudades(String ciudad){
        ciudad=ciudad;
    }
    
    public String getCiudades(){
        return ciudad;
    }
    public void setCorreos(String correo){
        correo=correo;
    }
    
    public String getCorreos(){
        return correo;
    }
    
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return  "\n Nombre: " + getNombres() +
                "\n Ciudad: " + getCiudades() + 
                "\n Correo: " + getCorreos() ;
               
                
    }
    
    public abstract void SetDarDeAlta();
           
                
    
    public abstract void SetActualizadorDatos();
}
