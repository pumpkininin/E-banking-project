package com.se2.ebanking.repositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.se2.ebanking.Connection.dbConnect;
import com.se2.ebanking.models.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO implements DAO<Account>{

	private static Connection connection = dbConnect.getConnection();

	public AccountDAO() {

	}
	@Override
	public List<Account> selectAllModels(){
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
				int is_active = rs.getInt(6);
				acc.add(new Account(id,open_date,balance,type,customer_id, is_active));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return acc;
	}






	@Override
	public void insertModel(Account acc) {
		String query = "INSERT INTO Accounts(open_date, balance, account_type, customer_id, is_active) VALUES (?,?,?,?,?)";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setDate(1, acc.getOpen_date());
			ps.setFloat(2, acc.getBalance());
			ps.setString(3, acc.getAccount_type());
			ps.setLong(4, acc.getCustomer_id());
			ps.setInt(5, acc.getIs_active());
			System.out.println(ps.toString());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteModel(long id) {
		String query = "DELETE FROM accounts WHERE account_id=?";
		boolean deleteAccount = false;

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
	public void updateModel(Account acc) {
		String query = "UPDATE Accounts SET open_date=?, balance=?, account_type=?, customer_id=?, is_active=? " +"    WHERE account_id=?";


		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setDate(1, acc.getOpen_date());
			ps.setFloat(2, acc.getBalance());
			ps.setString(3, acc.getAccount_type());
			ps.setLong(4, acc.getCustomer_id());
			ps.setLong(6, acc.getAccount_id());
			ps.setInt(5, acc.getIs_active());
			System.out.println(ps.toString());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Account selectModel(long id) {
		Account acc = null;
		String query = "SELECT * FROM accounts WHERE customer_id=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setLong(1,id);
			System.out.println(ps.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				long account_id = rs.getLong("account_id");
				Date open_date = rs.getDate("open_date");
				float balance = rs.getFloat("balance");
				String type = rs.getString("account_type");
				int customer_id = rs.getInt("customer_id");
				int is_active = rs.getInt("is_active");
				acc = new Account(account_id,open_date,balance,type,customer_id, is_active);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return acc;
	}
}
