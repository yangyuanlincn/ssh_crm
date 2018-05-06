package com.linn.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.linn.domain.Customer;

/**
 * 客户持久层
 * @author Linn
 *
 */
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
	
	/**
	 * 保存客户
	 */
	@Transactional
	public void save(Customer customer) {
		this.getHibernateTemplate().save(customer);
		
	}

}
