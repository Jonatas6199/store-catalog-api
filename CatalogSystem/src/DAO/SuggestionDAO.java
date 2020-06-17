package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import VO.Suggestion;
import DAO.DAOInterface;

public class SuggestionDAO implements DAOInterface<Suggestion> {
	private Connection connection;
	
	public SuggestionDAO() {
		try {
			this.connection = DbUtil.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Suggestion suggestion) {
		try {
            PreparedStatement preparedStatement = connection
            		.prepareStatement("INSERT INTO CatalogDB.Suggestion (suggestionDescription, userId) VALUES (?, ?)");
            preparedStatement.setString(1, suggestion.getSuggestionDescription());
            preparedStatement.setInt(2, suggestion.getUserId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
        	e.printStackTrace();
        }
	}

	@Override
	public void update(Suggestion suggestion) {
		
		try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE CATALOGDB.Suggestion SET suggestionDescription = ?, userId = ? "
                    				+ "WHERE suggestionId = ?");
            preparedStatement.setString(1, suggestion.getSuggestionDescription());
            preparedStatement.setInt(2, suggestion.getUserId());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void delete(Suggestion suggestion) {
		try {
        	PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM CATALOGDB.Suggestion WHERE suggestionId = ?");
            preparedStatement.setInt(1, suggestion.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	e.printStackTrace();
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}

	@Override
	public Suggestion find(Suggestion suggestion) {
		
		Suggestion s = new Suggestion();
        
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * FROM CATALOGDB.Suggestion WHERE suggestionId = ?");
            
            preparedStatement.setLong(1, suggestion.getId());
            ResultSet rs = preparedStatement.executeQuery();
           
            if (rs.next()) {
            	s.setId(rs.getInt("suggestionId"));
            	s.setSuggestionDescription(rs.getString("suggestionDescription"));
            	s.setUserId(rs.getInt("userId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}

        return s;	
	}

	@Override
	public ArrayList<Suggestion> findAll(Suggestion suggestion) {
		ArrayList<Suggestion> sList = new ArrayList<Suggestion>(); 
        try {     	
            Statement statement = connection.createStatement();           
            ResultSet rs = statement.executeQuery("SELECT * FROM CATALOGDB.Suggestion");
            while (rs.next()) {
                
            	Suggestion s = new Suggestion();
                
            	s.setId(rs.getInt("suggestionId"));
            	s.setSuggestionDescription(rs.getString("suggestionDescription"));
            	s.setUserId(rs.getInt("userId"));

                sList.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}
        return sList;
	}	
}