package com.se2.ebanking.repositories;

import com.se2.ebanking.models.Loan;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.se2.ebanking.Connection.dbConnect;
import com.se2.ebanking.models.Loan;
import org.springframework.stereotype.Repository;

@Repository
public class LoanDAO implements DAO<Loan>{

	private static Connection connection = dbConnect.getConnection();

	public LoanDAO() {

	}


	@Override
	public void insertModel(Loan loan) {
		String query = "INSERT INTO Loan(loan_amount, duration, interest_rate, customer_id, loan_date) VALUES (?,?,?,?,?)";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setFloat(1, loan.getLoan_amount());
			ps.setInt(2, loan.getDuration());
			ps.setFloat(3, loan.getInterest_rate());
			ps.setLong(4, loan.getCustomer_id());
			ps.setDate(5, loan.getLoan_date());
			System.out.println(ps.toString());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteModel(long id) {
		String query = "DELETE FROM Loan WHERE loan_id=?";
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
	public void updateModel(Loan loan) {
		String query = "UPDATE loan SET loan_amount=?, loan_type=?, duration=?, interest_rate=?, customer_id=?" +"WHERE loan_id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setFloat(1, loan.getLoan_amount());
			ps.setString(2, loan.getLoan_type());
			ps.setInt(3, loan.getDuration());
			ps.setFloat(4, loan.getInterest_rate());
			ps.setLong(5, loan.getCustomer_id());
			ps.setLong(6, loan.getLoan_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Loan selectModel(long id) {
		Loan loan = null;
		String query = "SELECT * FROM Loan WHERE customer_id=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setLong(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				float loan_amount = rs.getFloat(2);
				int duration = rs.getInt(4);
				Date loan_date = rs.getDate("loan_date");
				float interest_rate = rs.getFloat(5);
				long customer_id = rs.getLong(6);
				loan = new Loan(loan_amount, duration, interest_rate, customer_id, loan_date);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loan;
	}

	@Override
	public List<Loan> selectAllModels() {
		List<Loan> loan = new ArrayList<>();

		String selectAll = "SELECT * FROM loan";
		try {
			PreparedStatement ps = connection.prepareStatement(selectAll);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				float loan_amount = rs.getFloat(2);
				String loan_type = rs.getString(3);
				int duration = rs.getInt(4);
				float interest_rate = rs.getFloat(5);
				long customer_id = rs.getLong(6);
				loan.add(new Loan(id,loan_amount, loan_type, duration, interest_rate, customer_id));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return loan;
	}
}