package com.linn.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.linn.dao.CustomerDao;
import com.linn.domain.Customer;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
public class test {
//	@Resource(name="customerDao")
//	private CustomerDao customerDao;
//	@Test
//	public void test1() {
//		Customer customer=new Customer();
//		customer.setCust_id(1L);
//		customer.setCust_name("meimei");
//		customerDao.save(customer);
//	}
//	
	@Test
	public void test2() {
		Customer customer=new Customer();
		if(customer.getCust_name()!=null&&!customer.getCust_name().trim().isEmpty()) {
			System.out.println("shuchule");
		}
		
	}
}
