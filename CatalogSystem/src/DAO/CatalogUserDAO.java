package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import VO.CatalogUser;
import DAO.DAOInterface;

public class CatalogUserDAO implements DAOInterface<CatalogUser> {
	private Connection connection;
	
	public CatalogUserDAO() {
		try {
			this.connection = DbUtil.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(CatalogUser catalogUser) {
		try {
            PreparedStatement preparedStatement = connection
            		.prepareStatement("INSERT INTO CATALOGDB.CatalogUser (userEmail, userPassword, userName, isAdmin) "
            				+ "VALUES (?, ?, ?, ?)");

            preparedStatement.setString(1, catalogUser.getUserEmail());
            preparedStatement.setString(2, catalogUser.getUserPassword());
            preparedStatement.setString(3, catalogUser.getuserName());
            preparedStatement.setInt(4, catalogUser.getIsAdmin());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
        	e.printStackTrace();
        }
	}

	@Override
	public void update(CatalogUser catalogUser) {
		
		try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE CATALOGDB.CatalogUser SET userEmail = ?, userPassword = ?, userName = ?,"
                    		+ " isAdmin = ? WHERE userId = ?");
            preparedStatement.setString(1, catalogUser.getUserEmail());
            preparedStatement.setString(2, catalogUser.getUserPassword());
            preparedStatement.setString(3, catalogUser.getuserName());
            preparedStatement.setInt(4, catalogUser.getIsAdmin());
            preparedStatement.setInt(5, catalogUser.getId());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void delete(CatalogUser catalogUser) {
		try {
        	PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM CATALOGDB.CatalogUser WHERE userId=?");
            preparedStatement.setInt(1, catalogUser.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	e.printStackTrace();
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}

	@Override
	public CatalogUser find(CatalogUser catalogUser) {
		
		CatalogUser cu = new CatalogUser();
        
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * FROM CATALOGDB.CatalogUser WHERE userId=?");
            
            preparedStatement.setLong(1, catalogUser.getId());
            ResultSet rs = preparedStatement.executeQuery();
           
            if (rs.next()) {
            	cu.setId(rs.getInt("userId"));
            	cu.setUserEmail(rs.getString("userEmail"));
            	cu.setUserPassword(rs.getString("userPassword"));
            	cu.setUserName(rs.getString("userName"));
            	cu.setIsAdmin(rs.getInt("isAdmin"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}

        return cu;	
	}

	@Override
	public ArrayList<CatalogUser> findAll() {
		ArrayList<CatalogUser> cuList = new ArrayList<CatalogUser>(); 
        try {     	
            Statement statement = connection.createStatement();           
            ResultSet rs = statement.executeQuery("SELECT * FROM CATALOGDB.CatalogUser");
            while (rs.next()) {
                
            	CatalogUser cu = new CatalogUser();

            	cu.setId(rs.getInt("userId"));
            	cu.setUserEmail(rs.getString("userEmail"));
            	cu.setUserPassword(rs.getString("userPassword"));
            	cu.setUserName(rs.getString("userName"));
            	cu.setIsAdmin(rs.getInt("isAdmin"));

                cuList.add(cu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}
        return cuList;
	}	
	
	public CatalogUser findByUserAndPassword(CatalogUser catalogUser) {
		
		CatalogUser cu = new CatalogUser();
        
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * FROM CATALOGDB.CatalogUser WHERE userEmail = ? AND userPassword = ?");
            
            preparedStatement.setString(1, catalogUser.getUserEmail());
            preparedStatement.setString(2, catalogUser.getUserPassword());
            ResultSet rs = preparedStatement.executeQuery();
            
            if (rs.next()) {
            	cu.setId(rs.getInt("userId"));
            	cu.setUserEmail(rs.getString("userEmail"));
            	cu.setUserPassword(rs.getString("userPassword"));
            	cu.setUserName(rs.getString("userName"));
            	cu.setIsAdmin(rs.getInt("isAdmin"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}

        return cu;	
	}
}