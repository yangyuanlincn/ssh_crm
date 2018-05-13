package com.linn.web.action;

import org.hibernate.criterion.DetachedCriteria;

import com.linn.domain.Linkman;
import com.linn.domain.PageBean;
import com.linn.service.LinkmanService;
import com.opensymphony.xwork2.ModelDriven;

public class LinkmanAction extends BaseAction implements ModelDriven<Linkman>{
	
	
	private static final long serialVersionUID = -15638398727671725L;
	private LinkmanService linkmanService;
	
	public void setLinkmanService(LinkmanService linkmanService) {
		this.linkmanService = linkmanService;
	}

	private Linkman linkman= new Linkman();
	public Linkman getModel() {
		return linkman;
	}
	
	public String findByPage() {
		DetachedCriteria criteria=DetachedCriteria.forClass(Linkman.class);
		PageBean<Linkman> page=linkmanService.findByPage(this.getCurrPage(),this.getPageSize(),criteria);
		this.setVs("page", page);
		return "page";
	}
	
	public String updateUI() {
		linkman=linkmanService.findById(linkman.getLkm_id());
		return "updateUI";
	}
	
	public String update() {
		linkmanService.update(linkman);
		return "update";
	}
	
	public String delete() {
		linkman=linkmanService.findById(linkman.getLkm_id());
		linkmanService.delete(linkman);
		return "delete";
	}
	
	public String saveUI() {
		return "saveUI";
	}
	
	public String save() {
		linkmanService.save(linkman);
		return "save";
	}
}
