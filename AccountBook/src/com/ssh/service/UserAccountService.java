package com.ssh.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssh.dao.AccountDAO;
import com.ssh.entity.Account;

public class UserAccountService {
     public List<Account> getAccounts(String openid) {
    	 ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
    	 AccountDAO acdao=(AccountDAO) ac.getBean("AccountDAO");
    	 return acdao.findByProperty("users.openid", openid);
	}
    public int addaccount(Account account) {
    	ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
   	    AccountDAO acdao=(AccountDAO) ac.getBean("AccountDAO");
   	    Account acct=new Account();
   	    acct.setUsers(account.getUsers());
   	    acct.setAname(account.getAname());
   	    int i=acdao.findByExample(acct).size();
   	    if (i!=0) {
			return 0;
		}
    	else {
			acdao.save(account);
			return 1;
		}
	}
    public void updateacc(Account account) {
    	ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
   	    AccountDAO acdao=(AccountDAO) ac.getBean("AccountDAO");
   	    acdao.attachDirty(account);
	}
    public void deleteacc(Account account) {
    	ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
   	    AccountDAO acdao=(AccountDAO) ac.getBean("AccountDAO");
   	    acdao.delete(account);
	}
}
