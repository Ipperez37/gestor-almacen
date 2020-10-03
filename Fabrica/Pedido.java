import javax.swing.JOptionPane;
import java.io.IOException;
import java.util.*;
/**
 * Write a description of class Pedido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pedido
{
    private Administracion admin = new Administracion();
    private Fabrica fabrica = new Fabrica ();
    private Almacen almacenes = new Almacen();
    EstadoPedido EstadoPedido = new EstadoPedido();
    
    private ArrayList<Cliente> clientes;
    private ArrayList<Empleado> personal;
    private ArrayList<Mueble> muebles;
    private ArrayList<EstadoPedido> pedidos;
    private ArrayList<Mueble> MueblesPorPedido;
    
    private static HashMap<Integer, HashMap<String, ArrayList<Mueble>>>  pedido = new HashMap<Integer, HashMap<String, ArrayList<Mueble>>>();
    private static HashMap<Integer, Personas>  AsignarPedido = new HashMap<Integer, Personas>();
    
    private int nPedido;
    private Cliente cliente;
    
    
    
    public Pedido(){
        clientes = new ArrayList<Cliente>();
        muebles = new ArrayList<Mueble>();
        personal = new ArrayList<Empleado>();
        pedidos = new ArrayList<EstadoPedido>();
        MueblesPorPedido = new ArrayList<Mueble>();
        nPedido = 0;

    }
     //metodo que obtiene el cliente que se va a integrar en el pedido
    public Cliente ObtnerCliente(){
    
    clientes = admin.getClientes();
    String nombreBuscar = JOptionPane.showInputDialog(null,"Indica el nombre del cliente que desea buscar: ");
        for (Cliente c: clientes)
        {
             if(String.valueOf(nombreBuscar).equals(c.getNombres()) )
                { 
                     return c;
                }
        }
        return null;
    }
    
    //metodo que obtiene el mueble que se va a integrar en el pedido
    public Mueble ObtnerMueble(){
    //cliente=admin.getDevolverCliente();
    muebles = almacenes.getMuebles();
    String nombreBuscar = JOptionPane.showInputDialog(null,"Indica el nombre del mueble que desea buscar: ");
        for (Mueble m: muebles)
        {
                if(String.valueOf(nombreBuscar).equals(m.getNombre()) )
                { 
                     return m;
                }
        }
        return null;
    }
    //obtiene el array de empleado
    public Empleado ObtnerEmpleado(){
        personal = admin.getPersonal();
        String nombreBuscar = JOptionPane.showInputDialog(null,"Indica el nombre del artesano al que quiere asignar el pedido: ");
         for (Empleado e: personal)
            {
                    if(String.valueOf(nombreBuscar).equals(e.getNombres()) )
                    { 
                         return e;
                    }
            }
            return null;
    
    }
    
   /*crea los pedidos. Primero pregunta si existe el cliente o el mueble que se desea añadir al pedido. 
   En cada caso si no existe, le indica que vaya a la opción requerida para crearlo y en caso contrario 
   pide el nombre (cliente o mueble), para buscarlo y agregarlo al pedido. */
   public void CrearPedido() throws IOException{
         char NumArticulos = 's';   
            char tipo = JOptionPane.showInputDialog(null,"Si el cliente ya existe, pulsa \"s\" para dar seguir o \"c\" para crear ").charAt(0);
         if(tipo == 's'){
             //pedido.CrearPedido();
             String ClientePedido = this.ObtnerCliente().getNombres();
             if( ClientePedido != null) 
            {
                tipo = JOptionPane.showInputDialog(null,"¿Desea añadir un mueble ya creado?, pulse \"s\" para seguir, \n"+
                "¿Desea crear un nuevo mueble?, pulse \"c\" para crear ").charAt(0);
                if(tipo == 's'){
                    nPedido++;
                        ArrayList<Mueble> MueblesPorPedido = new ArrayList<Mueble>();
                        while (NumArticulos == 's'){
                         Mueble MueblePedido =this.ObtnerMueble();
                         if (MueblePedido == null)
                         {
                              JOptionPane.showMessageDialog(null,"El mueble indicado no existe");
                              nPedido--;
                              fabrica.mostrarMenu();                          
                         }
                         MueblesPorPedido.add(MueblePedido);  
                         NumArticulos = JOptionPane.showInputDialog(null,"Si desea añadir otro mueble, pulsa \"s\" para seguir, en caso contrario pulse cualquier tecla").charAt(0);  
                        }
                        
                    
                    if( MueblesPorPedido != null) 
                    {   
                        pedido.put(nPedido,new HashMap<String, ArrayList<Mueble>>());
                        pedido.get(nPedido).put(ClientePedido,MueblesPorPedido);
                        LlenarPedido(nPedido);
                        JOptionPane.showMessageDialog(null,"Pedido creado correctamente con el nº: " + nPedido);
                    }else{
                        JOptionPane.showMessageDialog(null,"El articulo indicado no existe.");
                    }
                }else{
                    fabrica.crearMueble();
                }
            
            }else{
                  JOptionPane.showMessageDialog(null,"El cliente indicado no existe.");
            }
        }else if (tipo == 'c'){
            fabrica.CrearPersonas();
        }
                   
             
        
    }
    //Muestra todos los pedidos creados. Detallando por nº, cliente y articulos que lo componen.
   public void MostrarPedido()throws IOException{
              
        for (Map.Entry<Integer, HashMap<String, ArrayList<Mueble>>> entry : pedido.entrySet()) {
        
             JOptionPane.showMessageDialog(null," Pedido nº :" + entry.getKey() +
             " Datos Cliente: "+ entry.getValue().keySet());
             JOptionPane.showMessageDialog(null," Detalle del pedido: ");
             
             String muebles = entry.getValue().values().toString();
             String[] DetallePedido = muebles.split(",");
             
             for(int i=0; i<DetallePedido.length; i++) {
                  JOptionPane.showMessageDialog(null, DetallePedido[i]);
             }
          
        }
    }
    
    //este metodo es invocado en el momento de crearlo
    //crea la relación de pedidos activos en el almacén
   public void LlenarPedido(int nPedido){
        int NumPedido = nPedido;
        AsignarPedido.put(NumPedido,null);
    }
     
    /*Metodo asignar los pedidos a los artesanos
    primero muestra si hay pedidos sin asignar, luego pedira que el nº del pedido 
    y el nombre del artesano al que quiere asignar el pedido.
    En el caso de que no existiera pedidos pendiente de asignar o deseara modificarlo, 
    dará la posibilidad introduciendo otra vez el nº de pedido a modificar.*/
   public void AsignarPedido(){
        int CantidadPedido = 0;
        //int NumPedidoAsignar = 0;
        JOptionPane.showMessageDialog(null,"Listado de pedidos sin asignar: \n");
        for (Map.Entry<Integer, Personas> entry : AsignarPedido.entrySet()) {
            if(entry.getValue() == null){
               JOptionPane.showMessageDialog(null,"Nº de Pedido " + entry.getKey().toString() );
                CantidadPedido++;
            }
                            
        }
        
        if(CantidadPedido==0){
                int NumPedidoAsignar = Integer.parseInt(JOptionPane.showInputDialog(null,"No hay pedidos pendiente de asignación, ¿Desea modificar"
                +" alguno ya asignado? indique el nº de pedido. En caso contrio pulse \"0\"." ));
                if(NumPedidoAsignar != 0){
                    Personas ActualizarArtesano = null;
                    ActualizarArtesano =ObtnerEmpleado();
                    if (ActualizarArtesano != null){
                        MetodoAsignarPedido(NumPedidoAsignar, ActualizarArtesano);
                    }
                   
                }
                
        }else if(CantidadPedido>0){
             int NumPedidoAsignar = Integer.parseInt(JOptionPane.showInputDialog(null,"Indica el nº de pedido que desea asignar:"));
             boolean encontrado = false;
            
                 if(AsignarPedido.containsKey(NumPedidoAsignar) && AsignarPedido.get(NumPedidoAsignar)==null){
                        Personas artesano =ObtnerEmpleado();
                         if(artesano != null){
                                 MetodoAsignarPedido(NumPedidoAsignar, artesano);
                                 encontrado = true;
                         }else if(artesano == null){
                                  JOptionPane.showMessageDialog(null,"El nombre del empleado no es correcto, y no se ha podido asignar el pedido");
                                  encontrado = true;
                         }
                       
                         
                 }else if (AsignarPedido.containsKey(NumPedidoAsignar) && AsignarPedido.get(NumPedidoAsignar)!=null){
                     
                     Personas ActualizarArtesano = null;
                     char respuesta = JOptionPane.showInputDialog(null,"El pedido " + NumPedidoAsignar +  " ya está asignado. "+
                     "Si desea asignar el pedido a otro artesano, pulse \"s\" ").charAt(0);
                     if (respuesta == 's'){
                      ActualizarArtesano =ObtnerEmpleado();
                          if (ActualizarArtesano != null){
                             MetodoAsignarPedido(NumPedidoAsignar, ActualizarArtesano);
                             encontrado = true;
                            
                          } 
                     }                    
                      
                 }
              
            if (encontrado == false){
                 JOptionPane.showMessageDialog(null,"El pedido " + NumPedidoAsignar +  " no existe");
            }
        
        }
    
   }
   
   //metodo llamado en AsignarPedido, y donde se realiza el proceso de asignación.
   public void MetodoAsignarPedido(int pedido, Personas artesano){ 
        int NumPedidoAsignar=pedido;
        Personas NombreArtesano = artesano;
        AsignarPedido.put(NumPedidoAsignar,NombreArtesano);
        JOptionPane.showMessageDialog(null,"Pedido asignado correctamente");
    
    }
    //Método para listar todos los pedidos e indica si están asignados a un artesano o no
   public void EstadoAsignacionPedidos(){
      for (Map.Entry<Integer, Personas> entry : AsignarPedido.entrySet()) {
          if (entry.getValue() != null)
          {
            JOptionPane.showMessageDialog(null,"Pedido Nº: " + entry.getKey().toString() + " , Asignado al artesano : " + entry.getValue().getNombres());    
         }else{
            JOptionPane.showMessageDialog(null,"Pedido Nº: " + entry.getKey().toString() + "  , Sin asignar a ningún artesano");    
         }
      }
      
    }
    
    //método invocado en la clase EstadoPedido, cuando se inicia el proceso de fabricación del producto. Obtiene el nombre del cliente
    public static String getCliente(int NumPedido)throws IOException{
      String cliente;
      for (Map.Entry<Integer, HashMap<String, ArrayList<Mueble>>> entry : pedido.entrySet()) {
                if(entry.getKey()==NumPedido){
                        cliente = entry.getValue().keySet().toString();
                        return cliente;
                }
      }
      
      return null;
    }
    //método invocado en la clase EstadoPedido, cuando se inicia el proceso de fabricación del producto.
    //Obtiene cada uno de los muebles creados en cada pedido.
    public String[] getArticulos(int NumPedido)throws IOException{
               
        for (Map.Entry<Integer, HashMap<String, ArrayList<Mueble>>> entry : pedido.entrySet()) {
            if(entry.getKey()==NumPedido){
             String muebles = entry.getValue().values().toString();
             String[] DetalleMueble = muebles.split(",");
             return DetalleMueble;
           }
        }
        return null;
    } 
    
    //método invocado en la clase EstadoPedido, cuando se inicia el proceso de fabricación del producto.
    //Obtiene el artesano asociado al pedido.
    public static String getArtesano(int NumPedido)throws IOException{
       String artesano;   
       int NumPedidoAsignar = NumPedido;
       if(AsignarPedido.containsKey(NumPedidoAsignar) && AsignarPedido.get(NumPedidoAsignar)!=null){
        return artesano= AsignarPedido.get(NumPedidoAsignar).getNombres();
        }
       return null;
    } 
    
    /*método para asignar los estados a cada articulo incluido en un pedido.
       Para comenzar el proceso indicar el nº de pedido y la aplicación le indicara que estado
       desea asignar a cada articulo*/
    
    public void EstadoFabricacion()throws IOException{
        int NumPedidoAsignar = Integer.parseInt(JOptionPane.showInputDialog(null,"Indica el nº de pedido que quiere actualizar:"));
        String[] listadoMueble = getArticulos(NumPedidoAsignar);
        String asignado = getArtesano(NumPedidoAsignar);
        if (asignado != null ){
           
                //añadir un null por si no existe el pedido
                //añadir comprobacion que el pedido esta asignado
                for(int i=0; i<=listadoMueble.length-1; i++) {
                    String mueble = listadoMueble[i];
                    this.ComenzarPedidos(NumPedidoAsignar,mueble);
                }
        }else{
            JOptionPane.showMessageDialog(null,"Este pedido no ha sido asignado a ningún artesano."+
            "Por favor, asignalo antes de iniciar la fabricación.");
        }
    }
    
    //método llamado en EstadoFabricacion(), para la asignación de estados
    public void ComenzarPedidos(int pedido, String NuevoMueble)throws IOException{
        int NumPedidoAsignar = pedido;
        String mueble = NuevoMueble;
        EstadoPedido EstadoPedido = new EstadoPedido(0,"","","","","");
        EstadoPedido.SetDatosEstadoPedido(NumPedidoAsignar,mueble);
        PedidosGestionados(EstadoPedido);
        JOptionPane.showMessageDialog(null,"Asignado el estado al pedido correctamente");
        
    }
    
    //método llamado en ComenzarPedidos(), para añadir los pedidos que ya se le han asignado un estado de 
    //fabricación.
    public void PedidosGestionados(EstadoPedido e){
        pedidos.add(e);
    }
    
    /*muestra todos los muebles a los que se les ha asignado un estado de fabricación. 
    Detallando, pedido, articulo, estado, motivo de parada si existiera, artesano asignado y nombre del cliente.*/
    public void MostrarEstadoFabricacionPedidos(){
        for (int i = 0; i < pedidos.size(); i++)
        {
            JOptionPane.showMessageDialog(null,pedidos.get(i));
        }
    
    }
}
