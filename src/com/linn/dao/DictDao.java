package com.linn.dao;

import java.util.List;

import com.linn.domain.Dict;

public interface DictDao extends BaseDao<Dict>{

	List<Dict> findByCode(String dict_type_code);

}
