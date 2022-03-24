/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Order;

/**
 *
 * @author ASUS
 */
public class OrderDAO extends BaseDAO<Object> {

    public int getLastIdOfOrder() {
        int lastOrderId = 0;
        try {
            String sql = "Select TOP 1 orderid From [Order]\n"
                    + "Order By orderid Desc";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                lastOrderId = rs.getInt("orderid");
                return lastOrderId;

            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lastOrderId;
    }

    public void insertOrder(Order o) {
        try {
            String sql = "INSERT INTO [Order](custid,accountidorder,orderdate) VALUES (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, o.getCustid());

            if (o.getAccountorderid() == 0) {
                statement.setString(2, null);
            } else {
                statement.setInt(2, o.getAccountorderid());

            }
            statement.setDate(3, o.getOrderDate());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        OrderDAO od = new OrderDAO();
        ArrayList<Order> listOrder = new ArrayList<>();
        listOrder = od.getListOrder();
        System.out.println("Oder: " + listOrder.get(2).getOrderid());
    }

    public ArrayList<Order> getListOrder() {
        ArrayList<Order> listOrder = new ArrayList<>();
        try {
            String sqlquery = "SELECT [orderid]\n"
                    + "      ,[custid]\n"
                    + "      ,[accountidorder]\n"
                    + "      ,[orderdate]\n"
                    + "  FROM [giftShopDb].[dbo].[Order]";

            PreparedStatement statement = connection.prepareStatement(sqlquery);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Order o = new Order();
                o.setOrderid(rs.getInt("orderid"));
                o.setCustid(rs.getInt("custid"));
                o.setAccountorderid(rs.getInt("accountidorder"));
                o.setOrderDate(rs.getDate("orderdate"));
                listOrder.add(o);

            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listOrder;
    }

    public int getTotalOrderPage(int pagesize) {
        int totalPage = 0;
        try {
            String sql = "SELECT COUNT(orderid)as totalorder From [Order]";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int totalOrder = rs.getInt("totalorder");
                totalPage = totalOrder / pagesize;
                if (totalOrder % pagesize != 0) {
                    totalPage++;
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalPage;
    }

    public ArrayList<Order> getListOrderWithPage(int index, int pagesize) {
        ArrayList<Order> listOrder = new ArrayList<>();
        try {
            String sqlquery = "SELECT * From (\n"
                    + "SELECT [orderid]\n"
                    + "      ,[custid]\n"
                    + "      ,[accountidorder]\n"
                    + "      ,[orderdate], ROW_NUMBER() OVER(ORDER BY [orderid]) RN\n"
                    + "  FROM [giftShopDb].[dbo].[Order]\n"
                    + "  ) t\n"
                    + "WHERE RN BETWEEN ? AND ?";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setInt(1, index * pagesize - (pagesize - 1));
            statement.setInt(2, index * pagesize);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Order o = new Order();
                o.setOrderid(rs.getInt("orderid"));
                o.setCustid(rs.getInt("custid"));
                o.setAccountorderid(rs.getInt("accountidorder"));
                o.setOrderDate(rs.getDate("orderdate"));
                listOrder.add(o);

            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listOrder;
    }

    public Order getOrdersById(String id) {
        try {
            String sqlquery = "SELECT [orderid]\n"
                    + "      ,[custid]\n"
                    + "      ,[accountidorder]\n"
                    + "      ,[orderdate]\n"
                    + "  FROM [giftShopDb].[dbo].[Order]\n"
                    + "  Where orderid = ?";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setOrderid(rs.getInt("orderid"));
                o.setCustid(rs.getInt("custid"));
                o.setAccountorderid(rs.getInt("accountidorder"));
                o.setOrderDate(rs.getDate("orderdate"));
                return o;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void deleteOrder(String id) {
        try {
            String sql = "DELETE From [Order] Where orderid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateOrder(Order o) {
        try {
            String sql = "UPDATE [Order] Set custid = ?, accountidorder =?, orderdate=? Where orderid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, o.getCustid());
            if (o.getAccountorderid() == 0) {
                statement.setString(2, null);
            } else {
                statement.setInt(2, o.getAccountorderid());

            }
            statement.setDate(3, o.getOrderDate());
            statement.setInt(4, o.getOrderid());
            

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
