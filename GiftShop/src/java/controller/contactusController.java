/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAL.CategoryDAO;
import DAL.ContactDAO;
import DAL.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Contact;
import model.Product;

/**
 *
 * @author ASUS
 */
public class contactusController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet contactusController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet contactusController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        ArrayList<Category> listCategory = new ArrayList<>();
        CategoryDAO cd = new CategoryDAO();
        listCategory = cd.getCategory();
        ProductDAO pd = new ProductDAO();
        ArrayList<Product> productsBest = new ArrayList<>();
        productsBest = pd.get4BestSell();
        request.setAttribute("listB", productsBest);
        request.setAttribute("listC", listCategory);
        request.getRequestDispatcher("contactus.jsp").forward(request, response);
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
        String firstname = request.getParameter("contactFName");
        String lastname = request.getParameter("contactLName");
        String email = request.getParameter("contactEmail");
        String phone = request.getParameter("contactPhone");
        String message = request.getParameter("contactMessage");
        
        Contact contact = new Contact();
        contact.setFirstName(firstname);
        contact.setLastName(lastname);
        contact.setEmail(email);
        contact.setPhone(phone);
        contact.setMessage(message);
        
        ContactDAO conDAO = new ContactDAO();
        conDAO.insertContact(contact);
        response.sendRedirect("homePageController");
        
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
