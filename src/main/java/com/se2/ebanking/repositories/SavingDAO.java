package com.se2.ebanking.repositories;

import com.se2.ebanking.Connection.dbConnect;
import com.se2.ebanking.models.Loan;
import com.se2.ebanking.models.Saving;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SavingDAO implements DAO<Saving>{

    private static Connection connection = dbConnect.getConnection();

    @Override
    public void insertModel(Saving saving) {
        String query = "INSERT INTO saving(amount, duration, saving_rate, customer_id, open_date) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setFloat(1, saving.getAmount());
            ps.setInt(2, saving.getDuration());
            ps.setFloat(3, saving.getSaving_rate());
            ps.setLong(4, saving.getCustomer_id());
            ps.setDate(5, saving.getOpen_date());
            System.out.println(ps.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void deleteModel(long id) {
        String query = "DELETE FROM saving WHERE customer_id=?";
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
    public void updateModel(Saving saving) {
        String query = "UPDATE saving SET amount=?, duration=?, saving_date=?, customer_id=?" +"WHERE saving=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setFloat(1, saving.getAmount());
            ps.setInt(2, saving.getDuration());
            ps.setFloat(3, saving.getSaving_rate());
            ps.setLong(4, saving.getCustomer_id());
            ps.setLong(5, saving.getSaving_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Saving selectModel(long id) {
        Saving saving = null;
        String query = "SELECT * FROM saving WHERE customer_id=?";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(query);
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                float amount = rs.getFloat("amount");
                int duration = rs.getInt("duration");
                float saving_rate = rs.getFloat("saving_rate");
                Date open_date = rs.getDate("open_date");
                long customer_id = rs.getLong("customer_id");
                saving = new Saving(amount, duration, saving_rate, customer_id, open_date);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return saving;
    }

    @Override
    public List<Saving> selectAllModels() {
        List<Saving> savings = new ArrayList<>();

        String selectAll = "SELECT * FROM saving";
        try {
            PreparedStatement ps = connection.prepareStatement(selectAll);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("saving_id");
                float amount = rs.getFloat("amount");
                int duration = rs.getInt("duration");
                float saving_rate = rs.getFloat("saving_rate");
                long customer_id = rs.getLong("customer_id");
                savings.add(new Saving(id,amount, duration, saving_rate, customer_id));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return savings;
    }
}
