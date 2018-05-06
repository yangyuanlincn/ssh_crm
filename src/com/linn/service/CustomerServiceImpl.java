package com.linn.service;

import org.springframework.transaction.annotation.Transactional;

import com.linn.dao.CustomerDao;
import com.linn.domain.Customer;
/**
 * 客户业务层
 * @author Linn
 *
 */
@Transactional
public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao;
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void save(Customer customer) {
		customerDao.save(customer);
	}

}
