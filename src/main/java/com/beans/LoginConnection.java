package com.beans;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
public class LoginConnection {
	private Connection connection ;
	
	public LoginConnection() {
		// TODO Auto-generated constructor stub
		
	}
	public List<User> arrangeUsers() {
		List<User> users= new ArrayList<User>();
		 Statement statement=null;
		 ResultSet resultSet=null;
		 loadDatabase();
		 try {
			 statement=(Statement)connection.createStatement();
			 resultSet=(ResultSet) statement.executeQuery("SELECT nom,prenom FROM noms;");
			 while(resultSet.next()) {
				 
				 String nom=resultSet.getString("nom");
				 String prenom=resultSet.getString("prenom");
				 String email=resultSet.getString("emial");
				 String pwd=resultSet.getString("pwd");
				 User user=new User();
				 user.setName(nom);
				 user.setPwd(prenom);
				 user.setEmail(email);
				 user.setPwd(pwd);
				 users.add(user);
				 
			 }
			 
		 }catch(SQLException e){
			 	 
		 }finally {
			 // Fermeture de la connexion
	            try {
	                if (resultSet!= null)
	                    resultSet.close();
	                if (statement != null)
	                    statement.close();
	                if (connection != null)
	                    connection.close();
	            }catch (SQLException ignore){
				} 
			}
		
		 return users;
	}
	
	
	public void insUser(User user) {
	
		 loadDatabase();
		 
		 try {
			 
			 PreparedStatement preparedStatement=(PreparedStatement)
			 connection.prepareStatement("INSERT INTO users(nom, prenom,email,pwd) VALUES(?, ?,?,?);");
			 preparedStatement.setString(1,user.getLasteName());
			 preparedStatement.setString(2, user.getName());
			 preparedStatement.setString(3, user.getEmail());
			 preparedStatement.setString(4, user.getPwd());
			 preparedStatement.executeUpdate();
		 }catch(SQLException e) {
			 
			 System.out.print(e.getMessage());
			 
		 }
		
	}
	
	public void loadDatabase() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		}catch(ClassNotFoundException exception) {
			System.out.print("class Note found");
			
		}
		try {
			connection=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/javaee","root","");
			
		}catch(SQLException e) {
			 e.printStackTrace();
			
		}
		
	
		
	}
	
	

}
