package com.linn.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import com.linn.domain.PageBean;

/**
 * 通用的Dao类
 * @author Linn
 *
 */
@SuppressWarnings("all")
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>{
	private Class clazz;
	
	public BaseDaoImpl() {
		//this表示子类对象
		Class c = this.getClass();
		Type type = c.getGenericSuperclass();
		if(type instanceof ParameterizedType) {
			ParameterizedType pType=(ParameterizedType)type;
			Type[] types = pType.getActualTypeArguments();
			this.clazz=(Class) types[0];
		}
	}
	public List<T> findAll() {
		return (List<T>) this.getHibernateTemplate().find("from "+clazz.getSimpleName());
	}

	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	public T findById(Long id) {
		return (T)this.getHibernateTemplate().get(clazz, id);
	}

	public PageBean<T> findByPage(Integer currPage, Integer pageSize, DetachedCriteria criteria) {
		PageBean<T> page=new PageBean<T>();
		// select count(*) from....
		criteria.setProjection(Projections.rowCount());
		List<Number> list = (List<Number>) this.getHibernateTemplate().findByCriteria(criteria);
		if(list!=null && list.size() > 0) {
			int totalCount=list.get(0).intValue();
			page.setTotalCount(totalCount);
		}
		
		criteria.setProjection(null);
		List<T> beanList = (List<T>) this.getHibernateTemplate().findByCriteria(criteria, (currPage-1)*pageSize, pageSize);
		page.setList(beanList);
		page.setCurrPage(currPage);
		page.setPageSize(pageSize);
		
		return page;
	}
	
	
}
