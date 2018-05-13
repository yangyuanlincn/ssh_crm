package com.linn.service;

import org.hibernate.criterion.DetachedCriteria;

import com.linn.domain.Linkman;
import com.linn.domain.PageBean;

public interface LinkmanService {

	PageBean<Linkman> findByPage(Integer currPage, Integer pageSize, DetachedCriteria criteria);

	Linkman findById(Long id);

	void update(Linkman linkman);

	void delete(Linkman linkman);

	void save(Linkman linkman);

}
