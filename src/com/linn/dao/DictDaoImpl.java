package com.linn.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.linn.domain.Dict;

public class DictDaoImpl extends BaseDaoImpl<Dict> implements DictDao{

	
	public List<Dict> findByCode(String dict_type_code) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Dict.class);
		criteria.add(Restrictions.eq("dict_type_code", dict_type_code));
		List<Dict> list = (List<Dict>) this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}

}
