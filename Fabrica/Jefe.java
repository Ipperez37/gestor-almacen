import javax.swing.JOptionPane;
/**
 * Clase que define al jefe y sus metodos
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jefe extends Empleado 
{
    private int telefono;
    private String nombre;
    private String correo;
    private String ciudad;
    public Jefe(String nombre, String correo, String ciudad, int edad, String apellido,int telefono){
        super(nombre, correo, ciudad, edad);
        this.telefono=telefono;
        this.nombre=nombre;
        this.correo=correo;
        this.ciudad=ciudad;
       
        
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
    
    public void setTelefono(int telefono){
     telefono = telefono;
    }
    
    public int getTelefono(){
      return telefono;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return  "\n Jefe:" + 
                 super.toString() +
                "\n Teléfono: " + getTelefono();
                
    }
    public void SetDarDeAlta(){
        
        setNombres(nombre=JOptionPane.showInputDialog(null,"Indica el nombre: "));        
        setCiudades(ciudad=JOptionPane.showInputDialog(null,"Indica la ciudad: "));
        setCorreos(correo=JOptionPane.showInputDialog(null,"Indica el correo: "));
        setTelefono(telefono=Integer.parseInt(JOptionPane.showInputDialog(null,"Indica el telefono: ")));        
        super.SetDarDeAlta();    
        
    }
    
    public void SetActualizadorDatos(){
       
       char  tipo = JOptionPane.showInputDialog(null,  "¿Desea modificar el nombre? \"s\" si,  \"n\" no:").charAt(0);
       if(tipo == 's'){
           setNombres(nombre=JOptionPane.showInputDialog(null,"Nombre actual: "+ getNombres() + ". Indica el nombre: ")); 
       }
          tipo = JOptionPane.showInputDialog(null,  "¿Desea modificar la ciudad? \"s\" si,  \"n\" no:").charAt(0);
       if(tipo == 's'){
           setCiudades(ciudad=JOptionPane.showInputDialog(null,"Ciudad actual: "+ getCiudades() + ". Indica la ciudad: ")); 
       }
         tipo = JOptionPane.showInputDialog(null,  "¿Desea modificar el correo? \"s\" si,  \"n\" no:").charAt(0);
       if(tipo == 's'){
           setCorreos(correo=JOptionPane.showInputDialog(null,"Correo actual: "+ getCorreos() + ". Indica el correo: ")); 
       }
       tipo = JOptionPane.showInputDialog(null,  "¿Desea modificar el teléfono? \"s\" si,  \"n\" no:").charAt(0);
       if(tipo == 's'){
           setTelefono(telefono=Integer.parseInt(JOptionPane.showInputDialog(null,"Teléfono actual: " + getTelefono() + " . Indica el teléfono: ")));        
       }
       super.SetActualizadorDatos();
    }
}