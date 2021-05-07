package com.se2.ebanking.models;




import java.io.Serializable;


public class Role implements Serializable{
    private String role;

    private long role_id;

    private long customer_id;


    public Role(long role_id, String role, long customer_id) {
        this.role = role;
        this.role_id = role_id;
        this.customer_id = customer_id;
    }
    public Role(String role, long customer_id){
        this.role = role;
        this.customer_id = customer_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getRole_id() {
        return role_id;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }
}