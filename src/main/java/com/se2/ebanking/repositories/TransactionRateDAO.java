package com.se2.ebanking.repositories;

import com.se2.ebanking.Connection.dbConnect;
import com.se2.ebanking.models.TransactionRate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionRateDAO implements DAO<TransactionRate> {
    private Connection connection;

    public TransactionRateDAO(){
        this.connection = dbConnect.getConnection();
    }

    public List<Float> selectAllTransactionRate(){
        String query = "SELECT * FROM transaction_rate WHERE rate_id = 1";
        List<Float> settings = new ArrayList<>();
        try{
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                settings.add(rs.getFloat("saving_rate"));
                settings.add(rs.getFloat("loan_rate"));
                settings.add(rs.getFloat("transfer_fee"));
            }
            pst.close();
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return settings;
    }

    @Override
    public void insertModel(TransactionRate transactionRate) {

    }

    @Override
    public void deleteModel(long id) {

    }

    @Override
    public void updateModel(TransactionRate transactionRate) {
        String query = "UPDATE transaction_rate SET loan_rate=?, saving_rate=?, transfer_fee=? WHERE rate_id=1";

        try{
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setFloat(1, transactionRate.getLoan_rate());
            pst.setFloat(2, transactionRate.getSaving_rate());
            pst.setFloat(3, transactionRate.getFee());
            System.out.println(pst.toString());

            pst.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public TransactionRate selectModel(long id) {
        return null;
    }

    @Override
    public List<TransactionRate> selectAllModels() {
        return null;
    }
}
