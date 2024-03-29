/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAL.CartDAO;
import DAL.CategoryDAO;
import DAL.CustomerAccountDAO;
import DAL.CustomerDAO;
import DAL.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Cart;
import model.Category;
import model.Customer;
import model.CustomerAccount;
import model.Order;

/**
 *
 * @author ASUS
 */
public class checkOutController extends HttpServlet {

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
            out.println("<title>Servlet checkoutController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet checkoutController at " + request.getContextPath() + "</h1>");
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
        ArrayList<Category> listCategory = new ArrayList<>();
        CategoryDAO cd = new CategoryDAO();
        listCategory = cd.getCategory();
        
        if (session.getAttribute("listcart") == null) {
            response.sendRedirect("showCartController");
        } else {
            ArrayList<Cart> listCart = (ArrayList<Cart>) session.getAttribute("listcart");
            double discount = 0;
            double total = 0;
            for (Cart cart : listCart) {
                total = total + cart.getAmount() * cart.getProduct().getProductPrice();
            }
            //if user login
            if (session.getAttribute("acc") != null) {
                discount = Math.floor(total * 0.1 * 10.0) / 10.0;
                double subtotal = total - discount;
                request.setAttribute("discount", discount + "$");
                request.setAttribute("subtotal", subtotal + "$");
                request.setAttribute("listB", listCart);
                request.setAttribute("listC", listCategory);
                request.getRequestDispatcher("checkout.jsp").forward(request, response);
            } else {
                request.setAttribute("subtotal", total + "$");
                request.setAttribute("listB", listCart);
                request.setAttribute("listC", listCategory);
                request.getRequestDispatcher("checkout.jsp").forward(request, response);
            }
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
        HttpSession session = request.getSession();
        String firstname = request.getParameter("checkoutFName");
        String lastname = request.getParameter("checkoutLName");
        String address = request.getParameter("checkoutAddress");
        String city = request.getParameter("checkoutCity");
        String phone = request.getParameter("checkoutPhone");
        Customer cust = new Customer();
        cust.setFirstname(firstname);
        cust.setLastname(lastname);
        cust.setAddress(address);
        cust.setCity(city);
        cust.setPhone(phone);

        CustomerDAO custdao = new CustomerDAO();
        Customer custcheck = custdao.getCustomer(cust);
        Date today = new Date(System.currentTimeMillis());

        //check new customer has been saved in database before or not
        if (custcheck == null) {
            custdao.insertCustomer(cust);
            //if user login
            if (session.getAttribute("acc") != null) {
                CustomerAccountDAO Cad = new CustomerAccountDAO();
                Account a = (Account) session.getAttribute("acc");
                int lastCustId = custdao.getLastIdOfCustomer();
                CustomerAccount ca = Cad.getCustomerAndAccountByCustIdAndAccId(lastCustId, a.getAid());
                // if customerid and account id not exist in CustomerAccount table before
                if (ca == null) {
                    Cad.addCustomerAndAccount(lastCustId, a.getAid());
                }
                Order order = new Order();
                OrderDAO oda = new OrderDAO();
                order.setCustid(lastCustId);
                order.setAccountorderid(a.getAid());
                order.setOrderDate(today);
                oda.insertOrder(order);

            }//if user not login
            else {
                int accountid = 0;
                int lastCustId = custdao.getLastIdOfCustomer();
                Order order = new Order();
                OrderDAO oda = new OrderDAO();
                order.setCustid(lastCustId);
                order.setAccountorderid(accountid);
                order.setOrderDate(today);
                oda.insertOrder(order);
            }
        } //if customer has been exist in database
        else {
            //if user login
            if (session.getAttribute("acc") != null) {
                CustomerAccountDAO Cad = new CustomerAccountDAO();
                Account a = (Account) session.getAttribute("acc");
                CustomerAccount ca = Cad.getCustomerAndAccountByCustIdAndAccId(custcheck.getCustid(), a.getAid());
                // if customerid and account id not exist in CustomerAccount table before 
                if (ca == null) {
                    Cad.addCustomerAndAccount(custcheck.getCustid(), a.getAid());
                }
                Order order = new Order();
                OrderDAO oda = new OrderDAO();
                order.setCustid(custcheck.getCustid());
                order.setAccountorderid(a.getAid());
                order.setOrderDate(today);
                oda.insertOrder(order);

            }//if user not login
            else {
                int accountid = 0;
                Order order = new Order();
                OrderDAO oda = new OrderDAO();
                order.setCustid(custcheck.getCustid());
                order.setAccountorderid(accountid);
                order.setOrderDate(today);
                oda.insertOrder(order);
            }
        }
        // add data to cart table
        ArrayList<Cart> listCart = (ArrayList<Cart>) session.getAttribute("listcart");
        CartDAO cartDAO = new CartDAO();
        for (Cart cart : listCart) {
            cartDAO.insertCart(cart);
        }
        session.removeAttribute("listcart");
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
