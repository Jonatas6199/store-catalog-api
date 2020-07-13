package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import VO.Product;
import DAO.DAOInterface;

public class ProductDAO implements DAOInterface<Product> {
	private Connection connection;
	
	public ProductDAO() {
		try {
			this.connection = DbUtil.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Product product) {
		try {
            PreparedStatement preparedStatement = connection
            		.prepareStatement("INSERT INTO CatalogDB.Product (productName, productDescription, productPrice, "
            				+ "categoryId) VALUES (?, ?, ?, ?)");

            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getCategoryId());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
        	e.printStackTrace();
        }
	}

	@Override
	public void update(Product product) {
		
		try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE CatalogDB.Product SET productName = ?, productDescription = ?, "
                    		+ "productPrice = ?, categoryId = ? WHERE productId = ?");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getCategoryId());
            preparedStatement.setInt(5, product.getId());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void delete(Product product) {
		try {
        	PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM CatalogDB.Product WHERE productId=?");
            preparedStatement.setInt(1, product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	e.printStackTrace();
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}

	@Override
	public Product find(Product product) {
		
		Product p = new Product();
        
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * FROM CatalogDB.Product WHERE productId=?");
            
            preparedStatement.setLong(1, product.getId());
            ResultSet rs = preparedStatement.executeQuery();
           
            if (rs.next()) {
            	p.setId(rs.getInt("productId"));
            	p.setName(rs.getString("productName"));
            	p.setDescription(rs.getString("productDescription"));
            	p.setPrice(rs.getDouble("productPrice"));
            	p.setCategoryId(rs.getInt("categoryId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}

        return p;	
	}

	@Override
	public ArrayList<Product> findAll() {
		ArrayList<Product> pList = new ArrayList<Product>(); 
        try {     	
            Statement statement = connection.createStatement();           
            ResultSet rs = statement.executeQuery("SELECT * FROM CatalogDB.Product");
            while (rs.next()) {
                
            	Product p = new Product();
            	
            	p.setId(rs.getInt("productId"));
            	p.setName(rs.getString("productName"));
            	p.setDescription(rs.getString("productDescription"));
            	p.setPrice(rs.getDouble("productPrice"));
            	p.setCategoryId(rs.getInt("categoryId"));

                pList.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}
        return pList;
	}	
}