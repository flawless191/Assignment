/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;

/**
 *
 * @author ASUS
 */
public class CustomerDAO extends BaseDAO<Object> {
    
    public void insertCustomer(Customer cust) {
        try {
            String sql = "INSERT INTO Customer(firstname,lastname,[address],city,phone)\n"
                    + "values (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cust.getFirstname());
            statement.setString(2, cust.getLastname());
            statement.setString(3, cust.getAddress());
            statement.setString(4, cust.getCity());
            statement.setString(5, cust.getPhone());
            
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Customer getCustomer(Customer cust) {
        try {
            String sql = "SELECT [custid]\n"
                    + "      ,[firstname]\n"
                    + "      ,[lastname]\n"
                    + "      ,[address]\n"
                    + "      ,[city]\n"
                    + "      ,[phone]\n"
                    + "  FROM [giftShopDb].[dbo].[Customer]\n"
                    + "  \n"
                    + "  Where [firstname]=?  and [lastname] =? and [address] = ? and [city] =? and [phone]=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cust.getFirstname());
            statement.setString(2, cust.getLastname());
            statement.setString(3, cust.getAddress());
            statement.setString(4, cust.getCity());
            statement.setString(5, cust.getPhone());
            
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Customer c = new Customer();
                c.setCustid(rs.getInt("custid"));
                c.setFirstname(rs.getString("firstname"));
                c.setLastname(rs.getString("lastname"));
                c.setAddress(rs.getString("address"));
                c.setCity(rs.getString("city"));
                c.setPhone(rs.getString("phone"));
                
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int getLastIdOfCustomer() {
        int lastCustId = 0;
        try {
            String sql = "Select TOP 1 custid From Customer\n"
                    + "Order By custid Desc";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                lastCustId = rs.getInt("custid");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lastCustId;
    }

    public Customer getCustomerById(int id) {
        try {
            String sql = "SELECT [custid]\n"
                    + "      ,[firstname]\n"
                    + "      ,[lastname]\n"
                    + "      ,[address]\n"
                    + "      ,[city]\n"
                    + "      ,[phone]\n"
                    + "  FROM [giftShopDb].[dbo].[Customer]\n"
                    + "  \n"
                    + "  Where [custid]=? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            
            
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Customer c = new Customer();
                c.setCustid(rs.getInt("custid"));
                c.setFirstname(rs.getString("firstname"));
                c.setLastname(rs.getString("lastname"));
                c.setAddress(rs.getString("address"));
                c.setCity(rs.getString("city"));
                c.setPhone(rs.getString("phone"));
                
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
