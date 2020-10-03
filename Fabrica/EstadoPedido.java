import javax.swing.JOptionPane;
import java.io.IOException;
import java.util.*;
/**
 * Write a description of class EstadoPedido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EstadoPedido
{
    private Pedido pedidos;
    
    private int pedido;
    private String mueble;
    private String estados;
    private String motivo;
    private String artesano;
    private String cliente;
    
    
    public EstadoPedido(){}
    
    public EstadoPedido(int pedido, String mueble, String estados, String motivo, String artesano, String cliente)
    {
       pedido = pedido;
       mueble = mueble;
       estados = estados;
       motivo = motivo;
       artesano = artesano;
       cliente = cliente;
    }

    public void setPedido(int pedido){
           pedido = pedido;
    }
    
    public int getPedido(){
     
         return  pedido;
    }
    
    public void setMueble(String mueble){
           mueble = mueble;
    }
    
    public String getMueble(){
          return  mueble;
    }
    
    public void setEstado(String estados){
           estados = estados;
    }
    
    public String getEstado(){
     
         return  estados;
    }
    
    public void setMotivo(String motivo){
           motivo = motivo;
    }
    
    public String getMotivo(){
           return  motivo;
    }
    
    public void setArtesano(String artesano){
           artesano = artesano;
    }
    
    public String getArtesano(){
           return  artesano;
    }
    
    public void setCliente(String cliente){
           cliente = cliente;
    }
    
    public String getCliente(){
           return  cliente;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return   "Situació pedido: " + 
                 "\n Nº de pedido: " + getPedido()+
                 "\n Mueble: " + getMueble() +
                 "\n Estado: " + getEstado() +
                 "\n Motivo de parada: " + getMotivo()+
                 "\n Artesano: " + getArtesano()+
                 "\n Cliente: " + getCliente();
               
                
    } 
    
    //crea el estado de cada articulo
    public void SetDatosEstadoPedido(int NumPedidoAsignar, String articulo)throws IOException{
        motivo = "No hay";
        pedido = NumPedidoAsignar;
        mueble = articulo;
        artesano = pedidos.getArtesano(NumPedidoAsignar);
        cliente = pedidos.getCliente(NumPedidoAsignar);
        JOptionPane.showMessageDialog(null,"A continuación indica el estado de fabricación del \n" +
         "siguiente mueble" + articulo);
         estados = getEstados();
         if(estados == "Parado"){
             motivo = getMotivos();
         }             
         setPedido(pedido);
         setMueble(mueble);
         setEstado(estados);
         setMotivo(motivo);
         setArtesano(artesano);
         setArtesano(cliente);
           
        
    }

    //muestra las opciones de los distintos estados que se desea asignar.  
    public String getEstados(){
        String estado;
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null,"Indica el estado de la fabricación para este material:"+  
            "\n"
            +"1. Pendiente \n"
            +"2. En Proceso \n"
            +"3. Parado \n"
            +"4. Fase de pruebas \n"
            +"5. Terminado \n"));
        if (opcion == 1){return estado ="Pendiente";}
        if (opcion == 2){return estado ="En Proceso";}
        if (opcion == 3){return estado ="Parado";}
        if (opcion == 4){return estado ="Fase de pruebas";}
        if (opcion == 5){return estado ="Terminado";}
        return null;
    
    
    }
    
    //
    public String getMotivos(){
    String motivo;
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null,"Indica la causa de la parada productiva:"+  
            "\n"
            +"1. Falta material \n"
            +"2. Pendiente cliente \n"));
        if (opcion == 1){return motivo ="Falta material";}
        if (opcion == 2){return motivo ="Pendiente cliente";}
        return null;
    }
}
    
    
    


