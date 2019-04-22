package com.ssh.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssh.dao.UsersDAO;
import com.ssh.entity.Users;

public class UserInfoService {
    
	public void userInfo(Users user) {
		 ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
         UsersDAO usurDao=(UsersDAO) ac.getBean("UsersDAO");
         usurDao.attachDirty(user);
	}
}
