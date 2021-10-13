package com.codegym.controller;


import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final ICustomerService customerService = new CustomerService();

    @GetMapping("")
    public String index(Model model){

        List<Customer> customers = customerService.findAll();

        model.addAttribute("customers", customers);
        return "index";
    }


    /// Thêm mới kh

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/save")
    public String save(Customer customer, RedirectAttributes redirect){
        customer.setId((int)(Math.random()*1000));
        customerService.save(customer);
        redirect.addAttribute("success", "Created New Customer");
        return "redirect:/customer";
    }

    // sửa


    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Customer customer){
        customerService.update(customer.getId(), customer);
        return "redirect:/customer";
    }

    //xóa


    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Customer customer,RedirectAttributes redirectAttributes){
        customerService.remove(customer.getId());
        redirectAttributes.addAttribute("success","removed");
        return "redirect:/customer";
    }


    // view chi tiết

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "view";
    }












}
