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
public class addDetailsController extends HttpServlet {

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
            out.println("<title>Servlet addDetailsController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addDetailsController at " + request.getContextPath() + "</h1>");
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
        request.setAttribute("currentorderid", oid);
        request.getRequestDispatcher("addCartDetails.jsp").forward(request, response);
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
        int orederid = Integer.parseInt(oid);
        int productid = Integer.parseInt(pid);
        int amount = Integer.parseInt(amountString);
        ProductDAO pd = new ProductDAO();
        Product product = new Product();
        product = pd.getProductById(productid);
        //check product exist or not
        if (product == null) {
            request.setAttribute("alertMess", "Don't exist product has product id = " + productid);
            request.setAttribute("currentorderid", oid);

            request.getRequestDispatcher("addCartDetails.jsp").forward(request, response);
        } else {
            Cart c = new Cart();
            CartDAO cd = new CartDAO();
            c = cd.getCartByOrderIdAndProductId(orederid, productid);
            //check new cart details exist in database before or not
            if (c != null) {
                request.setAttribute("alertMess", "Already exist cart details with this information in database.");
                request.setAttribute("currentorderid", oid);

                request.getRequestDispatcher("addCartDetails.jsp").forward(request, response);
            } else {
                Cart cart = new Cart();

                cart.setCartid(orederid);
                cart.setProduct(product);
                cart.setAmount(amount);
                cd.insertCart(cart);
                response.sendRedirect("cartDetails?cartid=" + orederid);
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
