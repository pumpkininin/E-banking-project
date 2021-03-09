package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.dbConnect;
import Models.Customer_Purchase;

public class Customer_PurchaseDAO {
	
	private static Connection connection = dbConnect.getConnection();
	
	public Customer_PurchaseDAO() {
		
	}
	
	public static List<Customer_Purchase> selectAllCustomer_Purchase(){
		List<Customer_Purchase> cp = new ArrayList<>();
		
		String selectAll = "SELECT * FROM Customer_Purchase";
		try {
			PreparedStatement ps = connection.prepareStatement(selectAll);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				Date purchase_date = rs.getDate(2);
				float purchase_quantity = rs.getFloat(3);
				String other_details = rs.getString(4);
				int customer_id = rs.getInt(5);
				int pas_id = rs.getInt(6);
				cp.add(new Customer_Purchase(id,purchase_date,purchase_quantity,other_details,customer_id,pas_id));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cp;
	}
	
	public static Customer_Purchase selectCustomer_Purchase(int id) {
		Customer_Purchase cp = null;
		String query = "SELECT * FROM Customer_Purchase WHERE purchase_id=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Date purchase_date = rs.getDate(2);
				float purchase_quantity = rs.getFloat(3);
				String other_details = rs.getString(4);
				int customer_id = rs.getInt(5);
				int pas_id = rs.getInt(6);
				cp = new Customer_Purchase(id,purchase_date,purchase_quantity,other_details,customer_id,pas_id);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cp;
	}
	
	public static boolean deleteCustomer_Purchase(int id) {
		String query = "DELETE FROM Customer_Purchase WHERE purchase_id=?";
		boolean deleteCp = false;
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		deleteCp = true;
		return deleteCp;
	}
	
	public static void insertCustomer_Purchase(Customer_Purchase cp) {
		String query = "INSERT INTO Customer_Purchase(purchase_date,purchase_quantity,other_details,customer_id,pas_id) VALUES (?,?,?,?,?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setDate(1, cp.getPurchase_date());
			ps.setFloat(2, cp.getPurchase_quantity());
			ps.setString(3, cp.getOther_details());
			ps.setInt(4, cp.getCustomer_id());
			ps.setInt(5, cp.getPas_id());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static boolean updateCustomer_Purchase(Customer_Purchase cp) {
		String query = "UPDATE Customer_Purchase SET purchase_date=?,purchase_quantity=?,other_details=?,customer_id=?,pas_id=?" +"WHERE purchase_id=?";
		boolean updateCp = false;
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setDate(1, cp.getPurchase_date());
			ps.setFloat(2, cp.getPurchase_quantity());
			ps.setString(3, cp.getOther_details());
			ps.setInt(4, cp.getCustomer_id());
			ps.setInt(5, cp.getPas_id());
			ps.setInt(6, cp.getPurchase_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateCp = true;
		return updateCp;
	}
}