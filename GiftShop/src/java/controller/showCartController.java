/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAL.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;
import model.Product;

/**
 *
 * @author ASUS
 */
public class showCartController extends HttpServlet {

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
            out.println("<title>Servlet showCartController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet showCartController at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        ArrayList<Product> productsBest = new ArrayList<>();
        ProductDAO pd = new ProductDAO();

        productsBest = pd.get4BestSell();
        request.setAttribute("listB", productsBest);

        if (session.getAttribute("listcart") != null) {
            ArrayList<Cart> listCart = (ArrayList<Cart>) session.getAttribute("listcart");
            double discount = 0;
            double total = 0;
            for (Cart cart : listCart) {
                total = total + cart.getAmount() * cart.getProduct().getProductPrice();
            }

            discount =  Math.ceil(total * 0.1 * 10) / 10 ;
            double subtotal = total - discount;
            String discountMess = "Discount 10%";
            String subtotalMess = "Subtotal";
            request.setAttribute("discountMess", discountMess);
            request.setAttribute("subtotalMess", subtotalMess);
            request.setAttribute("discount", discount+"$");
            request.setAttribute("subtotal", subtotal+"$");
            request.getRequestDispatcher("cart.jsp").forward(request, response);
        } else {
            String discountMess = "YOUR CART IS CURRENTLY EMPTY!";
            String subtotalMess = "Click on Continue shopping to shop.";
            request.setAttribute("discountMess", discountMess);
            request.setAttribute("subtotalMess", subtotalMess);
            request.getRequestDispatcher("cart.jsp").forward(request, response);

        }
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
