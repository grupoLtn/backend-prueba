
package Principal;

import Controlador.ControladorCliente;
import Controlador.ControladorDomicilio;
import Modelo.Cliente;
import Modelo.Domicilio;
import java.time.LocalDate;
import java.util.List;


public class Principal {
    
    public static void main(String[]args){
        
        /*
        
        //TESTEO INSERT DE CLIENTE  =>
        
        Cliente cliente = new Cliente("Federico", "Sabatini", "31029020", LocalDate.parse("2022-09-08"), LocalDate.parse("1900-01-01"), "activo");
        
        ControladorCliente c1 = new ControladorCliente();
        
        c1.insertarCliente(cliente);

        */
        
        /*
        
        //TESTEO ACTUALIZAR CLIENTE =>
        
        Cliente cliente = new Cliente(1L, "Marta", "Argumedo", "5513047", LocalDate.parse("2022-12-13"), LocalDate.parse("1900-01-01"), "activo");
        
        ControladorCliente c1 = new ControladorCliente();
        
        c1.actualizarCliente(cliente);

        */
        
        /*
        
        //TESTEO BUSCAR ONE CLIENTE =>
        
        ControladorCliente c1 = new ControladorCliente();
        
        Cliente cliente = c1.buscarOneCliente(1L);
        
        System.out.println(cliente.toString());

        */
        
        /*
        
        //TESTEO BUSCAR ALL CLIENTES =>
        
        ControladorCliente c1 = new ControladorCliente();
        
        List<Cliente> lista = c1.buscarAllCliente();
        
        for(Cliente item:lista){
            
            System.out.println(item.toString());
            System.out.println("");
            
        }

        */
        
        /*
        
        //TESTEO DELETE LOGICO CLIENTE =>
        
        ControladorCliente c1 = new ControladorCliente();
        
        c1.eliminarLogicoCliente(1L, LocalDate.parse("2022-12-13"));

        */
        
        
        // --------------------------------------------------
        
        /*
        
        //TESTEO INSERT DE DOMICILIO  =>
        
        Domicilio domicilio = new Domicilio("25 de Mayo", "652", "Ciudad", "Mendoza", "Argentina", LocalDate.parse("2022-09-08"), LocalDate.parse("1900-01-01"), "activo", 1L);
        
        ControladorDomicilio c1 = new ControladorDomicilio();
        
        c1.insertarDomicilio(domicilio);

        */
        
        /*
        
        //TESTEO ACTUALIZAR DOMICILIO =>
        
        Domicilio domicilio = new Domicilio(1L, "Colon", "111", "San Jose", "San Juan", "Brazil", LocalDate.parse("2022-09-08"), LocalDate.parse("1900-01-01"), "activo", 1L);
        
        ControladorDomicilio c1 = new ControladorDomicilio();
        
        c1.actualizarDomicilio(domicilio);

        */
        
        /*
        
        //TESTEO BUSCAR ONE DOMICILIO =>
        
        ControladorDomicilio c1 = new ControladorDomicilio();
        
        Domicilio domicilio = c1.buscarOneDomicilio(1L);
        
        System.out.println(domicilio.toString());

        */
        
        /*
        
         //TESTEO BUSCAR ALL DOMICILIOS =>
         
         ControladorDomicilio c1 = new ControladorDomicilio();
         
         List<Domicilio> lista = c1.buscarAllDomicilio();
         
         for(Domicilio item:lista){
             
             System.out.println(item.toString());
             System.out.println("");
             
         }

        */
        
        /*
        
        //TESTEO DELETE LOGICO DOMICILIO =>
        
        ControladorDomicilio c1 = new ControladorDomicilio();
        
        c1.eliminarLogicoDomicilio(1L, LocalDate.parse("2022-12-13"));

        */
        
        
    }
    
  
}
