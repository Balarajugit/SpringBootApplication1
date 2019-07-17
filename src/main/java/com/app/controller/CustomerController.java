package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.module.Customer;
import com.app.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private ICustomerService service;
	@RequestMapping("/reg")
	public String regPage(Model map) {
		map.addAttribute("customer", new Customer());
		return "Register";
	}
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String save(@ModelAttribute Customer customer,Model map) {
		
		Integer id=service.saveById(customer);
		map.addAttribute("message", "recird '"+id+"' inserted");
		map.addAttribute("customer", new Customer());
		return "Register";
	}
	@RequestMapping("/data")
	public String data(Model map) {
		List<Customer> l=service.getAppCustomers();
		map.addAttribute("list", l);
		return "Data";
	}
	@RequestMapping("/view/{id}")
	public String viewOne(@PathVariable Integer id,Model map) {
		Customer c=service.getById(id);
		
		map.addAttribute("ob", c);
		return "View";
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Integer id,Model map) {
		service.deleteById(id);
		List<Customer> l=service.getAppCustomers();
		map.addAttribute("list", l);
		map.addAttribute("message", "deleted '"+id+"' record");
		return "Data";
	}
	@RequestMapping("/update/{id}")
	public String updateForm(Model map,@PathVariable Integer id) {
		Customer c=service.getById(id);
		map.addAttribute("customer", c);
		
		return "Update";
	}
	@RequestMapping(value = "/updated",method = RequestMethod.POST)
	public String updateRecord(@ModelAttribute Customer customer,Model map) {
		
		Integer id=service.updateDetails(customer);
		map.addAttribute("message", "your '"+id+"' Reord updated sucessfully");
		map.addAttribute("customer", new Customer());
		
		
		return "Register";
	}
}
