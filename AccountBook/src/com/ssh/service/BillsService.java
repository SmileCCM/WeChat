package com.ssh.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssh.dao.BillsDAO;
import com.ssh.dao.ViewUserSumDAO;
import com.ssh.entity.Bills;
import com.ssh.entity.ViewUserSum;

public class BillsService {
     public void addbill(Bills bill) {
    	 ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
    	 BillsDAO dao=(BillsDAO) ac.getBean("BillsDAO");
    	 dao.save(bill);
	}
     public List<ViewUserSum> findsum(ViewUserSum sum) {
    	 ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
    	 ViewUserSumDAO dao=(ViewUserSumDAO) ac.getBean("ViewUserSumDAO");
    	 return dao.findByExample(sum);
	}
    public List<Bills> findbills(String openid,String bdate) {
    	ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
   	    BillsDAO dao=(BillsDAO) ac.getBean("BillsDAO");
   	    return dao.findByMonth(openid, bdate);
	}
    public void updatebill(Bills bill) {
    	ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
   	    BillsDAO dao=(BillsDAO) ac.getBean("BillsDAO");
   	    dao.attachDirty(bill);
	}
    public List findbyconditions(Double min,Double max,String classes,String seek,String openid) {
    	ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
   	    BillsDAO dao=(BillsDAO) ac.getBean("BillsDAO");
   	    return dao.findByItems(min,max,classes,seek,openid);
	}
    public void remove(Bills bill){
    	ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
   	    BillsDAO dao=(BillsDAO) ac.getBean("BillsDAO");
   	    dao.delete(bill);
    }
}
