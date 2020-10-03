import javax.swing.JOptionPane;
/**
 * Write a description of class ArtesanoPorHoras here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArtesanoPorHoras extends Artesano
{
    private int horas;
    private String nombre;
    private String correo;
    private String ciudad;
    public ArtesanoPorHoras(String nombre, String correo, String ciudad, int edad, int A�, int i�osExperiencia, int horas){
        super(nombre, correo, ciudad, edad,AñosExperiencia);
        this.horas = horas;
        this.nombre = nombre;
        this.correo = correo;
        this.ciudad = ciudad;
    }
     
    
    
     public void setHora(int horas){
        horas=horas;
    }
     public int getHora(){
        return horas;
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
        return  "\n Artesano contratado por horas:" + 
                 super.toString()+
                "\n Precio por hora: " + getHora();
                
    }
    
    public void SetDarDeAlta(){
        
        setNombres(nombre=JOptionPane.showInputDialog(null,"Indica el nombre: "));        
        setCiudades(ciudad=JOptionPane.showInputDialog(null,"Indica la ciudad: "));
        setCorreos(correo=JOptionPane.showInputDialog(null,"Indica el correo: "));
        setHora(horas=Integer.parseInt(JOptionPane.showInputDialog(null,"Indica el precio por hora: ")));        
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
       tipo = JOptionPane.showInputDialog(null,  "¿Desea modificar los años de antiguedad? \"s\" si,  \"n\" no:").charAt(0);
       if(tipo == 's'){
           setHora(horas=Integer.parseInt(JOptionPane.showInputDialog(null,"Precio hora actual: " + getHora() + " . Indica el precio por hora: ")));        
       }
       super.SetActualizadorDatos();
    }
    
}
