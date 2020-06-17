package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import VO.Contact;
import DAO.DAOInterface;

public class ContactDAO implements DAOInterface<Contact> {
	private Connection connection;
	
	public ContactDAO() {
		try {
			this.connection = DbUtil.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Contact contact) {
		try {
            PreparedStatement preparedStatement = connection
            		.prepareStatement("INSERT INTO CATALOGDB.Contact (contactEmail, contactNumber, contactFaceBook, "
            				+ "contactInstagram, contactTwitter, contactYoutube) VALUES (?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, contact.getEmail());
            preparedStatement.setString(2, contact.getNumber());
            preparedStatement.setString(3, contact.getFacebook());
            preparedStatement.setString(4, contact.getInstagram());
            preparedStatement.setString(5, contact.getTwitter());
            preparedStatement.setString(6, contact.getYoutube());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
        	e.printStackTrace();
        }
	}

	@Override
	public void update(Contact contact) {
		
		try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE CATALOGDB.Contact SET contactEmail = ?, contactNumber = ?, "
                    		+ "contactFaceBook = ?, contactInstagram = ?, contactTwitter = ?, contactYoutube = ?"
                    		+ " WHERE contactId = ?");
            preparedStatement.setString(1, contact.getEmail());
            preparedStatement.setString(2, contact.getNumber());
            preparedStatement.setString(3, contact.getFacebook());
            preparedStatement.setString(4, contact.getInstagram());
            preparedStatement.setString(5, contact.getTwitter());
            preparedStatement.setString(6, contact.getYoutube());
            preparedStatement.setInt(7, contact.getId());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void delete(Contact contact) {
		try {
        	PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM CATALOGDB.Contact WHERE contactId=?");
            preparedStatement.setInt(1, contact.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	e.printStackTrace();
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}

	@Override
	public Contact find(Contact contact) {
		
		Contact c = new Contact();
        
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * FROM CATALOGDB.Contact WHERE contactId=?");
            
            preparedStatement.setLong(1, contact.getId());
            ResultSet rs = preparedStatement.executeQuery();
           
            if (rs.next()) {
                c.setId(rs.getInt("contactId"));
                c.setEmail(rs.getString("contactEmail"));
                c.setNumber(rs.getString("contactNumber"));
                c.setFacebook(rs.getString("contactFaceBook"));
                c.setInstagram(rs.getString("contactInstagram"));
                c.setTwitter(rs.getString("contactTwitter"));
                c.setyoutube(rs.getString("contactYoutube"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}

        return c;	
	}

	@Override
	public ArrayList<Contact> findAll(Contact contact) {
		ArrayList<Contact> cList = new ArrayList<Contact>(); 
        try {     	
            Statement statement = connection.createStatement();           
            ResultSet rs = statement.executeQuery("SELECT * FROM CATALOGDB.Contact");
            while (rs.next()) {
                
            	Contact c = new Contact();
                
                c.setId(rs.getInt("contactId"));
                c.setEmail(rs.getString("contactEmail"));
                c.setNumber(rs.getString("contactNumber"));
                c.setFacebook(rs.getString("contactFaceBook"));
                c.setInstagram(rs.getString("contactInstagram"));
                c.setTwitter(rs.getString("contactTwitter"));
                c.setyoutube(rs.getString("contactYotube"));

                cList.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}
        return cList;
	}	
}