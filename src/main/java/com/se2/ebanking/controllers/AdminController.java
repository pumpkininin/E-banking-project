package com.se2.ebanking.controllers;


import com.se2.ebanking.models.Account;
import com.se2.ebanking.models.Customer;
import com.se2.ebanking.models.Transaction;
import com.se2.ebanking.services.AdminService;
import com.se2.ebanking.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;

import static com.se2.ebanking.utils.EncrytedPasswordUtils.encrytePassword;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/admin/")
    public String getAdminIndex(Model model){
        List<Customer> customers = adminService.getCustomerList();
        model.addAttribute("customers", customers);
        return "/admin/admin-index";
    }
    @RequestMapping(value = {"/admin/edit-form"})
    public String getEditForm(@RequestParam(value = "id")long id, Model model){
        Customer cus = adminService.getCustomerById(id);
        model.addAttribute("customerObj", cus);
        return "/admin/edt-form";
    }
    @RequestMapping(value = {"/admin/edit-finish"})
    public String finishEdit(@RequestParam(value = "id") long id,
                             @RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName,
                             @RequestParam(value = "phoneNumber") String phoneNumber, @RequestParam(value = "address") String address,
                             @RequestParam(value = "email") String email, @RequestParam(value = "dob") Date dob ){
        Customer cus = new Customer(id, firstName, lastName, phoneNumber, address, email, dob);
        adminService.updateCustomer(cus);
        return "redirect:/admin/";
    }
    @RequestMapping(value = {"/admin/delete"})
    public String deleteCustomer(@RequestParam(value = "id") long id, Model model){
        System.out.println("aaaa");
        adminService.deleteCustomer(id);

        return "redirect:/admin/";
    }
    @RequestMapping(value = {"/admin/customer-account"})
    public String customerList(Model model){
        List<Account> accounts = adminService.getAccountList();
        model.addAttribute("accounts", accounts);
        return "/admin/customer-view";
    }
    @RequestMapping(value = {"/admin/set-balance-form"})
    public String setBalanceForm(@RequestParam(value = "id")long id, Model model){
        Customer cus = adminService.getCustomerById(id);
        model.addAttribute("customerObj", cus);
        return "/admin/customer-account";
    }
    @RequestMapping(value = {"/admin/finish-set-balance"}, method = RequestMethod.POST)
    public String finishSetBalance(Model model, @RequestParam(value = "initial-balance") String balance,
                                   @RequestParam(value = "id") String id){
        adminService.updateAccount(id,balance);
        return "redirect:/admin/";
    }
    @RequestMapping(value = {"/admin/add-customer-form"})
    public String addCustomerForm(Model model){
        return "/admin/add-customer";
    }
    @RequestMapping(value = {"/admin/finish-add-customer"}, method = RequestMethod.POST)
    public String finishAddCustomer(Model model, @RequestParam(value = "firstName") String firstname, @RequestParam(value = "lastName") String lastname,
                                    @RequestParam(value = "email") String email, @RequestParam(value = "phoneNumber") String phoneNumber,
                                    @RequestParam(value = "address") String address, @RequestParam(value = "dob") Date dob, @RequestParam(value = "password") String password)
    {
        Customer cus = new Customer(firstname, lastname, email, phoneNumber, address, dob);
        cus.setPassword(encrytePassword(password));
        cus.setLogin(phoneNumber);
        adminService.register(cus);
        return "redirect:/admin/";
    }
    @RequestMapping(value = {"/admin/transation-list"})
    public String listTransation(Model model){
        List<Transaction> transactions =  adminService.getTransationList();
        model.addAttribute("transactions", transactions);
        return "/admin/transaction-logs";
    }
    @RequestMapping(value = {"/admin/set-rate-form"})
    public String rateForm(Model model){
        model.addAttribute("rates", adminService.getRateList());
        return "/admin/manage-rate";
    }
    @RequestMapping(value = {"/admin/set-rate-finish"}, method = RequestMethod.POST)
    public String setRate(@RequestParam(value = "loan-rate")String loan,
                          @RequestParam(value = "saving-rate")String saving,
                          @RequestParam(value = "transfer-rate")String transfer,
                          Model model){
        adminService.updateTransactionRate(loan, saving, transfer);
        model.addAttribute("rates", adminService.getRateList());
        return "/admin/manage-rate";
    }


}