import javax.swing.JOptionPane;
/**
 * Write a description of class Mesa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Mesa extends Mueble implements Informes
{
    private int tipoTablero;
     
    public Mesa( int al, int an, int l, int c, String nombre){
        super(al,an,l,c, nombre);
        this.tipoTablero=0;
     
    }
    
    public Mesa(int al, int an, int l, int c, int tTablero, String nombre){
        this(l,an,al,c, nombre);
        this.tipoTablero=tTablero;
        
    }
    
    public double calcularPrecioFinal(){
        return precioBase;    
    }
    
    //pendiente hacer los set y los gets
    public void ListarCaracteristicas(){
        super.ListarCaracteristicas();
        System.out.println("Tipo de tablero: " + getTablero());
        System.out.println("Tipo de tapizado: " + getNombre());
    }
   
       
    public void setTablero(int tablero){
        tipoTablero=tablero;
    }
    
    public int getTablero(){
        return  tipoTablero;
    }
    
   @Override
    public String toString() {
        // TODO Auto-generated method stub
        return   super.toString() +
                "\n Tablero: " + getTablero();
               
                
    }
  
    public void SetDatos(){
        super.SetDatos();
        setTablero(tipoTablero=Integer.parseInt(JOptionPane.showInputDialog(null,"Indica el tipo de tablero (int): ")));
    }
    
    public void SetActualizarDatos(){
        super.SetActualizarDatos();
         char tipo = JOptionPane.showInputDialog(null,"¿Desea modificar el tablero? \"s\" si,  \"n\" no:").charAt(0);    
       if(tipo == 's'){
         setTablero(tipoTablero=Integer.parseInt(JOptionPane.showInputDialog(null,"Tablero actual: " + getTablero() +  " .Indica el tipo de tablero (int): ")));
        }
    }
}
