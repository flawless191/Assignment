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
import model.Account;

/**
 *
 * @author ASUS
 */
public class AccountDAO extends BaseDAO<Object> {

    public Account getAccounts(String user, String pass) {
        try {
            String sqlquery = "Select aid,username,[password],isAdmin From Account \n"
                    + "Where username = ? and [password] = ?";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setString(1, user);
            statement.setString(2, pass);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Account a = new Account();
                a.setAid(rs.getInt("aid"));
                a.setUser(rs.getString("username"));
                a.setPass(rs.getString("password"));
                a.setIsAdmin(rs.getBoolean("isAdmin"));
                return a;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Account checkAccountsExist(String user) {
        try {
            String sqlquery = "Select aid,username,[password],isAdmin From Account \n"
                    + "Where username = ?";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setString(1, user);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Account a = new Account();
                a.setAid(rs.getInt("aid"));
                a.setUser(rs.getString("username"));
                a.setPass(rs.getString("password"));
                a.setIsAdmin(rs.getBoolean("isAdmin"));
                return a;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void addAccount(Account a) {
        try {
            String sqlquery = "INSERT INTO Account(username, [password], isAdmin) VALUES (?, ?, 0);";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setString(1, a.getUser());
            statement.setString(2, a.getPass());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
