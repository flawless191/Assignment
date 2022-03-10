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
public class searchProductController extends HttpServlet {

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
            out.println("<title>Servlet searchProductController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet searchProductController at " + request.getContextPath() + "</h1>");
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
        String nameSearch = request.getParameter("q");
        ProductDAO pd = new ProductDAO();
        int totalPage = 0;
        int pagesize = 12;
        String pageCurrent = request.getParameter("page");
        int pageC = 0;
        if (pageCurrent == null) {
            pageC = 1;
        } else {
            pageC = Integer.parseInt(pageCurrent);

        }
        totalPage = pd.getTotalPageSreachByName(nameSearch,pagesize);
        ArrayList<Product> products = new ArrayList<>();
        products = pd.getProductSearchByNameWithPaging(nameSearch, pageC,pagesize);
        boolean issearch = true;
        ArrayList<Category> listCategory = new ArrayList<>();
        CategoryDAO cd = new CategoryDAO();
        listCategory = cd.getCategory();
        request.setAttribute("listC", listCategory);
        request.setAttribute("listP", products);

        request.setAttribute("issearch", issearch);
        request.setAttribute("textsearch", nameSearch);
        request.setAttribute("totalpage", totalPage);
        request.setAttribute("pageCurrent", pageC);

        request.getRequestDispatcher("shop.jsp").forward(request, response);
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
        String nameSearch = request.getParameter("q");
        ProductDAO pd = new ProductDAO();
        int totalPage = 0;
        int pagesize = 12;
        String pageCurrent = request.getParameter("page");
        int pageC = 0;
        if (pageCurrent == null) {
            pageC = 1;
        } else {
            pageC = Integer.parseInt(pageCurrent);

        }
        totalPage = pd.getTotalPageSreachByName(nameSearch,pagesize);
        ArrayList<Product> products = new ArrayList<>();
        products = pd.getProductSearchByNameWithPaging(nameSearch, pageC, pagesize);
        boolean issearch = true;
        ArrayList<Category> listCategory = new ArrayList<>();
        CategoryDAO cd = new CategoryDAO();
        listCategory = cd.getCategory();
        request.setAttribute("listC", listCategory);
        request.setAttribute("listP", products);

        request.setAttribute("issearch", issearch);
        request.setAttribute("textsearch", nameSearch);
        request.setAttribute("totalpage", totalPage);
        request.setAttribute("pageCurrent", pageC);

        request.getRequestDispatcher("shop.jsp").forward(request, response);
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
