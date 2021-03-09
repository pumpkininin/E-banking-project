package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.dbConnect;
import Models.Account;

public class AccountDAO {
	
	private static Connection connection = dbConnect.getConnection();
	
	public AccountDAO() {
		
	}
	
	public static List<Account> selectAllAccount(){
		List<Account> acc = new ArrayList<>();
		
		String selectAll = "SELECT * FROM accounts";
		try {
			PreparedStatement ps = connection.prepareStatement(selectAll);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				Date open_date = rs.getDate(2);
				float balance = rs.getFloat(3);
				String type = rs.getString(4);
				int customer_id = rs.getInt(5);
				acc.add(new Account(id,open_date,balance,type,customer_id));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return acc;
	}
	
	public static Account selectAccount(int id) {
		Account acc = null;
		String query = "SELECT * FROM accounts WHERE account_id=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Date open_date = rs.getDate(2);
				float balance = rs.getFloat(3);
				String type = rs.getString(4);
				int customer_id = rs.getInt(5);
				acc = new Account(id,open_date,balance,type,customer_id);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return acc;
	}
	
	public static boolean deleteAccount(int id) {
		String query = "DELETE FROM accounts WHERE account_id=?";
		boolean deleteAccount = false;
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		deleteAccount = true;
		return deleteAccount;
	}
	
	public static void insertAccount(Account acc) {
		String query = "INSERT INTO Accounts(open_date, balance, account_type, customer_id) VALUES (?,?,?,?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setDate(1, acc.getOpen_date());
			ps.setFloat(2, acc.getBalance());
			ps.setString(3, acc.getAccount_type());
			ps.setInt(4, acc.getCustomer_id());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static boolean updateAccount(Account acc) {
		String query = "UPDATE Accounts SET open_date=?, balance=?, account_type=?, customer_id=?" +"WHERE account_id=?";
		boolean updateAccount = false;
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setDate(1, acc.getOpen_date());
			ps.setFloat(2, acc.getBalance());
			ps.setString(3, acc.getAccount_type());
			ps.setInt(4, acc.getCustomer_id());
			ps.setInt(5, acc.getAccount_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateAccount = true;
		return updateAccount;
	}
}
