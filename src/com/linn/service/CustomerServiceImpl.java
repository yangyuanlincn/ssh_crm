package com.linn.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.linn.dao.CustomerDao;
import com.linn.domain.Customer;
import com.linn.domain.PageBean;
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

	/**
	 * 保存客户
	 */
	public void save(Customer customer) {
		customerDao.save(customer);
	}

	/**
	 * 分页查询客户
	 */
	public PageBean<Customer> findByPage(Integer currPage, Integer pageSize, DetachedCriteria criteria) {
		return customerDao.findByPage(currPage,pageSize,criteria);
	}

	/**
	 * 通过id查询客户
	 */
	public Customer findById(Long cust_id) {
		return customerDao.findById(cust_id);
	}

	public void update(Customer customer) {
		customerDao.update(customer);
	}

	public void delete(Customer customer) {
		customerDao.delete(customer);
	}

	public List<Customer> findAll() {
		return customerDao.findAll();
	}

}
