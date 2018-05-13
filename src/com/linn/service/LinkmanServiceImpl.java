package com.linn.service;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.linn.dao.LinkmanDao;
import com.linn.domain.Linkman;
import com.linn.domain.PageBean;

@Transactional
public class LinkmanServiceImpl implements LinkmanService{
	private LinkmanDao linkmanDao;

	public void setLinkmanDao(LinkmanDao linkmanDao) {
		this.linkmanDao = linkmanDao;
	}

	public PageBean<Linkman> findByPage(Integer currPage, Integer pageSize, DetachedCriteria criteria) {
		return linkmanDao.findByPage(currPage, pageSize, criteria);
	}

	public Linkman findById(Long id) {
		return linkmanDao.findById(id);
	}

	public void update(Linkman linkman) {
		linkmanDao.update(linkman);
	}

	public void delete(Linkman linkman) {
		linkmanDao.delete(linkman);
	}

	public void save(Linkman linkman) {
		linkmanDao.save(linkman);
	}
	
}
