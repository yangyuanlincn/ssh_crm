package com.linn.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class BaseAction extends ActionSupport{

	private static final long serialVersionUID = 8535776060216750960L;
	private Integer pageSize=10;
	private Integer currPage=1;
	
	public Integer getPageSize() {
		return pageSize;
	}

	public Integer getCurrPage() {
		return currPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public void setCurrPage(Integer currPage) {
		if(currPage==null) {
			currPage=1;
		}
		this.currPage=currPage;
	}
	
	/*
	 * set方法压栈
	 */
	public void setVs(String key,Object object) {
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.set(key, object);
	}
	
	public void pustVs(Object object) {
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.push(object);
	}
}
