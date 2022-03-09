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
import model.CustomerAccount;

/**
 *
 * @author ASUS
 */
public class CustomerAccountDAO extends BaseDAO<Object> {

    public CustomerAccount getCustomerAndAccountByCustIdAndAccId(int custid, int aid) {
        try {
            String sqlquery = "Select custid,aid From CustomerAccount \n"
                    + "Where custid = ? and aid = ?";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setInt(1, custid);
            statement.setInt(2, aid);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                CustomerAccount ca = new CustomerAccount();
                ca.setCustid(rs.getInt("custid"));
                ca.setAid(rs.getInt("aid"));

                return ca;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        CustomerAccountDAO cd = new CustomerAccountDAO();
        CustomerAccount ca = cd.getCustomerAndAccountByCustIdAndAccId(1, 5);
        System.out.println(ca.getAid());
        cd.addCustomerAndAccount(4, 2);
    }

    public void addCustomerAndAccount(int custid, int aid) {
        try {
            String sqlquery = "INSERT INTO CustomerAccount(custid,aid)\n"
                    + "values (?,?)";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setInt(1, custid);
            statement.setInt(2, aid);

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
