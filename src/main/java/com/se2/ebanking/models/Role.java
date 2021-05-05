package com.se2.ebanking.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
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
}