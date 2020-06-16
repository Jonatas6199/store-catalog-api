package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import VO.Category;
import DAO.DAOInterface;

public class CategoryDAO implements DAOInterface<Category> {
	private Connection connection;
	
	public CategoryDAO() {
		try {
			this.connection = DbUtil.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Category category) {
		try {
            PreparedStatement preparedStatement = connection
            		.prepareStatement("INSERT INTO CatalogDB.Category (categoryName) VALUES (?)");
            preparedStatement.setString(1, category.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
        	e.printStackTrace();
        }
	}

	@Override
	public void update(Category category) {
		
		try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE CATALOGDB.Category SET categoryName=? WHERE categoryId=?");
            preparedStatement.setString(1, category.getName());
            preparedStatement.setInt(2, category.getId());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void delete(Category category) {
		try {
        	PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM CATALOGDB.Category WHERE categoryId=?");
            preparedStatement.setInt(1, category.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	e.printStackTrace();
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}

	@Override
	public Category find(Category category) {
		
		Category c = new Category();
        
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * FROM CATALOGDB.Category WHERE categoryId=?");
            
            preparedStatement.setLong(1, category.getId());
            ResultSet rs = preparedStatement.executeQuery();
           
            if (rs.next()) {
                c.setId(rs.getInt("categoryId"));
                c.setName(rs.getString("categoryName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}

        return c;	
	}

	@Override
	public ArrayList<Category> findAll(Category category) {
		ArrayList<Category> cList = new ArrayList<Category>(); 
        try {     	
            Statement statement = connection.createStatement();           
            ResultSet rs = statement.executeQuery("SELECT * FROM CATALOGDB.Category");
            while (rs.next()) {
                
            	Category c = new Category();
                
            	c.setId(rs.getInt("categoryId"));
                c.setName(rs.getString("categoryName"));

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