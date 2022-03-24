/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAL.CategoryDAO;
import DAL.OrderCartDAO;
import DAL.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Order;
import model.OrderCart;

/**
 *
 * @author ASUS
 */
public class managerOrderController extends HttpServlet {

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
            out.println("<title>Servlet managerOrderController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet managerOrderController at " + request.getContextPath() + "</h1>");
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
//        OrderCartDAO od1 = new OrderCartDAO();
//        ArrayList<OrderCart> listOrder1 = new ArrayList<>();
//        listOrder1 = od1.getListOrder();
        ArrayList<Category> listCategory = new ArrayList<>();
        CategoryDAO cd = new CategoryDAO();
        listCategory = cd.getCategory();
        OrderDAO od = new OrderDAO();

        int totalPage = 0;
        int pagesize = 12;
        totalPage = od.getTotalOrderPage(pagesize);
        String pageCurrent = request.getParameter("page");
        int pageC = 0;
        if (pageCurrent == null) {
            pageC = 1;
        } else {
            pageC = Integer.parseInt(pageCurrent);

        }
        ArrayList<Order> listOrder = new ArrayList<>();
        listOrder = od.getListOrderWithPage(pageC, pagesize);
        request.setAttribute("listC", listCategory);
        request.setAttribute("listO", listOrder);
        request.setAttribute("totalpage", totalPage);
        request.setAttribute("pageCurrent", pageC);
        request.getRequestDispatcher("managerOrder.jsp").forward(request, response);
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
        String oidString = request.getParameter("oid");
        OrderDAO od = new OrderDAO();
        Order o = new Order();
        o = od.getOrdersById(oidString);
        if (o != null) {
            ArrayList<Category> listCategory = new ArrayList<>();
            CategoryDAO cd = new CategoryDAO();
            listCategory = cd.getCategory();
            ArrayList<Order> listOrder = new ArrayList<>();
            listOrder.add(o);
            request.setAttribute("searchMessage", oidString);
            request.setAttribute("listO", listOrder);
            request.setAttribute("listC", listCategory);
            request.getRequestDispatcher("managerOrder.jsp").forward(request, response);
        } else {
            ArrayList<Category> listCategory = new ArrayList<>();
            CategoryDAO cd = new CategoryDAO();
            listCategory = cd.getCategory();
            request.setAttribute("listC", listCategory);
            request.setAttribute("searchMessage", "No order found");
            request.getRequestDispatcher("managerOrder.jsp").forward(request, response);
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
