package com.se2.ebanking.services;


import com.se2.ebanking.models.*;
import com.se2.ebanking.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
    private TransactionRateDAO transactionRateDAO;
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


    public List<Account> getAccountList() {
        List<Account> accs = accountDAO.selectAllModels();
        List<Account> accounts = new ArrayList<>();
        for (Account acc:accs) {
            if(acc.getIs_active()==0){
                accounts.add(acc);
            }

        }
        return accounts;
    }

    public void register(Customer cus) {
        DateFormat df = new SimpleDateFormat("yy/MM/dd");

        Date join_date = new Date(Calendar.getInstance().getTime().getTime());
        cus.setJoin_date(join_date);
        customerDAO.insertModel(cus);
        cus = customerDAO.findCustomerByPhone(cus.getCustomer_phone());
        accountDAO.insertModel(new Account(join_date, 0, "deposit", cus.getCustomer_id(), 0));
        roleDAO.insertModel(new Role("ROLE_USER", cus.getCustomer_id()));

    }

    public List<Transaction> getTransationList() {
        return transactionDAO.selectAllModels();
    }

    public List<Float> getRateList() {
        return transactionRateDAO.selectAllTransactionRate();
    }

    public void updateTransactionRate(String loan, String saving, String transfer) {
        transactionRateDAO.updateModel(new TransactionRate(Float.valueOf(loan), Float.valueOf(saving), Float.valueOf(transfer)));
    }

    public void updateAccount(String id,String balance) {
        Account acc = accountDAO.selectModel(Long.valueOf(id));
        System.out.println(acc.getBalance());
        System.out.println(balance);
        acc.setBalance(Float.valueOf(balance));
        acc.setIs_active(1);
        accountDAO.updateModel(acc);
    }
}
