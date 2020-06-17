package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import VO.ProductImage;
import DAO.DAOInterface;

public class ProductImageDAO implements DAOInterface<ProductImage> {
	private Connection connection;
	
	public ProductImageDAO() {
		try {
			this.connection = DbUtil.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(ProductImage productImage) {
		try {
            PreparedStatement preparedStatement = connection
            		.prepareStatement("INSERT INTO CatalogDB.ProductImage (imagePath, productId) VALUES (?, ?)");

            preparedStatement.setString(1, productImage.getImagePath());
            preparedStatement.setInt(2, productImage.getProductId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
        	e.printStackTrace();
        }
	}

	@Override
	public void update(ProductImage productImage) {
		
		try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE CATALOGDB.ProductImage SET imagePath = ?, productId = ? WHERE imageId = ?");
            preparedStatement.setString(1, productImage.getImagePath());
            preparedStatement.setInt(2, productImage.getProductId());
            preparedStatement.setInt(3, productImage.getId());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void delete(ProductImage productImage) {
		try {
        	PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM CATALOGDB.ProductImage WHERE imageId = ?");
            preparedStatement.setInt(1, productImage.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	e.printStackTrace();
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}

	@Override
	public ProductImage find(ProductImage productImage) {
		
		ProductImage pi = new ProductImage();
        
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * FROM CATALOGDB.ProductImage WHERE productImage=?");
            
            preparedStatement.setLong(1, productImage.getId());
            ResultSet rs = preparedStatement.executeQuery();
           
            if (rs.next()) {
            	pi.setId(rs.getInt("imageId"));
            	pi.setImagePath(rs.getString("imagePath"));
            	pi.setProductId(rs.getInt("productId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}

        return pi;	
	}

	@Override
	public ArrayList<ProductImage> findAll(ProductImage productImage) {
		ArrayList<ProductImage> piList = new ArrayList<ProductImage>(); 
        try {     	
            Statement statement = connection.createStatement();           
            ResultSet rs = statement.executeQuery("SELECT * FROM CATALOGDB.ProductImage");
            while (rs.next()) {
                
            	ProductImage pi = new ProductImage();

            	pi.setId(rs.getInt("imageId"));
            	pi.setImagePath(rs.getString("imagePath"));
            	pi.setProductId(rs.getInt("productId"));

                piList.add(pi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}
        return piList;
	}	
}