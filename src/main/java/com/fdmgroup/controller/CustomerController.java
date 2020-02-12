package com.fdmgroup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.database.Customer;
import com.fdmgroup.service.CustomerService;


@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;	
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String load(Model model) {
//		List<Customer> listCustomer = customerService.
//		return "index";
//	}
//	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String load(Model model) {
		List<Customer> listCustomer = customerService.listAll();
		model.addAttribute("listCustomer",listCustomer);
		return "index";
	}
	
	@RequestMapping(value = "/newCustomer", method = RequestMethod.POST)
	public String addCustomer(@RequestParam String name, @RequestParam String email,
			@RequestParam String address) {
		Customer customer = new Customer();
		customer.setName(name);
		customer.setEmail(email);
		customer.setAddress(address);
//		model.addAttribute("customer", customer);
		customerService.saveCustomer(customer);
		return "index";
	}
	
	@RequestMapping(value = "/newCustomer", method = RequestMethod.GET)
	public String goToAddCustomer() {
//		Customer customer = new Customer();
//		model.addAttribute("customer", customer);
		return "newCustomer";
	}
	
}
