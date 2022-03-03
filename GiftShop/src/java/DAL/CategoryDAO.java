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
import model.Category;

/**
 *
 * @author ASUS
 */
public class CategoryDAO extends BaseDAO<Object> {

    public ArrayList<Category> getCategory() {
        ArrayList<Category> listCategory = new ArrayList<>();
        try {
            String sqlquery = "SELECT  [cid]\n"
                    + "      ,[categoryname]\n"
                    + "  FROM [giftShopDb].[dbo].[Category]";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setCid(rs.getInt("cid"));
                c.setCategoryName(rs.getString("categoryname"));
                
                listCategory.add(c);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCategory;
    }

}
