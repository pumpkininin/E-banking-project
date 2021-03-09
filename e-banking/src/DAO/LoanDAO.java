package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.dbConnect;
import Models.Loan;

public class LoanDAO {
	
	private static Connection connection = dbConnect.getConnection();
	
	public LoanDAO() {
		
	}
	
	public static List<Loan> selectAllLoan(){
		List<Loan> loan = new ArrayList<>();
		
		String selectAll = "SELECT * FROM loan";
		try {
			PreparedStatement ps = connection.prepareStatement(selectAll);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				float loan_amount = rs.getFloat(2);
				String loan_type = rs.getString(3);
				Date duration = rs.getDate(4);
				float interest_rate = rs.getFloat(5);
				int customer_id = rs.getInt(6);
				loan.add(new Loan(id,loan_amount, loan_type, duration, interest_rate, customer_id));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return loan;
	}
	
	public static Loan selectLoan(int id) {
		Loan loan = null;
		String query = "SELECT * FROM Loan WHERE loan_id=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				float loan_amount = rs.getFloat(2);
				String loan_type = rs.getString(3);
				Date duration = rs.getDate(4);
				float interest_rate = rs.getFloat(5);
				int customer_id = rs.getInt(6);
				loan = new Loan(id,loan_amount, loan_type, duration, interest_rate, customer_id);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loan;
	}
	
	public static boolean deleteLoan(int id) {
		String query = "DELETE FROM Loan WHERE loan_id=?";
		boolean deleteLoan = false;
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		deleteLoan = true;
		return deleteLoan;
	}
	
	public static void insertLoan(Loan loan) {
		String query = "INSERT INTO Loan(loan_amount, loan_type, duration, interest_rate, customer_id) VALUES (?,?,?,?,?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setFloat(1, loan.getLoan_amount());
			ps.setString(2, loan.getLoan_type());
			ps.setDate(3, loan.getDuration());
			ps.setFloat(4, loan.getInterest_rate());
			ps.setInt(5, loan.getCustomer_id());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static boolean updateLoan(Loan loan) {
		String query = "UPDATE Loan SET loan_amount=?, loan_type=?, duration=?, interest_rate=?, customer_id=?" +"WHERE loan_id=?";
		boolean updateLoan = false;
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setFloat(1, loan.getLoan_amount());
			ps.setString(2, loan.getLoan_type());
			ps.setDate(3, loan.getDuration());
			ps.setFloat(4, loan.getInterest_rate());
			ps.setInt(5, loan.getCustomer_id());
			ps.setInt(6, loan.getLoan_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateLoan = true;
		return updateLoan;
	}
}