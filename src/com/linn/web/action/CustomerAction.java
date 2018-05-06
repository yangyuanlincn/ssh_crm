package com.linn.web.action;

import com.linn.domain.Customer;
import com.linn.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	private static final long serialVersionUID = 1L;
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	private Customer customer=new Customer();//需要自己创建对象
	public Customer getModel() {
		return customer;
	}
	/**
	 * 添加客户
	 * @return
	 */
	public String add() {
		customerService.save(customer);
		return NONE;
	}

	
}
