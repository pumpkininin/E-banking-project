package com.se2.ebanking.services;


import com.se2.ebanking.models.*;
import com.se2.ebanking.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import static com.se2.ebanking.utils.EncrytedPasswordUtils.doPasswordsMatch;

@Service
@Configurable
public class CustomerService {




    private DAOFactory daoFactory;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    public Customer findCustomerByPhone(String phoneNumber) {
        return ((CustomerDAO) daoFactory.getDAO("Customer")).findCustomerByPhone(phoneNumber);
    }

    public Set<Role> getRole(long customer_id) {
        return ((RoleDAO)daoFactory.getDAO("Role")).getRoleNames(customer_id);
    }



    public void register(Customer cus) {



        Date join_date = getCurrentTime();
        cus.setJoin_date(join_date);
        daoFactory.getDAO("Customer").insertModel(cus);
        cus = findCustomerByPhone(cus.getCustomer_phone());
        daoFactory.getDAO("Account").insertModel(new Account(join_date, 0, "deposit", cus.getCustomer_id(), 0));
        daoFactory.getDAO("Role").insertModel(new Role("ROLE_USER", cus.getCustomer_id()));
    }

    public void transferMoney(String phoneNumber, String money, String receiverId, String fee) {
        Customer cus = findCustomerByPhone(phoneNumber);
        long customer_id = cus.getCustomer_id();
        Date transaction_date = getCurrentTime();
        Transaction newTransaction = new Transaction(transaction_date,Float.valueOf(money), customer_id, Long.valueOf(receiverId),"transfer", Float.valueOf(fee));
        daoFactory.getDAO("Transaction").insertModel(newTransaction);
        Account senderAccount = getAccount(phoneNumber);
        Account receiverAccount = ((AccountDAO) daoFactory.getDAO("Account")).selectModel(Long.valueOf(receiverId));
        receiverAccount.getAccount_id();
        senderAccount.setBalance(senderAccount.getBalance()-Float.valueOf(money) -Float.valueOf(fee));
        receiverAccount.setBalance(receiverAccount.getBalance() + Float.valueOf(money));
        ((AccountDAO) daoFactory.getDAO("Account")).updateModel(senderAccount);
        ((AccountDAO) daoFactory.getDAO("Account")).updateModel(receiverAccount);
    }

    public Account getAccount(String phoneNumber) {
        return (Account) daoFactory.getDAO("Account").selectModel(findCustomerByPhone(phoneNumber).getCustomer_id());

    }

    public List<Float> getTransactionRate() {
        return ((TransactionRateDAO) daoFactory.getDAO("TransactionRate")).selectAllTransactionRate();
    }



    public boolean authen(String phoneNumber, String password) {
        Customer cus = findCustomerByPhone(phoneNumber);
        return doPasswordsMatch(password, cus.getPassword());
    }

    public void loanMoney(String phoneNumber, String money, String duration, String rate) {
        Customer cus = findCustomerByPhone(phoneNumber);
        long customer_id = cus.getCustomer_id();
        Date loan_date = getCurrentTime();
        daoFactory.getDAO("Loan").insertModel(new Loan(Float.valueOf(money), Integer.valueOf(duration), Float.valueOf(rate), customer_id, loan_date));
        Account acc = getAccount(phoneNumber);
        acc.setBalance(acc.getBalance()+ Float.valueOf(money));
        daoFactory.getDAO("Account").updateModel(acc);
        daoFactory.getDAO("Transaction").insertModel(new Transaction(loan_date, Float.valueOf(money), acc.getCustomer_id(), acc.getCustomer_id(), "Loan",Float.valueOf(rate)));
    }
    public Date getCurrentTime(){
        DateFormat df = new SimpleDateFormat("yy/MM/dd");
        return new Date(Calendar.getInstance().getTime().getTime());
    }

    public Saving getSaving(String name) {
        return (Saving) daoFactory.getDAO("Saving").selectModel(findCustomerByPhone(name).getCustomer_id());
    }

    public boolean saveMoney(String phoneNumber, String money, String duration, String rate) {
        if(getSaving(phoneNumber) == null) {
            Customer cus = findCustomerByPhone(phoneNumber);
            long customer_id = cus.getCustomer_id();
            Date open_date = getCurrentTime();
            daoFactory.getDAO("Saving").insertModel(new Saving(Float.valueOf(money), Integer.valueOf(duration), Float.valueOf(rate), Long.valueOf(customer_id), open_date));
            daoFactory.getDAO("Transaction").insertModel(new Transaction(open_date, Float.valueOf(money), cus.getCustomer_id(), cus.getCustomer_id(),"saving",Float.valueOf(rate)));
            return true;
        }
        return false;
    }

    public boolean withdraw(String money, String account, String phoneNumber) {
        if(account.equals("deposit")){
            Account acc  = getAccount(phoneNumber);
            float moneyWithdraw = Float.valueOf(money);
            System.out.println(moneyWithdraw);
            if(acc.getBalance() > moneyWithdraw ){
                acc.setBalance(acc.getBalance() - moneyWithdraw);
                daoFactory.getDAO("Account").updateModel(acc);
                return true;
            }else{
                return false;
            }
        }else{
            daoFactory.getDAO("Saving").deleteModel(findCustomerByPhone(phoneNumber).getCustomer_id());
            Account acc  = getAccount(phoneNumber);
            acc.setBalance(acc.getBalance()+Float.valueOf(money));
            daoFactory.getDAO("Account").updateModel(acc);
            return true;
        }
    }

    public Loan getLoan(String phoneNumber) {
        return (Loan) daoFactory.getDAO("Loan").selectModel(findCustomerByPhone(phoneNumber).getCustomer_id());

    }

    public void deposit(String name, String money) {
        Account acc = getAccount(name);
        acc.setBalance(acc.getBalance()+ Float.valueOf(money));
        daoFactory.getDAO("Account").updateModel(acc);
    }

    public Customer getCustomer(long customer_id) {
        return (Customer) daoFactory.getDAO("Customer").selectModel(customer_id);
    }
}
