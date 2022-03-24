/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cart;
import model.Product;

/**
 *
 * @author ASUS
 */
public class CartDAO extends BaseDAO<Object> {

    public int getIdOfLastCart() {
        int lastCartId = 0;
        try {
            String sql = "Select TOP 1 cartid From Cart\n"
                    + "Order By cartid Desc";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                lastCartId = rs.getInt("cartid");
                return lastCartId;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lastCartId;
    }

    public void insertCart(Cart cart) {
        try {
            String sql = "Insert Into Cart (orderid,pid,amount)\n"
                    + "Values (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, cart.getCartid());
            statement.setInt(2, cart.getProduct().getPid());
            statement.setInt(3, cart.getAmount());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deletCart(int orderid, int productid) {
        try {
            String sql = "Delete From Cart Where orderid=? And pid=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, orderid);
            statement.setInt(2, productid);

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Cart> getListCartById(int id) {
        ArrayList<Cart> listCartDetails = new ArrayList<>();
        try {
            String sqlquery = "SELECT [orderid]\n"
                    + "      ,[pid]\n"
                    + "      ,[amount]\n"
                    + "  FROM [giftShopDb].[dbo].[Cart]\n"
                    + "  Where orderid =?";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Cart c = new Cart();
                c.setCartid(rs.getInt("orderid"));
                ProductDAO pd = new ProductDAO();
                Product p = new Product();
                p = pd.getProductById(rs.getInt("pid"));
                c.setProduct(p);
                c.setAmount(rs.getInt("amount"));

                listCartDetails.add(c);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCartDetails;
    }

    public static void main(String[] args) {
        ArrayList<Cart> listCartDetails = new ArrayList<>();
        CartDAO cartd = new CartDAO();

        listCartDetails = cartd.getListCartById(1);
        System.out.println("Product" + listCartDetails.get(0).getAmount());
    }

    public void deleteCartByOrderId(String id) {
        try {
            String sql = "DELETE From [Cart] Where orderid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cart getCartByOrderIdAndProductId(int orderid, int productid) {
        try {
            String sql = "SELECT [orderid]\n"
                    + "      ,[pid]\n"
                    + "      ,[amount]\n"
                    + "  FROM [giftShopDb].[dbo].[Cart]\n"
                    + "  Where [orderid] = ? and [pid] =? \n"
                    + "  ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, orderid);
            statement.setInt(2, productid);
             ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Cart c = new Cart();
                c.setCartid(rs.getInt("orderid"));
                ProductDAO pd = new ProductDAO();
                Product p = new Product();
                p = pd.getProductById(rs.getInt("pid"));
                c.setProduct(p);
                c.setAmount(rs.getInt("amount"));

                return c;

            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void updateCartDetails(Cart c, int oldPid) {
        try {
            String sql = "UPDATE Cart Set pid = ?, amount = ? Where orderid = ? and pid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, c.getProduct().getPid());
            statement.setInt(2, c.getAmount());
            statement.setInt(3, c.getCartid());
            statement.setInt(4, oldPid);
            

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
