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
import model.Contact;

/**
 *
 * @author ASUS
 */
public class ContactDAO extends BaseDAO<Object> {

    public void insertContact(Contact con) {
        try {
            String sql = "INSERT INTO Contact(firstname,lastname,[email],[phone],[message],contactdate) \n"
                    + "VALUES (?,?,?,?,?,GETDATE());";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, con.getFirstName());
            statement.setString(2, con.getLastName());
            statement.setString(3, con.getEmail());
            statement.setString(4, con.getPhone());
            statement.setString(5, con.getMessage());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
