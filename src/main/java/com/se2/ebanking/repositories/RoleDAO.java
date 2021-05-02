package com.se2.ebanking.repositories;

import com.se2.ebanking.Connection.dbConnect;
import com.se2.ebanking.models.Role;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDAO implements DAO<Role>{

    private Connection connection;
    public RoleDAO(){
        this.connection = dbConnect.getConnection();
    }


    public Set<Role> getRoleNames(long id){
        String query = "SELECT * FROM role WHERE customer_id = ?";
        Set<Role> roles = new HashSet<>();
        try{
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setLong(1,id);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                long role_id = rs.getLong("role_id");
                String role = rs.getString("role");
                long customer_id = rs.getLong("customer_id");
                roles.add(new Role(role_id, role, customer_id));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return roles;
    }

    @Override
    public void insertModel(Role role) {

    }

    @Override
    public void deleteModel(long id) {

    }

    @Override
    public void updateModel(Role role) {

    }

    @Override
    public Role selectModel(long id) {
        return null;
    }

    @Override
    public List<Role> selectAllModels() {
        return null;
    }
}
