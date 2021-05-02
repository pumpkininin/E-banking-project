package com.se2.ebanking.controllers;

import com.se2.ebanking.models.Customer;
import com.se2.ebanking.models.Role;
import com.se2.ebanking.services.CustomerService;
import com.se2.ebanking.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.se2.ebanking.utils.EncrytedPasswordUtils.encrytePassword;

@Controller
@SessionAttributes("Customer")
public class MainController {

    @Autowired
    private CustomerService customerService;


    @RequestMapping("/")
    public String index(Model model, Principal principal) {
        // Sau khi user login thanh cong se co principal
        if(principal !=null){
            String phoneNumber = principal.getName();

            Customer customer = customerService.findCustomerByPhone(phoneNumber);
            model.addAttribute("Customer", customer);

        }
        return "index";
    }
    @RequestMapping("/login-form")
    public String login(Model model){

        return "login";
    }
    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "index";
    }
    @RequestMapping(value = "/register")
    public String registerForm(Model model){
        return "register";
    }
    @RequestMapping(value = "/register-confirm", method = RequestMethod.POST)
    public String confirmRegister(Model model, @RequestParam(value = "firstName") String firstname, @RequestParam(value = "lastName") String lastname,
                                 @RequestParam(value = "email") String email, @RequestParam(value = "phoneNumber") String phoneNumber,
                                 @RequestParam(value = "country") String country, @RequestParam(value="province") String province, @RequestParam(value = "town") String town,
                                 @RequestParam(value = "dob") Date dob)
    {
        List<String> registerInfo = new ArrayList<>();
        registerInfo.add(firstname);
        registerInfo.add(lastname);
        registerInfo.add(email);
        registerInfo.add(phoneNumber);
        registerInfo.add(country + province + town);
        registerInfo.add(dob.toString());
        model.addAttribute("registerInfo", registerInfo);
        return "register-confirm";

    }
    @RequestMapping(value = "/register-finish", method = RequestMethod.POST)
    public String finishRegister(Model model, @RequestParam(value = "firstName") String firstname, @RequestParam(value = "lastName") String lastname,
                                  @RequestParam(value = "email") String email, @RequestParam(value = "phoneNumber") String phoneNumber,
                                  @RequestParam(value = "address") String address, @RequestParam(value = "dob") Date dob, @RequestParam(value = "password") String password)
    {
        Customer cus = new Customer(firstname, lastname, email, phoneNumber, address, dob);
        cus.setPassword(encrytePassword(password));
        cus.setLogin(phoneNumber);
        customerService.register(cus);
        return "index";
    }

}
