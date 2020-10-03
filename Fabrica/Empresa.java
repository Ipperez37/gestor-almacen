import javax.swing.JOptionPane;
/**
 * Write a description of class Empresa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Empresa extends Cliente
{   
     private int cantEmpleados;
     private String nombre;
     private String correo;
     private String ciudad;
     public Empresa(){}
     public Empresa(String nombre, String correo, String ciudad,int tipoCliente, int cantEmpleados){
        super(nombre, correo, ciudad, tipoCliente);
        this.cantEmpleados=cantEmpleados;
        this.nombre = nombre;
        this.correo = correo;
        this.ciudad = ciudad;
     }
    
    public void setNombres(String nombre){
        nombre= nombre;
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
        
    public void setCantEmpleados(int cantEmpleados){
     cantEmpleados = cantEmpleados;
    }
    
    public int getCantEmpleados(){
      return cantEmpleados;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return  "\n Empresa:" + 
                 super.toString() +
                "\n Nº de empleados: " + getCantEmpleados();

                
    }
    
    public void SetDarDeAlta(){
        
        setNombres(nombre=JOptionPane.showInputDialog(null,"Indica el nombre: "));        
        setCiudades(ciudad=JOptionPane.showInputDialog(null,"Indica la ciudad: "));
        setCorreos(correo=JOptionPane.showInputDialog(null,"Indica el correo: "));
        setCantEmpleados(cantEmpleados=Integer.parseInt(JOptionPane.showInputDialog(null,"Indica nº de empleados: ")));
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
       tipo = JOptionPane.showInputDialog(null,  "¿Desea modificar el nº de empleados? \"s\" si,  \"n\" no:").charAt(0);
       if(tipo == 's'){
           setCantEmpleados(cantEmpleados=Integer.parseInt(JOptionPane.showInputDialog(null,"Nº de empleados actual: " + getCantEmpleados() + " . Indica nº de empleados: ")));        
       }
       super.SetActualizadorDatos();
    }
}
