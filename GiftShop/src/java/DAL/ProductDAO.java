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
import model.Product;

/**
 *
 * @author ASUS
 */
public class ProductDAO extends BaseDAO<Object> {

    public ArrayList<Product> get4NewProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sqlquery = "SELECT Top 4 [pid]\n"
                    + "      ,[productname]\n"
                    + "      ,[productimg]\n"
                    + "      ,[productprice]\n"
                    + "      ,[productnote]\n"
                    + "      ,[cid]\n"
                    + "  From Product Order By pid DESC ";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setPid(rs.getInt("pid"));
                p.setProductName(rs.getString("productname"));
                p.setProductImg(rs.getString("productimg"));
                p.setProductPrice(rs.getInt("productprice"));
                p.setProductNote(rs.getString("productnote"));
                p.setCid(rs.getInt("cid"));
                products.add(p);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public ArrayList<Product> get4BestSell() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sqlquery = "Select p.[pid]\n"
                    + "      ,p.[productname]\n"
                    + "      ,p.[productimg]\n"
                    + "      ,p.[productprice]\n"
                    + "      ,p.[productnote]\n"
                    + "      ,p.[cid] From\n"
                    + " (Select Top 4 c.pid, sum(c.amount) as TotalProduct From Cart c\n"
                    + " Group by c.pid\n"
                    + " Order by TotalProduct Desc) t, Product p\n"
                    + " where p.pid = t.pid";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setPid(rs.getInt("pid"));
                p.setProductName(rs.getString("productname"));
                p.setProductImg(rs.getString("productimg"));
                p.setProductPrice(rs.getInt("productprice"));
                p.setProductNote(rs.getString("productnote"));
                p.setCid(rs.getInt("cid"));
                products.add(p);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public ArrayList<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sqlquery = "SELECT  [pid]\n"
                    + "      ,[productname]\n"
                    + "      ,[productimg]\n"
                    + "      ,[productprice]\n"
                    + "      ,[productnote]\n"
                    + "      ,[cid]\n"
                    + "  FROM [giftShopDb].[dbo].[Product]";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setPid(rs.getInt("pid"));
                p.setProductName(rs.getString("productname"));
                p.setProductImg(rs.getString("productimg"));
                p.setProductPrice(rs.getInt("productprice"));
                p.setProductNote(rs.getString("productnote"));
                p.setCid(rs.getInt("cid"));
                products.add(p);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }
}
