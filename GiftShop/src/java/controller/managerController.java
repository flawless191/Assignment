/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAL.CategoryDAO;
import DAL.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Product;

/**
 *
 * @author ASUS
 */
public class managerController extends HttpServlet {

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
            out.println("<title>Servlet managerController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet managerController at " + request.getContextPath() + "</h1>");
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
        ArrayList<Product> products = new ArrayList<>();
        ProductDAO pd = new ProductDAO();
        int totalPage = 0;
        int pagesize = 6;
        totalPage = pd.getTotalPage(pagesize);
        String pageCurrent = request.getParameter("page");
        int pageC = 0;
        if (pageCurrent == null) {
            pageC = 1;
        } else {
            pageC = Integer.parseInt(pageCurrent);

        }
        products = pd.getProductWithPaging(pageC, pagesize);
        ArrayList<Category> listCategory = new ArrayList<>();
        CategoryDAO cd = new CategoryDAO();
        listCategory = cd.getCategory();
        request.setAttribute("listC", listCategory);
        request.setAttribute("totalpage", totalPage);
        request.setAttribute("pageCurrent", pageC);
        request.setAttribute("listP", products);
        request.getRequestDispatcher("manager.jsp").forward(request, response);
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
        String pidString = request.getParameter("pid");
        int pid = Integer.parseInt(pidString);
        ProductDAO pd = new ProductDAO();
        Product p = new Product();
        p = pd.getProductById(pid);
        ArrayList<Category> listCategory = new ArrayList<>();
        CategoryDAO cd = new CategoryDAO();
        listCategory = cd.getCategory();
        //if found product
        if (p != null) {
            ArrayList<Product> products = new ArrayList<>();
            products.add(p);
            request.setAttribute("searchMessage", pid);
            request.setAttribute("listP", products);
            request.setAttribute("listC", listCategory);
            request.getRequestDispatcher("manager.jsp").forward(request, response);
        } else {
            request.setAttribute("searchMessage", "No products found");
            request.setAttribute("listC", listCategory);
            request.getRequestDispatcher("manager.jsp").forward(request, response);
        }

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
