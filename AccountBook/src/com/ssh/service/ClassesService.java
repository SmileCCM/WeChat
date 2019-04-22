package com.ssh.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssh.dao.ClassesDAO;
import com.ssh.dao.UserclassDAO;
import com.ssh.entity.Classes;
import com.ssh.entity.Userclass;
import com.ssh.entity.Users;

public class ClassesService {
	public List findclasses() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		ClassesDAO dao = (ClassesDAO) ac.getBean("ClassesDAO");
		List<Classes> cs=new ArrayList<Classes>();
		cs=dao.findAll();
		return cs;
	}
	public List finduserc(Users user) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserclassDAO dao=(UserclassDAO) ac.getBean("UserclassDAO");
		List<Userclass> cs=new ArrayList<Userclass>();
		cs=dao.findByProperty("users.openid", user.getOpenid());
		return cs;
	}
	public int addclass(Userclass uc) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		ClassesDAO dao = (ClassesDAO) ac.getBean("ClassesDAO");
        if (dao.findByCname(uc.getCname()).size()!=0) {
			return 0;
		}
        else {
            UserclassDAO dao2=(UserclassDAO) ac.getBean("UserclassDAO");
			if (dao2.findByExample(uc).size()!=0) {
				return 0;
			}
			else {
				dao2.save(uc);
				return 1;
			}
		}
	}
	public void delete(Userclass uc) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		 UserclassDAO dao=(UserclassDAO) ac.getBean("UserclassDAO");
		 dao.delete(uc);
	}
	public void update(Userclass uc) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserclassDAO dao=(UserclassDAO) ac.getBean("UserclassDAO");
		dao.attachDirty(uc);
	}
}
