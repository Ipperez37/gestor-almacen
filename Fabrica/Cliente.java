import javax.swing.JOptionPane;
/**
 * Write a description of class Cliente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cliente extends Personas
{
    private int AntiguedadCliente;
     private String nombre;
     private String correo;
     private String ciudad;
    public Cliente(){}
    
    public Cliente(String nombre,String correo, String ciudad,int AntiguedadCliente){
        super(nombre, correo, ciudad);
        this.AntiguedadCliente = AntiguedadCliente;
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
    public void setCorreos(String correo){
        correo=correo;
    }
    
    public String getCorreos(){
        return correo;
    }
        
    public void setTipoCliente(int AntiguedadCliente){
     AntiguedadCliente = AntiguedadCliente;
    }
    
    public int getTipoCliente(){
      return AntiguedadCliente;
    }
    
     @Override
    public String toString() {
        // TODO Auto-generated method stub
        return   super.toString() +
                 "\n Antiguedad cliente (nº años): " + getTipoCliente();
               
                
    }
    
    public void SetDarDeAlta(){
        setTipoCliente(AntiguedadCliente=Integer.parseInt(JOptionPane.showInputDialog(null,"Indica la antiguedad del cliente (nº años): ")));        
    }
    
    public void SetActualizadorDatos(){
       char  tipo = JOptionPane.showInputDialog(null,  "¿Desea modificar los años de antiguedad? \"s\" si,  \"n\" no:").charAt(0);
       if(tipo == 's'){
           setTipoCliente(AntiguedadCliente=Integer.parseInt(JOptionPane.showInputDialog(null,"Antiguedad actual: " + getTipoCliente() + " . Indica la antiguedad del cliente (nº años): ")));        
       }
       
    }
    
}
