import javax.swing.JOptionPane;
/**
 * Clase que define al artesano y sus metodos
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Artesano extends Empleado
{
    private int AñosExperiencia;
    private String EstadosFabricación[];
    private String MotivosParado[];
     public  Artesano(String nombre, String correo, String ciudad,  int edad, int AñosExperiencia){
        super(nombre, correo, ciudad, edad);
        this.AñosExperiencia=AñosExperiencia;
    }
    
        
    public void setExperiencia(int AñosExperiencia){
     AñosExperiencia = AñosExperiencia;
    }
    
    public int getExperiencia(){
      return AñosExperiencia;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return    super.toString()+
                 "\n Años experiencia: " + getExperiencia();
                
    }
    public void SetDarDeAlta(){
        super.SetDarDeAlta();
        setExperiencia(AñosExperiencia=Integer.parseInt(JOptionPane.showInputDialog(null,"Indica los años de experiencía profesional: ")));        
            
        
    }
    public void SetActualizadorDatos(){
       super.SetActualizadorDatos();
       char  tipo = JOptionPane.showInputDialog(null,  "¿Desea modificar los años de experiencia? \"s\" si,  \"n\" no:").charAt(0);
       if(tipo == 's'){
           setExperiencia(AñosExperiencia=Integer.parseInt(JOptionPane.showInputDialog(null,"Experiencía profesional actual: " + getExperiencia() + " . Indica los años de experiencía profesional: ")));        
       }
    }
    
    
    
}
