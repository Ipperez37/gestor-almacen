import javax.swing.JOptionPane;
/**
 * Write a description of class Silla here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public abstract class Silla extends Mueble implements Informes
{
    private int patas;
    public Silla( int al, int an, int l, int c, String nombre, int patas){
        super(al,an,l,c,nombre);
        this.patas=patas;
    }
    
          
    public double calcularPrecioFinal(){
        return precioBase;    
    }
    
    public void ListarPrecioFinal(){
        System.out.println("El precio de la mesa de dormitorio es: " + calcularPrecioFinal());
    }
    
    public void setPatas(int patas){
     patas= patas;
    }
    public int getPatas(){
     return patas;
    }
  
     @Override
    public String toString() {
        // TODO Auto-generated method stub
        return   super.toString() +
                "\n Nº de patas: " + getPatas();
               
                
    }
     public void SetDatos(){
        super.SetDatos();
        setPatas(patas=Integer.parseInt(JOptionPane.showInputDialog(null,"Indica nº de patas (int): ")));
    }
    public void SetActualizarDatos(){
        super.SetActualizarDatos();
        char tipo = JOptionPane.showInputDialog(null,"¿Desea modificar el nº de patas? \"s\" , \"n\":").charAt(0);   
        if(tipo == 's'){
         setPatas(patas=Integer.parseInt(JOptionPane.showInputDialog(null,"Nº patas actual: " + getPatas() + " .Indica nº de patas (int): ")));
        }
    }
}
