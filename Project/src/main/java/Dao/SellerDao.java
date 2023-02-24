package Dao;

import java.security.spec.RSAKeyGenParameterSpec;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.tomcat.dbcp.dbcp2.PStmtKey;

import Model.Seller;
import connection.DBConnection;

public class SellerDao {
	public static void insertSeller(Seller s) {
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString="insert into seller(name,contact,address,email,password) values(?,?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setString(1, s.getName());
			pst.setLong(2, s.getContact());
			pst.setString(3, s.getAddress());
			pst.setString(4, s.getEmail());
			pst.setString(5, s.getPassword());
			pst.executeUpdate();
			System.out.println("data inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Seller loginSeller(Seller s) {
		Seller s1 = null;
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString="select * from seller where email=? and password=?";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setString(1, s.getEmail());
			pst.setString(2, s.getPassword());
			ResultSet rSet = pst.executeQuery();
			if(rSet.next()) {
				s1 = new Seller();
				s1.setId(rSet.getInt("id"));
				s1.setName(rSet.getString("name"));
				s1.setContact(rSet.getLong("contact"));
				s1.setAddress(rSet.getString("address"));
				s1.setEmail(rSet.getString("email"));
				s1.setPassword(rSet.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s1;
	}
	public static void updateProfile(Seller s) {
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString="update seller set name=?,contact=?,address=?,email=? where id=?";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setString(1, s.getName());
			pst.setLong(2, s.getContact());
			pst.setString(3, s.getAddress());
			pst.setString(4, s.getEmail());
			pst.setInt(5, s.getId());
			pst.executeUpdate();
			System.out.println("data updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean checkOldPassword(int id,String op) {
		boolean flag = false;
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString="select * from seller where id=? and password=?";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setInt(1, id);
			pst.setString(2, op);
			ResultSet rSet = pst.executeQuery();
			if(rSet.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public static void changePasswrod(int id,String np) {
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString="update seller set password=? where id=?";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setString(1, np);
			pst.setInt(2, id);
			pst.executeUpdate();
			System.out.println("password changed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
