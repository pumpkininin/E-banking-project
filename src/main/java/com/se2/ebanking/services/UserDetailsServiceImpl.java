package com.se2.ebanking.services;

import com.se2.ebanking.models.Customer;
import com.se2.ebanking.models.Role;
import com.se2.ebanking.repositories.CustomerDAO;
import com.se2.ebanking.repositories.DAOFactory;
import com.se2.ebanking.repositories.RoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private DAOFactory daoFactory;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Customer customer = ((CustomerDAO)this.daoFactory.getDAO("Customer")).findCustomerByPhone(userName);

        if (customer == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");

        }

        System.out.println("Found User: " + customer);

        // [ROLE_USER, ROLE_ADMIN,..]
        System.out.println(customer.getCustomer_id());
        Set<Role> roleNames = ((RoleDAO)this.daoFactory.getDAO("Role")).getRoleNames(customer.getCustomer_id());

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (Role role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role.getRole());
                grantList.add(authority);
            }
        }

        UserDetails userDetails = (UserDetails) new User(customer.getCustomer_phone(), //
                customer.getPassword(), grantList);
        System.out.println(userDetails.getPassword());
        return userDetails;
    }

}
