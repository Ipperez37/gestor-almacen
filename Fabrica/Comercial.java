import javax.swing.JOptionPane;
/**
 * Clase que define al vendedor y sus metodos
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Comercial extends Empleado
{
    private int TipoVehiculo;
    private String nombre;
    private String correo;
    private String ciudad;
    public Comercial(String nombre, String correo, String ciudad, int edad, int TipoVehiculo){
        super(nombre, correo, ciudad, edad);
        this.TipoVehiculo=TipoVehiculo;
        this.nombre=nombre;
        this.correo=correo;
        this.ciudad=ciudad;
    }
       
    public void setVehiculo(int TipoVehiculo){
     TipoVehiculo = TipoVehiculo;
    }
    public int getVehiculo(){
      return TipoVehiculo;
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
        return  "\n Comercial:" + 
                  super.toString() +
                "\n tipo Coche empresa: " + getVehiculo();
                
    }
    
    public void SetDarDeAlta(){
        
        setNombres(nombre=JOptionPane.showInputDialog(null,"Indica el nombre: "));        
        setCiudades(ciudad=JOptionPane.showInputDialog(null,"Indica la ciudad: "));
        setCorreos(correo=JOptionPane.showInputDialog(null,"Indica el correo: "));
        setVehiculo(TipoVehiculo=Integer.parseInt(JOptionPane.showInputDialog(null,"Indica tipo de vehiculo (int): ")));        
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
       tipo = JOptionPane.showInputDialog(null,  "¿Desea modificar el tipo vehiculo? \"s\" si,  \"n\" no:").charAt(0);
       if(tipo == 's'){
           setVehiculo(TipoVehiculo=Integer.parseInt(JOptionPane.showInputDialog(null,"Tipo de vehiculo actual: " + getVehiculo() + " . getVehiculo: ")));        
       }
       super.SetActualizadorDatos();
    }
}
