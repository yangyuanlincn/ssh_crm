package com.linn.web.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.linn.domain.Customer;
import com.linn.domain.Dict;
import com.linn.domain.PageBean;
import com.linn.service.CustomerService;
import com.linn.utils.FastJsonUtil;
import com.linn.utils.UploadUtils;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends BaseAction implements ModelDriven<Customer>{

	private static final long serialVersionUID = -159036545200608812L;
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	//模型驱动方式封装数据
	private Customer customer=new Customer();//需要自己创建对象
	public Customer getModel() {
		return customer;
	}
	
	/**
	 * 跳转到添加页面
	 * @return
	 */
	public String addUI() {
		return "addUI";
	}
	
	//文件上传需要定义三个属性，并提供set方法
	
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	/**
	 * 添加客户
	 * @return
	 * @throws IOException 
	 */
	public String save() throws IOException {
		if(uploadFileName != null) {
			String path="D:/Tomcat/apache-tomcat-9.0.5/webapps/upload";
			String uuidName = UploadUtils.getUUIDName(uploadFileName);
			File file=new File(path,uuidName);
			FileUtils.copyFile(upload,file);
			
			customer.setFilepath(path+"/uuidName");
		}
		
		customerService.save(customer);
		return "save";
	}
	
	public String findByPage() {
		DetachedCriteria criteria=DetachedCriteria.forClass(Customer.class);
		//名称
		String cust_name = customer.getCust_name();
		if(cust_name!=null && !cust_name.trim().isEmpty()) {
			criteria.add(Restrictions.like("cust_name", "%"+cust_name+"%"));
		}
		//来源
		Dict source = customer.getSource();
		if(source!=null && source.getDict_id()!=null && !source.getDict_id().trim().isEmpty()) {
			criteria.add(Restrictions.eq("source.dict_id",source.getDict_id()));
		}
		//级别
		Dict level = customer.getLevel();
		if(level!=null && level.getDict_id()!=null && !level.getDict_id().trim().isEmpty()) {
			criteria.add(Restrictions.eq("level.dict_id", level.getDict_id()));
		}
		PageBean<Customer> page=customerService.findByPage(this.getCurrPage(),this.getPageSize(),criteria);
		this.setVs("page", page);
		
		return "page";
	}
	
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String updateUI() {
		customer=customerService.findById(customer.getCust_id());
		return "updateUI";
	}
	
	/**
	 * 更新客户信息
	 * @return
	 * @throws IOException 
	 */
	public String update() throws IOException {
		//判断客户有没有上传新的文件
		if(uploadFileName!=null) {
			String filepath=customer.getFilepath();
			File oldFile=new File(filepath);
			//删除原来的而文件
			if(oldFile.exists()) {
				oldFile.delete();
			}
			//把新上传的文件保存
			String path="D:/Tomcat/apache-tomcat-9.0.5/webapps/upload";
			String uuidName = UploadUtils.getUUIDName(uploadFileName);
			File newFile=new File(path,uuidName);
			FileUtils.copyFile(upload, newFile);
			customer.setFilepath(path+"/"+uuidName);
		}
		
		customerService.update(customer);
		return "update";
	}
	
	
	/**
	 * 删除客户
	 */
	public String delete() {
		customer=customerService.findById(customer.getCust_id());
		String filepath=customer.getFilepath();
		//如果文件存在，先删除文件
		if(filepath !=null && !filepath.trim().isEmpty()) {
			File file=new File(filepath);
			if(file.exists()) {
				file.delete();
			}
		}
		customerService.delete(customer);
		return "delete";
	}
	
	/**
	 * 查询所有客户，返回json数据
	 * @return
	 */
	public String findAll() {
		List<Customer> list=customerService.findAll();
		String jsonString = FastJsonUtil.toJSONString(list);
		FastJsonUtil.write_json(ServletActionContext.getResponse(), jsonString);
		return NONE;
	}
	
}
