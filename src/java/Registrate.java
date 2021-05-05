/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Esta se encarga del objeto para la conexion con la base de datos
import java.sql.Connection;
import java.sql.DriverManager;
//Esta se encarga de poder realizar las sentencias SQl como son:
//insert, delete, update, create, alter, drop
import java.sql.Statement;
//Esta se encarga para generar un objeto para poder realizar las consultas SQL
import java.sql.ResultSet;
import javax.servlet.ServletConfig;

/**
 *
 * @author Hola
 */
public class Registrate extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //variables globales
    private Connection con;
    private Statement set;
    private ResultSet rs;
    
    //constructor
    public void init(ServletConfig cfg) throws ServletException{
        
        String url = "jdbc:mysql:3306//localhost/Registrate";
        
        String userName = "root";
        String password = "Jesus.sainz1";
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            //url = "jdbc:mysql://localhost/registro";   
            url = "jdbc:mysql://localhost/Registrate"; 
            con = DriverManager.getConnection(url, userName, password);
            set = con.createStatement();
            
            System.out.println("Conexion Exitosa");
        
        }catch(Exception e){
            System.out.println("Conexión No exitosa");
            System.out.println(e.getMessage());//mensaje de error
            System.out.println(e.getStackTrace());//donde se originó el error
        
        }
    }
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String nom, appat, apmat, domi;
            int edad, mes, dia, año, tel, cel, usu, con;
            
            nom = request.getParameter("nombre");
            appat = request.getParameter("appat");
            apmat = request.getParameter("apmat");
            domi = request.getParameter("domi");
            edad = Integer.parseInt(request.getParameter("edad"));
            mes = Integer.parseInt(request.getParameter("mes"));
            dia = Integer.parseInt(request.getParameter("dia"));
            año = Integer.parseInt(request.getParameter("año"));
            tel = Integer.parseInt(request.getParameter("tel"));
            cel = Integer.parseInt(request.getParameter("cel"));
            usu = Integer.parseInt(request.getParameter("usu"));
            con = Integer.parseInt(request.getParameter("con"));
            
            //registrar en la base de datos
            
            try{
                
                String q = "insert into registrarte "
                        + "(nom_usu, appat_usu, apmat_usu, domi_usu, edad_usu,"
                        + " mes_usu, dia_usu, año_usu, tel_usu, cel_usu, usu_usu, con_usu)"
                        + "values "
                        + "('"+nom+"', '"+appat+"', '"+apmat+"', '"+domi+"', "+edad+""
                        + ""+mes+", "+dia+", "+año+", "+tel+", "+cel+", '"+usu+"', '"+con+"')";
                
                set.executeUpdate(q);
                System.out.println("Registro exitoso en la tabla");
                
                
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registrate</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Registro Exitoso</h1>"
                    + "<h3>hola</h3>"
                    + "<a href='login.html'>Iniciar Sesión</a>");
            out.println("</body>");
            out.println("</html>");
            
            }catch(Exception e){
                System.out.println("Error al registrar");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
                
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registrate</title>");            
            out.println("</head>");
            out.println("<body>"
                    + "<br>");
            out.println("<h1>Registro No Exitoso, ocurrió un error</h1>"
                    + "<a href='login.html'>Iniciar Sesión</a>");
            out.println("</body>");
            out.println("</html>");
                
            }
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
