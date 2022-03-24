/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAL.AccountDAO;
import DAL.CustomerAccountDAO;
import DAL.CustomerDAO;
import DAL.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Customer;
import model.CustomerAccount;
import model.Order;

/**
 *
 * @author ASUS
 */
public class addOrderController extends HttpServlet {

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
            out.println("<title>Servlet addOrderController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addOrderController at " + request.getContextPath() + "</h1>");
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
        response.sendRedirect("addOrder.jsp");

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
        String custId = request.getParameter("custId");

        String dateString = request.getParameter("orderDate");
        int custID = Integer.parseInt(custId);
        Customer cust = new Customer();
        CustomerDAO custd = new CustomerDAO();
        cust = custd.getCustomerById(custID);
        //check customerid exist or not
        if (cust == null) {
            request.setAttribute("alertMess", "Don't exist customer has customer id: " + custID + ".");
            request.getRequestDispatcher("addOrder.jsp").forward(request, response);
        } else {
            int aId;
            //if user not input accountid
            if (request.getParameter("accountId").equals("") == true || request.getParameter("accountId") == null) {
                aId = 0;
            } else {
                aId = Integer.parseInt(request.getParameter("accountId"));
            }

            Account a = new Account();
            AccountDAO ad = new AccountDAO();
            a = ad.getAccountsById(aId + "");
            //check account exist
            if (a == null && aId != 0) {
                request.setAttribute("alertMess", "Don't exist account has account id: " + aId + ".");
                request.getRequestDispatcher("addOrder.jsp").forward(request, response);
            }

            try {
                Date orderDate = Date.valueOf(dateString);

                Order o = new Order();
                o.setCustid(custID);
                o.setAccountorderid(aId);
                o.setOrderDate(orderDate);

                OrderDAO od = new OrderDAO();
                od.insertOrder(o);
                if (o.getAccountorderid()!=0) {
                        CustomerAccountDAO Cad = new CustomerAccountDAO();

                        CustomerAccount ca = Cad.getCustomerAndAccountByCustIdAndAccId(o.getCustid(), o.getAccountorderid());
                        // if customerid and account id not exist in CustomerAccount table before
                        if (ca == null) {
                            Cad.addCustomerAndAccount(o.getCustid(), o.getAccountorderid());
                        }
                    }
                response.sendRedirect("managerOrder");
            } catch (Exception e) {
                request.setAttribute("alertMess", "Invalid date.");
                request.getRequestDispatcher("addOrder.jsp").forward(request, response);
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
