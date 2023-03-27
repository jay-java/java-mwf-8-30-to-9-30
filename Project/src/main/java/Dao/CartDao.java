package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Model.Cart;
import connection.DBConnection;

public class CartDao {
	public static void insertCat(Cart c) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql="insert into cart(cusid,pid,pname,pprice,pqty,payment_status) values(?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, c.getCusid());
			pst.setInt(2, c.getPid());
			pst.setString(3, c.getPname());
			pst.setInt(4, c.getPprice());
			pst.setInt(5, c.getPqty());
			pst.setString(6, c.getPayment_status());
			pst.executeUpdate();
			System.out.println("added");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
