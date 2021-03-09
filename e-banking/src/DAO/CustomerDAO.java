package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.dbConnect;
import Models.Customer;

public class CustomerDAO {
	
	private static Connection connection = dbConnect.getConnection();
	
	public CustomerDAO() {
		
	}
	
	public static List<Customer> selectAllCustomers(){
		List<Customer> cus = new ArrayList<>();
		
		String selectAll = "SELECT * FROM customers";
		try {
			PreparedStatement ps = connection.prepareStatement(selectAll);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				Date dob = rs.getDate(5);
				String address = rs.getString(6);
				Date join_date = rs.getDate(7);
				String login = rs.getString(8);
				String password = rs.getString(9);
				String other_details = rs.getString(10);
				String type = rs.getString(11);
				cus.add(new Customer(id,name,phone,email,dob,address,join_date,login,password,other_details,type));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cus;
	}
	
	public static Customer selectCustomer(int id) {
		Customer cus = null;
		String query = "SELECT * FROM customers WHERE customer_id=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				Date dob = rs.getDate(5);
				String address = rs.getString(6);
				Date join_date = rs.getDate(7);
				String login = rs.getString(8);
				String password = rs.getString(9);
				String other_details = rs.getString(10);
				String type = rs.getString(11);
				cus = new Customer(id,name,phone,email,dob,address,join_date,login,password,other_details,type);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cus;
	}
	
	public static boolean deleteCustomer(int id) {
		String query = "DELETE FROM Customers WHERE customer_id=?";
		boolean deleteCustomer = false;
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		deleteCustomer = true;
		return deleteCustomer;
	}
	
	public static void insertCustomer(Customer cus) {
		String query = "INSERT INTO Customers(customer_name,customer_phone,customer_email,customer_dob,customer_address,"
				+"join_date,login,password,other_details,customer_types"+") VALUES (?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, cus.getCustomer_name());
			ps.setString(2, cus.getCustomer_phone());
			ps.setString(3, cus.getCustomer_email());
			ps.setDate(4, cus.getCustomer_dob());
			ps.setString(5, cus.getCustomer_address());
			ps.setDate(6, cus.getJoin_date());
			ps.setString(7, cus.getLogin());
			ps.setString(8, cus.getPassword());
			ps.setString(9, cus.getOther_details());
			ps.setString(10, cus.getCustomer_type());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static boolean updateCustomer(Customer cus) {
		String query = "UPDATE Customers SET customer_name=?, customer_phone=?, customer_email=?, customer_dob=?, customer_address=?, " 
				+ "join_date=?, login=?, password=?, other_details=?, customer_type=?" +"WHERE customer_id=?";
		boolean updateCustomer = false;
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, cus.getCustomer_name());
			ps.setString(2, cus.getCustomer_phone());
			ps.setString(3, cus.getCustomer_email());
			ps.setDate(4, cus.getCustomer_dob());
			ps.setString(5, cus.getCustomer_address());
			ps.setDate(6, cus.getJoin_date());
			ps.setString(7, cus.getLogin());
			ps.setString(8, cus.getPassword());
			ps.setString(9, cus.getOther_details());
			ps.setString(10, cus.getCustomer_type());
			ps.setInt(11, cus.getCustomer_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateCustomer = true;
		return updateCustomer;
	}
}
