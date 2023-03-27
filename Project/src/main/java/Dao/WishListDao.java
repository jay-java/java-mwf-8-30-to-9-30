package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.WishList;
import connection.DBConnection;

public class WishListDao {
	public static void insertWIshList(WishList w) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql= "insert into wishlist(pid,cusid) values(?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, w.getPid());
			pst.setInt(2, w.getCusid());
			pst.executeUpdate();
			System.out.println(".....");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<WishList> getWishListByCusId(int id){
		List<WishList> list = new ArrayList<WishList>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql= "select * from wishlist where cusid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				WishList w = new WishList();
				w.setWid(rs.getInt("wid"));
				w.setPid(rs.getInt("pid"));
				w.setCusid(rs.getInt("cusid"));
				list.add(w);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void removeFromWishlist(int wid) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql= "delete from wishlist where wid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, wid);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean cheProductExist(int cusid,int pid) {
		boolean flag = false;
		try {
			Connection conn = DBConnection.createConnection();
			String sql= "select * from wishlist where cusid=? and pid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, cusid);
			pst.setInt(2, pid);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
