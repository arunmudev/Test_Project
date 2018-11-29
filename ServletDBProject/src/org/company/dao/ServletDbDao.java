package org.company.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.*;

import org.company.model.ServletDbModel;
public class ServletDbDao {

	private String url;
	private String user;
	private String password;
	private Connection connection;
	
	public ServletDbDao(String url,String user,String password){
		this.url = url;
	     this.user = user;
	     this.password = password;
	}
	
	protected void connect()throws SQLException {
		if(connection == null || connection.isClosed()) {
			//open connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e) {
			throw new SQLException(e);
		}

		String urll = "jdbc:mysql://localhost:3306/booksdb";
		String userr = "root";
		String passwordd ="sqltest@123";
		connection = DriverManager.getConnection(urll, userr, passwordd);
		}
	}
	
	
	public ServletDbDao() {
		// TODO Auto-generated constructor stub
	}
	public void ServletDbDaos(ServletDbModel model)throws SQLException {
		connect();
	 	
		PreparedStatement statement = null;
		try {
			String sql = "INSERT INTO bookstore(title,author,price) VALUES(?,?,?);";
			//Execute statement 		      
			statement = connection.prepareStatement(sql);
			statement.setString(1, model.getTitle());
			statement.setString(2, model.getAuthor());
			statement.setString(3, model.getPrice());
			statement.executeUpdate();
		}catch (SQLException e) {

		}finally {
			try {
				if(connection!=null) {
					connection.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			try {
				if(statement!=null) {
					statement.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}

	}
	
}
