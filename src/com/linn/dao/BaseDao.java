package com.linn.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.linn.domain.PageBean;

public interface BaseDao<T> {
	List<T> findAll();
	void save(T t);
	void update(T t);
	void delete(T t);
	T findById(Long id);
	PageBean<T> findByPage(Integer currPage,Integer pageSize,DetachedCriteria criteria);
}
