import javax.swing.JOptionPane;
/**
 * Write a description of class Persona here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Persona extends Cliente
{
    private int edad;
    private String correo;
    private String ciudad;
    private String nombre;
    public Persona(){}
    public Persona(String nombre, String correo, String ciudad,int tipoCliente, int edad){
        super(nombre, correo, ciudad, tipoCliente);
        this.edad=edad;
        this.nombre = nombre;
        this.correo = correo;
        this.ciudad = ciudad;
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
    
    public String getCorreos(){
        return correo;
    }
    
    public void setCorreos(String correo){
        correo=correo;
    }
    
    public void setEdad(int edad){
     edad = edad;
    }
    
    public int getEdad(){
      return edad;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return  "\n Persona:" + 
                 super.toString() +
                "\n Edad: " + getEdad();

                
    }
    
    public void SetDarDeAlta(){
        setNombres(nombre=JOptionPane.showInputDialog(null,"Indica el nombre: "));        
        setCiudades(ciudad=JOptionPane.showInputDialog(null,"Indica la ciudad: "));
        setCorreos(correo=JOptionPane.showInputDialog(null,"Indica el correo: "));
        setEdad(edad=Integer.parseInt(JOptionPane.showInputDialog(null,"Indica la edad: ")));        
        super.SetDarDeAlta();    
        
    }
    
    public void SetActualizadorDatos(){
       
       char tipo = JOptionPane.showInputDialog(null,  "¿Desea modificar el nombre? \"s\" si,  \"n\" no:").charAt(0);
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
       tipo = JOptionPane.showInputDialog(null,  "¿Desea modificar la edad? \"s\" si,  \"n\" no:").charAt(0);
       if(tipo == 's'){
           setEdad(edad=Integer.parseInt(JOptionPane.showInputDialog(null,"Edad actual: " + getEdad() + " . Indica la edad: ")));        
       }
       super.SetActualizadorDatos();
    }
}
