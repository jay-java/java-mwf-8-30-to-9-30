package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.print.attribute.UnmodifiableSetException;

import connectivity.DBConnection;
import model.User;

public class UserDao {
	public static void insertUser(User u) {
		try {

			Connection connection = DBConnection.createConnection();
			String sqlString = "insert into user(name,contact,address,email,password) values(?,?,?,?,?)";
			PreparedStatement pst= connection.prepareStatement(sqlString);
			pst.setString(1, u.getName());
			pst.setLong(2, u.getContact());
			pst.setString(3, u.getAddress());
			pst.setString(4, u.getEmail());
			pst.setString(5, u.getPasswordString());
			pst.executeUpdate();
			System.out.println("data inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean checkEmail(String email) {
		boolean flag = false;
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString = "select * from user where email=?";
			PreparedStatement pst= connection.prepareStatement(sqlString);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public static User userLogin(User u) {
		User user = null;
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString = "select * from user where email=? and password=?";
			PreparedStatement pst= connection.prepareStatement(sqlString);
			pst.setString(1, u.getEmail());
			pst.setString(2, u.getPasswordString());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setContact(rs.getLong("contact"));
				user.setAddress(rs.getString("address"));
				user.setEmail(rs.getString("email"));
				user.setPasswordString(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
