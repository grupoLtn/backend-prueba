
package Servlet;


import Controlador.ControladorDomicilio;
import Modelo.Domicilio;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;
import java.time.LocalDate;
import java.time.LocalTime;


//Se especifica el nombre y ruta de la clase: 'http://localhost:8080/Heroku_Prueba/DomicilioServlet?
@WebServlet(name = "DomicilioServlet", urlPatterns = {"/DomicilioServlet"})
public class ServletDomicilio extends HttpServlet {
    
     
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Modificando el response.setContentType y agregando charset=UTF-8 soluciona problema de caracteres como ñ en react:
        //https://blog.continuum.cl/generar-una-respuesta-json-desde-java-en-utf-8-e68392ae4587
        
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");
        
        PrintWriter out = response.getWriter();
        String respuestaServer = "";
        try {
            
            mostrarElementos(request, response);
            if(request.getParameter("action") != null){
                System.out.println("ACTION " + request.getParameter("action"));
                if(request.getParameter("action").equals("listar")){
                    
                    ControladorDomicilio c1 = new ControladorDomicilio();
                    List<Domicilio> lista = c1.buscarAllDomicilio();
                    Gson gsonBuilder = new GsonBuilder().create();
                    String Json = gsonBuilder.toJson(lista);
                    respuestaServer = Json;
                    
                }else if(request.getParameter("action").equals("buscar")){
                    
                    ControladorDomicilio c1 = new ControladorDomicilio();
                    Domicilio domicilio = c1.buscarOneDomicilio(Long.parseLong(request.getParameter("idDomicilio"))); 
                    Gson gsonBuilder = new GsonBuilder().create();
                    String Json = gsonBuilder.toJson(domicilio);
                    respuestaServer = Json;
                    
                }else if(request.getParameter("action").equals("insertar")){
                    
                    //Se completa con los datos del ControladorCliente
                  
                    String calle = request.getParameter("calle");
                    String altura = request.getParameter("altura");
                    String localidad = request.getParameter("localidad");
                    String provincia = request.getParameter("provincia");
                    String pais = request.getParameter("pais");
                    LocalDate fechaAlta = LocalDate.parse(request.getParameter("fechaAlta"));
                    LocalDate fechaBaja = LocalDate.parse(request.getParameter("fechaBaja"));
                    String estado = request.getParameter("estado");
                    Long idCliente = Long.parseLong(request.getParameter("idCliente"));
                   
                    
                    ControladorDomicilio c1 = new ControladorDomicilio();
                    Domicilio domicilio = new Domicilio(calle, altura, localidad, provincia, pais, fechaAlta, fechaBaja, estado, idCliente);
                    c1.insertarDomicilio(domicilio);
                    Gson gsonBuilder = new GsonBuilder().create();
                    String Json = gsonBuilder.toJson(domicilio);
                    respuestaServer = Json;
                    
                }else if(request.getParameter("action").equals("actualizar")){
                    
                    
                     //Se completa con los datos del ControladorAbertura
                    
                    Long idDomicilio = Long.parseLong(request.getParameter("idDomicilio"));
                    String calle = request.getParameter("calle");
                    String altura = request.getParameter("altura");
                    String localidad = request.getParameter("localidad");
                    String provincia = request.getParameter("provincia");
                    String pais = request.getParameter("pais");
                    LocalDate fechaAlta = LocalDate.parse(request.getParameter("fechaAlta"));
                    LocalDate fechaBaja = LocalDate.parse(request.getParameter("fechaBaja"));
                    String estado = request.getParameter("estado");
                    Long idCliente = Long.parseLong(request.getParameter("idCliente"));
                    
                   

                    ControladorDomicilio c1 = new ControladorDomicilio();
                    Domicilio domicilio = new Domicilio(idDomicilio, calle, altura, localidad, provincia, pais, fechaAlta, fechaBaja, estado, idCliente);
                    c1.actualizarDomicilio(domicilio);
                    Gson gsonBuilder = new GsonBuilder().create();
                    String Json = gsonBuilder.toJson(domicilio);
                    respuestaServer = Json;
                    
                }else if(request.getParameter("action").equals("eliminar")){
                    
                    ControladorDomicilio c1 = new ControladorDomicilio();   
                    c1.eliminarDomicilio(Long.parseLong(request.getParameter("idDomicilio")));
                    List<Domicilio> lista = c1.buscarAllDomicilio();
                    Gson gsonBuilder = new GsonBuilder().create();
                    String Json = gsonBuilder.toJson(lista);
                    respuestaServer = Json;
                    
                }else if(request.getParameter("action").equals("eliminarLogico")){
                    
                    Long idDomicilio = Long.parseLong(request.getParameter("idDomicilio"));
                    LocalDate fechaBaja = LocalDate.parse(request.getParameter("fechaBaja"));
                    
                    ControladorDomicilio c1 = new ControladorDomicilio();   
                    c1.eliminarLogicoDomicilio(idDomicilio, fechaBaja);
                    List<Domicilio> lista = c1.buscarAllDomicilio();
                    Gson gsonBuilder = new GsonBuilder().create();
                    String Json = gsonBuilder.toJson(lista);
                    respuestaServer = Json;
                    
                }
                    
            }
            out.write(respuestaServer);
        }catch(Exception ex){
            ex.printStackTrace();
        } finally {
            out.close();
        }
    }
    
    private void mostrarElementos(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException{
        try { 
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            response.setContentType("text/html");
            
            if(!isMultipart ) {
                System.out.println("NO ES MULTIPART");
                return;
            }

            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

        
           // Parse the request to get file items.
           List fileItems = upload.parseRequest(request);

           // Process the uploaded file items
           Iterator i = fileItems.iterator();

           while ( i.hasNext () ) {
                FileItem fi = (FileItem)i.next();
                // Get the uploaded file parameters
                String fieldName = fi.getFieldName();
                String value = fi.getString();
                System.out.println("FieldName: " + fieldName);
                System.out.println("VALOR: " + value);
           }
           
           } catch(Exception ex) {
              System.out.println(ex);
           }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
