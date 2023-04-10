package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Model.Seller;
import connection.DBConnection;

public class SellerDao {
	public static Seller checkContactAndEmail(long contact,String email) {
		System.out.println(contact+email+" in dao");
		Seller s = null;
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString="select * from seller where contact=? and email=?";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setLong(1, contact);
			pst.setString(2, email);
			ResultSet rs= pst.executeQuery();
			if(rs.next()) {
				s = new Seller();
				s.setId(rs.getInt("id"));
				System.out.println("id = "+rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setContact(rs.getLong("contact"));
				s.setAddress(rs.getString("address"));
				s.setEmail(rs.getString("email"));
				s.setPassword(rs.getString("password"));
				System.out.println("got data "+s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
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
	public static Seller getSellerById(int id) {
		Seller s1 = null;
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString="select * from seller where id=?";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setInt(1, id);
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
	public static boolean checkEmail(String email) {
		boolean flag = false;
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString="select * from seller where email=?";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setString(1, email);
			ResultSet rs  = pst.executeQuery();
			if(rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public static void changeNewPasswrod(String email,String np) {
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString="update seller set password=? where email=?";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setString(1, np);
			pst.setString(2, email);
			pst.executeUpdate();
			System.out.println("password changed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<Seller> getAllSellers(){
		List<Seller> list = new ArrayList<Seller>();
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString="select * from seller";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			ResultSet rSet = pst.executeQuery();
			while(rSet.next()) {
				Seller s1 = new Seller();
				s1.setId(rSet.getInt("id"));
				s1.setName(rSet.getString("name"));
				s1.setContact(rSet.getLong("contact"));
				s1.setAddress(rSet.getString("address"));
				s1.setEmail(rSet.getString("email"));
				s1.setPassword(rSet.getString("password"));
				list.add(s1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void deleteSeller(int id){
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString="delete from seller where id=?";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setInt(1, id);
			pst.executeUpdate();
			System.out.println("data deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
