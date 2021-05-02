package com.se2.ebanking.controllers;


import com.se2.ebanking.models.Customer;
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
}
