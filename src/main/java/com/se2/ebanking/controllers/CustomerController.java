package com.se2.ebanking.controllers;

import com.se2.ebanking.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customer/")
    public String index(Model model){
        return "index";
    }
    @RequestMapping(value = "/customer/transfer-form")
    public String transferForm(Model model){
        return "customer/transfer";
    }

    @RequestMapping(value = {"/customer/transfer-confirm-form"}, method = RequestMethod.POST)
    public String transferConfirmForm(@RequestParam(value = "money", required = true) String money,
                                      @RequestParam(value = "receiverId", required = true) String receiverId,
                                      Model model, Principal principal){
        List<String> transferInfo = new ArrayList<>();
        transferInfo.add(money);
        transferInfo.add(receiverId);
        String fee = String.valueOf(customerService.getSettings().get(2)*Float.valueOf(money));
        transferInfo.add(fee);
        if(customerService.getAccount(principal.getName()).getBalance() > Float.valueOf(money)){
            model.addAttribute("transferInfo", transferInfo);
            return "/customer/transfer-confirm";
        }else{
            model.addAttribute("transferFail", "invalidMoney");
            return "/customer/transfer-fail";
        }



    }
    @RequestMapping(value = {"/customer/transfer-finish"}, method = RequestMethod.POST)
    public String transferFinish(@RequestParam(value = "money", required = true) String money,
                                 @RequestParam(value = "receiverId", required = true) String receiverId,
                                 @RequestParam(value = "fee") String fee,
                                 @RequestParam(value = "password") String password,
                                 Model model, Principal principal){
        String phoneNumber = principal.getName();
        if(customerService.authen(phoneNumber, password)){
            customerService.transferMoney(phoneNumber,money, receiverId, fee);
            return "redirect:/";
        }else{
            model.addAttribute("transferFail", "Invalid password");
            return "/customer/transfer-fail";
        }

    }
    @RequestMapping(value = {"/customer/loan-form"})
    public String loanForm(Model model){

        return "/customer/loan";
    }
    @RequestMapping(value = {"/customer/loan-confirm-form"}, method = RequestMethod.POST)
    public String loanConfirmForm(@RequestParam(value = "money-loan", required = true) String money, @RequestParam(value = "duration", required = true) String duration, Model model){
        List<String> loanInfo = new ArrayList<>();
        String loanRate = String.valueOf(customerService.getSettings().get(1));
        loanInfo.add(money);
        loanInfo.add(duration);
        loanInfo.add(loanRate);
        model.addAttribute("loanInfo", loanInfo);

        return "/customer/loan-confirm";
    }
    @RequestMapping(value ={"/customer/loan-finish"}, method = RequestMethod.POST)
    public String finishLoan(@RequestParam(value = "money-loan", required = true) String money,
                             @RequestParam(value = "duration", required = true) String duration,
                             @RequestParam(value = "rate") String rate,
                             @RequestParam(value = "password",required = true )String password,
                             Principal principal,Model model){
        String phoneNumber = principal.getName();
        if(customerService.authen(phoneNumber, password)){
            customerService.loanMoney(phoneNumber, money, duration,rate);
            return "redirect:/";
        }else{
            model.addAttribute("loanFail", "Invalid password");
            return "/customer/loan";
        }
    }
    @RequestMapping(value = "/customer/balance")
    public String balanceDetail(Model model, Principal principal){
        model.addAttribute("account", customerService.getAccount(principal.getName()));
        model.addAttribute("saving", customerService.getSaving(principal.getName()));
        model.addAttribute("loan", customerService.getLoan(principal.getName()));
        return "customer/balance";
    }
    @RequestMapping(value = {"/customer/deposit-form"})
    public String depositForm(Model model){
        return "/customer/deposit";
    }
    @RequestMapping(value = {"/customer/deposit-confirm-form"})
    public String depositConfirmForm(@RequestParam(value = "money-deposit", required = true)String money, Model model){
        model.addAttribute("moneyDeposit", money);
        return "/customer/deposit-confirm";
    }
    @RequestMapping(value = {"/customer/deposit-finish"}, method=RequestMethod.POST)
    public String finishDeposit(@RequestParam(value = "money-deposit", required = true)String money,
                                @RequestParam(value = "password", required = true)String password,
                                Model model, Principal principal){
        if(customerService.authen(principal.getName(),password)){
            customerService.deposit(principal.getName(), money);
            return "redirect:/";
        }else{
            model.addAttribute("depositFail", "Invalid password");
            return "/customer/deposit";
        }
    }
    @RequestMapping(value = {"/customer/saving-form"})
    public String savingForm(Model model){
        return "/customer/saving";
    }
    @RequestMapping(value = {"/customer/saving-confirm-form"}, method = RequestMethod.POST)
    public String savingConfirmForm(@RequestParam(value = "money-saving", required = true) String money, @RequestParam(value = "saving-duration", required = true) String duration, Model model){
        List<String> savingInfo = new ArrayList<>();
        savingInfo.add(money);
        savingInfo.add(duration);
        savingInfo.add(customerService.getSettings().get(2).toString());
        model.addAttribute("savingInfo", savingInfo);

        return "/customer/saving-confirm";
    }
    @RequestMapping(value = {"/customer/saving-finish"}, method = RequestMethod.POST)
    public String finishSaving(@RequestParam(value = "money-saving", required = true) String money,
                               @RequestParam(value = "duration", required = true) String duration,
                               @RequestParam(value = "rate") String rate,
                               @RequestParam(value = "password",required = true )String password,
                               Principal principal,Model model){
        String phoneNumber = principal.getName();
        if(customerService.authen(phoneNumber, password)){
            if(customerService.saveMoney(phoneNumber, money, duration,rate)){
                return "redirect:/";
            }else{
                model.addAttribute("savingFail", "Invalid Saving");
                return "/customer/saving";
            }
        }else{
            model.addAttribute("savingFail", "Invalid password");
            return "/customer/saving";
        }
    }
    @RequestMapping(value = {"/customer/withdraw-form"})
    public String withdrawForm(Model model, Principal principal){
        model.addAttribute("accountInfo", customerService.getAccount(principal.getName()));
        model.addAttribute("savingInfo", customerService.getSaving(principal.getName()));
        return "/customer/withdraw";
    }
    @RequestMapping(value = {"/customer/withdraw-confirm-form"}, method = RequestMethod.POST)
    public String withdrawConfirmForm(@RequestParam(value = "account") String account, Model model){


        model.addAttribute("withdrawInfo", account);

        return "/customer/withdraw-confirm";
    }
    @RequestMapping(value = {"/customer/withdraw-finish"}, method = RequestMethod.POST)
    public String finishWithdraw(@RequestParam(value = "money-withdraw") String money,
                                 @RequestParam(value = "account-type") String account,
                                 @RequestParam(value = "password") String password,
                                 Model model, Principal principal){
        if(customerService.authen(principal.getName(), password)){
            customerService.withdraw(money, account, principal.getName());
            return "redirect:/";
        }else{
            return "redirect:/";
        }
    }

}
