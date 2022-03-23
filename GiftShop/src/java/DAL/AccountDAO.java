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

    public int getTotalPage(int pagesize) {
        int totalPage = 0;
        try {
            String sql = "SELECT COUNT(aid)as totalaccout From Account";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int totalaccout = rs.getInt("totalaccout");
                totalPage = totalaccout / pagesize;
                if (totalaccout % pagesize != 0) {
                    totalPage++;
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalPage;
    }

    public ArrayList<Account> getListAccountsWithPage(int index, int pagesize) {
        ArrayList<Account> listAccount = new ArrayList<>();
        try {
            String sqlquery = "SELECT * From (\n"
                    + "SELECT   [aid]\n"
                    + "      ,[username]\n"
                    + "      ,[password]\n"
                    + "      ,[isAdmin], ROW_NUMBER() OVER(ORDER BY [aid]) RN\n"
                    + "   FROM [giftShopDb].[dbo]. [Account]\n"
                    + "  ) t\n"
                    + "WHERE RN BETWEEN ? AND ?";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setInt(1, index * pagesize - (pagesize - 1));
            statement.setInt(2, index * pagesize);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Account a = new Account();
                a.setAid(rs.getInt("aid"));
                a.setUser(rs.getString("username"));
                a.setPass(rs.getString("password"));
                a.setIsAdmin(rs.getBoolean("isAdmin"));
                listAccount.add(a);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAccount;
    }

    public Account getAccountsById(String id) {
        try {
            String sqlquery = "Select aid,username,[password],isAdmin From Account \n"
                    + "Where aid = ?";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setString(1, id);
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

    public static void main(String[] args) {
        AccountDAO ad = new AccountDAO();
        ArrayList<Account> accounts = new ArrayList<>();
        accounts = ad.getListAccountsWithPage(1, 8);

        System.out.println("user: " + accounts.get(0).getUser());
    }

    public void deleteAccount(String id) {
        try {
            String sql = "DELETE From [Account] Where aid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addAccountByAdmin(Account a) {
        try {
            String sqlquery = "INSERT INTO Account(username, [password], isAdmin) VALUES (?, ?, ?);";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setString(1, a.getUser());
            statement.setString(2, a.getPass());
            statement.setBoolean(3, a.isIsAdmin());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void updateAccount(Account a) {
        try {
            String sql = "UPDATE [Account] SET [password]=?, [isAdmin]=?   WHERE [aid] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, a.getPass());
            statement.setBoolean(2, a.isIsAdmin());
            statement.setInt(3, a.getAid());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
