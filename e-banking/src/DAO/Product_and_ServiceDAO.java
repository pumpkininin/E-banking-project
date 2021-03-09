package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.dbConnect;
import Models.Product_and_Service;

public class Product_and_ServiceDAO {
	
	private static Connection connection = dbConnect.getConnection();
	
	public Product_and_ServiceDAO() {
		
	}
	
	public static List<Product_and_Service> selectAllProduct_and_Service(){
		List<Product_and_Service> pas = new ArrayList<>();
		
		String selectAll = "SELECT * FROM Products_and_Services";
		try {
			PreparedStatement ps = connection.prepareStatement(selectAll);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String pas_description = rs.getString(2);
				int merchant_id = rs.getInt(3);
				pas.add(new Product_and_Service(id,pas_description, merchant_id));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pas;
	}
	
	public static Product_and_Service selectProduct_and_Service(int id) {
		Product_and_Service pas = null;
		String query = "SELECT * FROM Products_and_Services WHERE pas_id=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String pas_description = rs.getString(2);
				int merchant_id = rs.getInt(3);
				pas = new Product_and_Service(id,pas_description, merchant_id);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pas;
	}
	
	public static boolean deleteProduct_and_Service(int id) {
		String query = "DELETE FROM Products_and_Services WHERE pas_id=?";
		boolean deletePas = false;
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		deletePas = true;
		return deletePas;
	}
	
	public static void insertProduct_and_Service(Product_and_Service pas) {
		String query = "INSERT INTO Products_and_Services(pas_description, merchant_id) VALUES (?,?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, pas.getPas_description());
			ps.setInt(2, pas.getMerchant_id());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static boolean updateProduct_and_Service(Product_and_Service pas) {
		String query = "UPDATE Products_and_Services SET pas_description=?, merchant_id=?" +"WHERE pas_id=?";
		boolean updatePas = false;
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, pas.getPas_description());
			ps.setInt(2, pas.getMerchant_id());
			ps.setInt(3, pas.getPas_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updatePas = true;
		return updatePas;
	}
}

