package com.linn.service;

import java.util.List;

import com.linn.domain.Dict;

public interface DictService {

	List<Dict> findByCode(String dict_type_code);
	
}
