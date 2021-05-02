package com.se2.ebanking.repositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.se2.ebanking.Connection.dbConnect;
import com.se2.ebanking.models.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO implements DAO<Customer>{

	private static Connection connection = dbConnect.getConnection();

	public CustomerDAO() {

	}



	public Customer findCustomerByPhone(String phoneNumber) {
		String query = "SELECT * FROM customers WHERE customer_phone=?";

		try{
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, phoneNumber);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				long id = rs.getLong("customer_id");
				String firstName = rs.getString("customer_firstname");
				String lastName = rs.getString("customer_lastname");
				String phone = rs.getString("customer_phone");
				String email = rs.getString("customer_email");
				Date dob = rs.getDate("customer_dob");
				String address = rs.getString("customer_address");
				Date join_date = rs.getDate("join_date");
				String login = rs.getString("login");
				String password = rs.getString("password");
				String other_details = rs.getString("other_details");
				String type = rs.getString("customer_type");
				Customer cus = new Customer(id,firstName, lastName,phone,email,dob,address,join_date,login,password,other_details,type);

				return cus;
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return null;
	}



	@Override
	public void insertModel(Customer cus) {
		String query = "INSERT INTO Customers(customer_firstname,customer_lastname,customer_phone,customer_email,customer_dob,customer_address,"
				+"join_date,login,password"+") VALUES (?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, cus.getCustomer_firstName());
			ps.setString(2, cus.getCustomer_lastName());
			ps.setString(3, cus.getCustomer_phone());
			ps.setString(4, cus.getCustomer_email());
			ps.setDate(5, cus.getCustomer_dob());
			ps.setString(6, cus.getCustomer_address());
			ps.setDate(7, cus.getJoin_date());
			ps.setString(8, cus.getLogin());
			ps.setString(9, cus.getPassword());

			System.out.println(ps.toString());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteModel(long id) {
		String query = "DELETE FROM Customers WHERE customer_id=?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, id);

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateModel(Customer cus) {
		String query = "UPDATE customers SET customer_firstname = ?, customer_lastName=?, customer_phone=?," +
				"customer_email =?, customer_address=?, customer_dob=? WHERE customer_id=?";
		try{
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, cus.getCustomer_firstName());
			pst.setString(2, cus.getCustomer_lastName());
			pst.setString(3, cus.getCustomer_phone());
			pst.setString(4, cus.getCustomer_email());
			pst.setString(5, cus.getCustomer_address());
			pst.setDate(6, cus.getCustomer_dob());
			pst.setLong(7, cus.getCustomer_id());
			System.out.println(pst.toString());
			pst.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	@Override
	public Customer selectModel(long id) {
		Customer cus = null;
		String query = "SELECT * FROM customers WHERE customer_id=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setLong(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String firstName = rs.getString("customer_firstname");
				String lastName = rs.getString("customer_lastName");
				String phone = rs.getString("customer_phone");
				String email = rs.getString("customer_email");
				Date dob = rs.getDate("customer_dob");
				String address = rs.getString("customer_address");
				Date join_date = rs.getDate("join_date");
				String login = rs.getString("login");
				String password = rs.getString("password");
				String other_details = rs.getString("other_details");
				String type = rs.getString("customer_type");
				cus = new Customer(id,firstName, lastName,phone,email,dob,address,join_date,login,password,other_details,type);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cus;
	}

	@Override
	public List<Customer> selectAllModels() {
		List<Customer> cus = new ArrayList<>();

		String selectAll = "SELECT * FROM customers";
		try {
			PreparedStatement ps = connection.prepareStatement(selectAll);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String firstName = rs.getString("customer_firstname");
				String lastName = rs.getString("customer_lastName");
				String phone = rs.getString("customer_phone");
				String email = rs.getString("customer_email");
				Date dob = rs.getDate("customer_dob");
				String address = rs.getString("customer_address");
				Date join_date = rs.getDate("join_date");
				String login = rs.getString("login");
				String password = rs.getString("password");
				String other_details = rs.getString("other_details");
				String type = rs.getString("customer_type");
				cus.add(new Customer(id,firstName, lastName,phone,email,dob,address,join_date,login,password,other_details,type));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cus;
	}
}