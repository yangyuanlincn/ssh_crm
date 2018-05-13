package com.linn.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.linn.domain.Dict;
import com.linn.service.DictService;
import com.linn.utils.FastJsonUtil;
import com.opensymphony.xwork2.ModelDriven;

public class DictAction extends BaseAction implements ModelDriven<Dict>{

	private DictService dictService;
	public void setDictService(DictService dictService) {
		this.dictService = dictService;
	}


	private static final long serialVersionUID = 7712003050584149384L;
	private Dict dict=new Dict();
	public Dict getModel() {
		return this.dict;
	}
	
	
	public String findByCode() {
		List<Dict> list=dictService.findByCode(dict.getDict_type_code());
		String jsonString=FastJsonUtil.toJSONString(list);
		FastJsonUtil.write_json(ServletActionContext.getResponse(), jsonString);
		return NONE;
		
	}
}
