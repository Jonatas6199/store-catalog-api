package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
    	if (connection != null) {
    		return connection;
    	}
        try {
            connection = null;  
            String driverName = "com.mysql.jdbc.Driver";                        
            Class.forName(driverName);
            String serverName = "127.0.0.1:3306";
            //String serverName = "keys.mobilemed.com.br:3377";
            String mydatabase ="CATALOGDB";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "root";
            String password = "teRMo2020+ec7";
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
            return null;
        } catch (Exception e) {
        	e.printStackTrace();
        	return null;
        }
    }
    
    /*
    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
            	Properties prop = new Properties();
                InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("/db.resources");
                String driver, url, user, password;              
				prop.load(inputStream);  
				driver = prop.getProperty("driver");
	            url = prop.getProperty("url");
	            user = prop.getProperty("user");
	            password = prop.getProperty("password");
				System.out.println(driver + " - " + url + " - " + new Date());
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
                System.out.println(connection);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            return connection;
        }
    } */
}