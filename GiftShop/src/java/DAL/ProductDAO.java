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
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public ArrayList<Product> getProductByCategoryId(int id) {
        try {
            ArrayList<Product> products = new ArrayList<>();

            String sql = "SELECT  [pid]\n"
                    + "      ,[productname]\n"
                    + "      ,[productimg]\n"
                    + "      ,[productprice]\n"
                    + "      ,[productnote]\n"
                    + "      ,[cid]\n"
                    + "  FROM [Product]\n"
                    + "  Where [cid]= ?\n"
                    + "  ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
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
            return products;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void deleteProduct(int id) {
        try {
            String sql = "DELETE Product WHERE pid=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertProduct(Product p) {
        try {
            String sql = "INSERT INTO Product(productname,productimg,productprice,productnote,cid)\n"
                    + "Values (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, p.getProductName());
            statement.setString(2, p.getProductImg());
            statement.setInt(3, p.getProductPrice());
            statement.setString(4, p.getProductNote());
            statement.setInt(5, p.getCid());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Product getProductById(int id) {
        try {
            String sql = "SELECT  [pid]\n"
                    + "      ,[productname]\n"
                    + "      ,[productimg]\n"
                    + "      ,[productprice]\n"
                    + "      ,[productnote]\n"
                    + "      ,[cid]\n"
                    + "  FROM [Product]\n"
                    + "  Where [pid]= ?\n"
                    + "  ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setPid(rs.getInt("pid"));
                p.setProductName(rs.getString("productname"));
                p.setProductImg(rs.getString("productimg"));
                p.setProductPrice(rs.getInt("productprice"));
                p.setProductNote(rs.getString("productnote"));
                p.setCid(rs.getInt("cid"));
                return p;

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateProduct(Product p) {
        try {
            String sql = "Update [Product] Set [productname] = ?,\n"
                    + "[productimg] =?, \n"
                    + "[productprice] = ?, \n"
                    + "[productnote]=?,\n"
                    + "[cid]= ? \n"
                    + "Where [pid] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, p.getProductName());
            statement.setString(2, p.getProductImg());
            statement.setInt(3, p.getProductPrice());
            statement.setString(4, p.getProductNote());
            statement.setInt(5, p.getCid());
            statement.setInt(6, p.getPid());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getTotalPage(int pagesize) {
        int totalPage = 0;
        try {
            String sql = "SELECT COUNT(pid)as totalproduct From Product";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int totalProduct = rs.getInt("totalproduct");
                totalPage = totalProduct / pagesize;
                if (totalProduct % pagesize != 0) {
                    totalPage++;
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalPage;
    }
    
    public ArrayList<Product> getProductWithPaging(int index,int pagesize) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sqlquery = "SELECT * From (\n"
                    + "SELECT  [pid]\n"
                    + "      ,[productname]\n"
                    + "      ,[productimg]\n"
                    + "      ,[productprice]\n"
                    + "      ,[productnote]\n"
                    + "      ,[cid], ROW_NUMBER() OVER(ORDER BY [pid]) RN\n"
                    + "  FROM [giftShopDb].[dbo].[Product] \n"
                    + "  ) t\n"
                    + "WHERE RN BETWEEN ? AND ?";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setInt(1, index * pagesize - (pagesize-1));
            statement.setInt(2, index * pagesize);

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
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }
    
    public int getTotalPageByCategory(int cid,int pagesize) {
        int totalPage = 0;
        try {
            String sql = " SELECT COUNT(pid)as totalproduct\n"
                    + "  FROM [giftShopDb].[dbo].[Product] \n"
                    + " Where cid =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, cid);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int totalProduct = rs.getInt("totalproduct");
                totalPage = totalProduct / pagesize;
                if (totalProduct % pagesize != 0) {
                    totalPage++;
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalPage;
    }
    
    public ArrayList<Product> getProductByCategoryWithPaging(int cid, int index, int pagesize) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sqlquery = "SELECT * From (\n"
                    + "SELECT  [pid]\n"
                    + "      ,[productname]\n"
                    + "      ,[productimg]\n"
                    + "      ,[productprice]\n"
                    + "      ,[productnote]\n"
                    + "      ,[cid], ROW_NUMBER() OVER(ORDER BY [pid]) RN\n"
                    + "  FROM [giftShopDb].[dbo].[Product] \n"
                    + "   Where [cid] = ?\n"
                    + "  ) t\n"
                    + "WHERE RN BETWEEN ? AND ?";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setInt(1, cid);

            statement.setInt(2, index * pagesize - (pagesize-1));
            statement.setInt(3, index * pagesize);

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
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }
    
    public int getTotalPageSreachByName(String nameToSearch, int pagesize) {
        int totalPage = 0;
        try {
            String sql = " SELECT  COUNT(pid)as totalproduct\n"
                    + "  FROM [giftShopDb].[dbo].[Product] \n"
                    + "   Where [productname] Like ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + nameToSearch + "%");

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int totalProduct = rs.getInt("totalproduct");
                totalPage = totalProduct / pagesize;
                if (totalProduct % pagesize != 0) {
                    totalPage++;
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalPage;
    }
    
     public ArrayList<Product> getProductSearchByNameWithPaging(String nameToSearch, int index, int pagesize) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sqlquery = "SELECT * From (\n"
                    + "SELECT  [pid]\n"
                    + "      ,[productname]\n"
                    + "      ,[productimg]\n"
                    + "      ,[productprice]\n"
                    + "      ,[productnote]\n"
                    + "      ,[cid], ROW_NUMBER() OVER(ORDER BY [pid]) RN\n"
                    + "  FROM [giftShopDb].[dbo].[Product] \n"
                    + "   Where [productname] Like ?\n"
                    + "  ) t\n"
                    + "WHERE RN BETWEEN ? AND ?";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setString(1, "%" + nameToSearch + "%");

            statement.setInt(2, index * pagesize - (pagesize-1));
            statement.setInt(3, index * pagesize);

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
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }
}
