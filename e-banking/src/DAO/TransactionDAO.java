package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.dbConnect;
import Models.Transaction;

public class TransactionDAO {
	
	private static Connection connection = dbConnect.getConnection();
	
	public TransactionDAO() {
		
	}
	
	public static List<Transaction> selectAllTransaction(){
		List<Transaction> trans = new ArrayList<>();
		
		String selectAll = "SELECT * FROM transactions";
		try {
			PreparedStatement ps = connection.prepareStatement(selectAll);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				Date transaction_date = rs.getDate(2);
				float transaction_amount = rs.getFloat(3);
				String other_details = rs.getString(4);
				String type = rs.getString(5);
				int customer_id = rs.getInt(6);
				int receiver_id = rs.getInt(7);
				trans.add(new Transaction(id,transaction_date,transaction_amount,other_details,type,customer_id,receiver_id));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return trans;
	}
	
	public static Transaction selectTransaction(int id) {
		Transaction trans = null;
		String query = "SELECT * FROM transactions WHERE transaction_id=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Date transaction_date = rs.getDate(2);
				float transaction_amount = rs.getFloat(3);
				String other_details = rs.getString(4);
				String type = rs.getString(5);
				int customer_id = rs.getInt(6);
				int receiver_id = rs.getInt(7);
				trans = new Transaction(id,transaction_date,transaction_amount,other_details,type,customer_id,receiver_id);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trans;
	}
	
	public static boolean deleteTransaction(int id) {
		String query = "DELETE FROM transactions WHERE transaction_id=?";
		boolean deleteTransaction = false;
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		deleteTransaction = true;
		return deleteTransaction;
	}
	
	public static void insertTransaction(Transaction trans) {
		String query = "INSERT INTO Transactions(transaction_date, transaction_amount, other_details, transaction_type, customer_id, receiver_id) VALUES (?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setDate(1, trans.getTransaction_date());
			ps.setFloat(2, trans.getTransaction_amount());
			ps.setString(3, trans.getOther_details());
			ps.setString(4, trans.getTransaction_type());
			ps.setInt(5, trans.getCustomer_id());
			ps.setInt(6, trans.getReceiver_id());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static boolean updateTransaction(Transaction trans) {
		String query = "UPDATE Transactions SET transaction_date=?, transaction_amount=?, other_details=?, transaction_type=?, customer_id=?, receiver_id=?" +"WHERE transaction_id=?";
		boolean updateTransaction = false;
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setDate(1, trans.getTransaction_date());
			ps.setFloat(2, trans.getTransaction_amount());
			ps.setString(3, trans.getOther_details());
			ps.setString(4, trans.getTransaction_type());
			ps.setInt(5, trans.getCustomer_id());
			ps.setInt(6, trans.getReceiver_id());
			ps.setInt(7, trans.getTransaction_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateTransaction = true;
		return updateTransaction;
	}
}