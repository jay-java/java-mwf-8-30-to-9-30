package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
