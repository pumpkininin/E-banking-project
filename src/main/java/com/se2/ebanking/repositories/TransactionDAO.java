package com.se2.ebanking.repositories;

import com.se2.ebanking.Connection.dbConnect;
import com.se2.ebanking.models.Transaction;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionDAO implements DAO<Transaction>{

	private static Connection connection = dbConnect.getConnection();

	public TransactionDAO() {

	}



	@Override
	public void insertModel(Transaction trans) {
		String query = "INSERT INTO Transactions(transaction_date, transaction_amount, customer_id, receiver_id, transaction_fee) VALUES (?,?,?,?,?)";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setDate(1, trans.getTransaction_date());
			ps.setFloat(2, trans.getTransaction_amount());
			ps.setLong(3, trans.getCustomer_id());
			ps.setLong(4, trans.getReceiver_id());
			ps.setFloat(5, trans.getTransaction_fee());
			System.out.println(ps.toString());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteModel(long id) {
		String query = "DELETE FROM transactions WHERE transaction_id=?";

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
	public void updateModel(Transaction trans) {
		String query = "UPDATE Transactions SET transaction_date=?, transaction_amount=?, other_details=?, transaction_type=?, customer_id=?, receiver_id=?" +"WHERE transaction_id=?";


		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setDate(1, trans.getTransaction_date());
			ps.setFloat(2, trans.getTransaction_amount());
			ps.setString(3, trans.getOther_details());
			ps.setString(4, trans.getTransaction_type());
			ps.setLong(5, trans.getCustomer_id());
			ps.setLong(6, trans.getReceiver_id());
			ps.setLong(7, trans.getTransaction_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Transaction selectModel(long id) {
		Transaction trans = null;
		String query = "SELECT * FROM transactions WHERE transaction_id=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setLong(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Date transaction_date = rs.getDate("transaction_date");
				float transaction_amount = rs.getFloat("transaction_amount");
				float transaction_fee = rs.getFloat("transaction_fee");
				long customer_id = rs.getInt("customer_id");
				long receiver_id = rs.getInt("receiver_id");
				trans = new Transaction(id,transaction_date,transaction_amount,customer_id,receiver_id, transaction_fee);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trans;
	}

	@Override
	public List<Transaction> selectAllModels() {
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
				float fee = rs.getFloat(8);
				trans.add(new Transaction(id,transaction_date,transaction_amount,other_details,type,customer_id,receiver_id, fee));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return trans;
	}
}