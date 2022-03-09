/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.PreparedStatement;
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
}
