package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.dbConnect;
import Models.Merchant;

public class MerchantDAO {
	
	private static Connection connection = dbConnect.getConnection();
	
	public MerchantDAO() {
		
	}
	
	public static List<Merchant> selectAllMerchant(){
		List<Merchant> mer = new ArrayList<>();
		
		String selectAll = "SELECT * FROM Merchants";
		try {
			PreparedStatement ps = connection.prepareStatement(selectAll);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String merchant_name = rs.getString(2);
				String merchant_phone = rs.getString(3);
				String merchant_email = rs.getString(4);
				String other_details = rs.getString(5);
				mer.add(new Merchant(id,merchant_name, merchant_phone, merchant_email, other_details));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mer;
	}
	
	public static Merchant selectMerchant(int id) {
		Merchant mer = null;
		String query = "SELECT * FROM Merchants WHERE merchant_id=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String merchant_name = rs.getString(2);
				String merchant_phone = rs.getString(3);
				String merchant_email = rs.getString(4);
				String other_details = rs.getString(5);
				mer = new Merchant(id,merchant_name, merchant_phone, merchant_email, other_details);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mer;
	}
	
	public static boolean deleteMerchant(int id) {
		String query = "DELETE FROM Merchants WHERE merchant_id=?";
		boolean deleteMerchant = false;
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		deleteMerchant = true;
		return deleteMerchant;
	}
	
	public static void insertMerchant(Merchant mer) {
		String query = "INSERT INTO Merchants(merchant_name, merchant_phone, merchant_email, other_details) VALUES (?,?,?,?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, mer.getMerchant_name());
			ps.setString(2, mer.getMerchant_phone());
			ps.setString(3, mer.getMerchant_email());
			ps.setString(4, mer.getOther_details());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static boolean updateMerchant(Merchant mer) {
		String query = "UPDATE Merchants SET merchant_name=?, merchant_phone=?, merchant_email=?, other_details=?" +"WHERE merchant_id=?";
		boolean updateMerchant = false;
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, mer.getMerchant_name());
			ps.setString(2, mer.getMerchant_phone());
			ps.setString(3, mer.getMerchant_email());
			ps.setString(4, mer.getOther_details());
			ps.setInt(5, mer.getMerchant_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateMerchant = true;
		return updateMerchant;
	}
}
