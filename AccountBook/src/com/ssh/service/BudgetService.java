package com.ssh.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssh.dao.BudgetDAO;
import com.ssh.entity.Budget;
import com.ssh.entity.BudgetId;

public class BudgetService {
    public Budget findbudget(BudgetId id) {
    	ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
    	BudgetDAO dao=(BudgetDAO) ac.getBean("BudgetDAO");
    	return dao.findById(id);
	}
    public void updatebud(Budget b) {
    	ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
    	BudgetDAO dao=(BudgetDAO) ac.getBean("BudgetDAO");
    	dao.attachDirty(b);
	}
}
