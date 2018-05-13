package com.linn.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.linn.domain.Customer;
import com.linn.domain.PageBean;

public interface CustomerService {
	void save(Customer customer);

	PageBean<Customer> findByPage(Integer currPage, Integer pageSize, DetachedCriteria criteria);

	Customer findById(Long cust_id);

	void update(Customer customer);

	void delete(Customer customer);

	List<Customer> findAll();
}
