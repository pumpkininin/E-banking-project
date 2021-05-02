package com.se2.ebanking.repositories;

import com.se2.ebanking.Connection.dbConnect;
import com.se2.ebanking.models.Settings;
import org.springframework.session.ReactiveMapSessionRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SettingDAO implements DAO<Settings> {
    private Connection connection;

    public SettingDAO(){
        this.connection = dbConnect.getConnection();
    }

    public List<Float> selectAllSetting(){
        String query = "SELECT * FROM admin_settings WHERE setting_id = 1";
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
    public void insertModel(Settings settings) {

    }

    @Override
    public void deleteModel(long id) {

    }

    @Override
    public void updateModel(Settings settings) {

    }

    @Override
    public Settings selectModel(long id) {
        return null;
    }

    @Override
    public List<Settings> selectAllModels() {
        return null;
    }
}
