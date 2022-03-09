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
import model.Cart;

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
            statement.setInt(1,cart.getCartid());
            statement.setInt(2,cart.getProduct().getPid());
            statement.setInt(3,cart.getAmount());
           
           

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
}