/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAL.CartDAO;
import DAL.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cart;
import model.Product;

/**
 *
 * @author ASUS
 */
public class updateDetailsController extends HttpServlet {

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
            out.println("<title>Servlet updateDetailsController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateDetailsController at " + request.getContextPath() + "</h1>");
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

        String oid = request.getParameter("oid");
        String pid = request.getParameter("pid");
        int orederid = Integer.parseInt(oid);
        int productid = Integer.parseInt(pid);
        Cart c = new Cart();
        CartDAO cd = new CartDAO();
        c = cd.getCartByOrderIdAndProductId(orederid, productid);
        request.setAttribute("cart", c);
        request.setAttribute("oldPid", productid);

        request.getRequestDispatcher("updateCartDetails.jsp").forward(request, response);
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
        String oid = request.getParameter("oid");
        String pid = request.getParameter("pid");
        String amountString = request.getParameter("amount");
        String oldPid = request.getParameter("oldPid");
        int oldProductId = Integer.parseInt(oldPid);

        int orederid = Integer.parseInt(oid);
        int productid = Integer.parseInt(pid);
        int amount = Integer.parseInt(amountString);
        Cart cart = new Cart();
        cart.setCartid(orederid);
        //if still the old cart details
        if (oldProductId == productid) {
            ProductDAO pd = new ProductDAO();
            Product product = new Product();
            product = pd.getProductById(productid);
            cart.setProduct(product);
            cart.setAmount(amount);
            CartDAO cd = new CartDAO();

            cd.updateCartDetails(cart, oldProductId);
            response.sendRedirect("cartDetails?cartid=" + orederid);
        } else {
            ProductDAO pd = new ProductDAO();
            Product product = new Product();
            product = pd.getProductById(productid);
            //check product exist or not
            if (product == null) {

                request.setAttribute("alertMess", "Don't exist product has product id = " + productid);
                request.setAttribute("cart", cart);
                request.setAttribute("oldPid", oldProductId);

                request.getRequestDispatcher("updateCartDetails.jsp").forward(request, response);
            } else {
                Cart c = new Cart();
                CartDAO cd = new CartDAO();
                c = cd.getCartByOrderIdAndProductId(orederid, productid);
                //check new cart details exist in database before or not
                if (c != null) {
                    request.setAttribute("oldPid", oldProductId);

                    request.setAttribute("alertMess", "Already exist cart details with this information in database.");
                    request.setAttribute("cart", cart);

                    request.getRequestDispatcher("updateCartDetails.jsp").forward(request, response);
                } else {

                    cart.setProduct(product);
                    cart.setAmount(amount);
                    cd.updateCartDetails(cart, oldProductId);
                    response.sendRedirect("cartDetails?cartid=" + orederid);
                }

            }
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
