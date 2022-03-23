/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAL.AccountDAO;
import DAL.CategoryDAO;
import DAL.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Category;
import model.Product;

/**
 *
 * @author ASUS
 */
public class changePasswordController extends HttpServlet {

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
            out.println("<title>Servlet changePasswordController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet changePasswordController at " + request.getContextPath() + "</h1>");
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
        ArrayList<Product> productsBest = new ArrayList<>();
        ProductDAO pd = new ProductDAO();
        productsBest = pd.get4BestSell();
        ArrayList<Category> listCategory = new ArrayList<>();
        CategoryDAO cd = new CategoryDAO();
        listCategory = cd.getCategory();
        request.setAttribute("listB", productsBest);
        request.setAttribute("listC", listCategory);

        request.getRequestDispatcher("changePassword.jsp").forward(request, response);
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
        String user = request.getParameter("userName");
        String pass = request.getParameter("password");
        String newPass = request.getParameter("newPass");
        String confrimPass=  request.getParameter("confrimPass");
        AccountDAO ac = new AccountDAO();
        Account a = ac.getAccounts(user, pass);
        if (a == null) {
            ArrayList<Product> productsBest = new ArrayList<>();
            ProductDAO pd = new ProductDAO();
            productsBest = pd.get4BestSell();
            ArrayList<Category> listCategory = new ArrayList<>();
            CategoryDAO cd = new CategoryDAO();
            listCategory = cd.getCategory();
            request.setAttribute("listB", productsBest);
            request.setAttribute("listC", listCategory);
            request.setAttribute("alertMess", "Wrong user or password!");
            request.getRequestDispatcher("changePassword.jsp").forward(request, response);
        } else if (newPass.equals(confrimPass) == false) {
            ArrayList<Product> productsBest = new ArrayList<>();
            ProductDAO pd = new ProductDAO();
            productsBest = pd.get4BestSell();
            ArrayList<Category> listCategory = new ArrayList<>();
            CategoryDAO cd = new CategoryDAO();
            listCategory = cd.getCategory();
            request.setAttribute("listB", productsBest);
            request.setAttribute("listC", listCategory);
            request.setAttribute("alertMess", "New password and confrim password must be the same!");

            request.getRequestDispatcher("changePassword.jsp").forward(request, response);
        } else {
            
            Account acc = new Account();
            acc.setUser(user);
            acc.setPass(newPass);
            ac.updateAccountPassword(acc);
            boolean updatesuccess = true;
            request.setAttribute("updatesuccess", updatesuccess);
            request.getRequestDispatcher("changePassword.jsp").forward(request, response);
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
