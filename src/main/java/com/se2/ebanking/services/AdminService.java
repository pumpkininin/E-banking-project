package com.se2.ebanking.services;


import com.se2.ebanking.models.Customer;
import com.se2.ebanking.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Configurable
public class AdminService {
    private CustomerDAO customerDAO = new CustomerDAO();
    @Autowired
    private RoleDAO roleDAO;
    @Autowired
    private TransactionDAO transactionDAO;
    @Autowired
    private AccountDAO accountDAO;
    @Autowired
    private SettingDAO settingDAO;
    @Autowired
    private LoanDAO loanDAO;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    public List<Customer> getCustomerList() {
        return customerDAO.selectAllModels();
    }
    public Customer getCustomerById(long id) {
        return customerDAO.selectModel(id);
    }
    public void updateCustomer(Customer cus) {
        customerDAO.updateModel(cus);
    }
    public void deleteCustomer(long id) {
        customerDAO.deleteModel(id);
    }
}
