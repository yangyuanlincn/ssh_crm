package com.linn.service;

import java.util.List;

import com.linn.dao.DictDao;
import com.linn.domain.Dict;

public class DictServiceImpl implements DictService{

	private DictDao dictDao;
	public void setDictDao(DictDao dictDao) {
		this.dictDao = dictDao;
	}
	
	/**
	 * 通过code获取字典集合
	 */
	public List<Dict> findByCode(String dict_type_code) {
		return dictDao.findByCode(dict_type_code);
	}

}
