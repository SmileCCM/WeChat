package com.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.components.Else;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssh.action.AccountAction;
import com.ssh.action.LoginAction;
import com.ssh.dao.AccountDAO;
import com.ssh.dao.BillsDAO;
import com.ssh.dao.ViewUserSumDAO;
import com.ssh.entity.Account;
import com.ssh.entity.Bills;
import com.ssh.entity.Users;
import com.ssh.entity.ViewUserSum;
import com.ssh.service.BillsService;
import com.ssh.service.UserAccountService;
import com.ssh.service.UserInfoService;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根
		String openid = "ojpUv5WynA9EKtU3c-ZYaJ4ibIJU";
		LoginAction login = new LoginAction();
		// login.setCode("011RyvIC1mURF406FbLC1xbNIC1RyvIe");
		// String
		// string="{\"session_key\":\"OrjuMePMsnRssF8WevltBw==\",\"openid\":\"ojpUv5WynA9EKtU3c-ZYaJ4ibIJU\"}";
		// //String re=login.getOpenID();
		// String s[]=string.split("\"");
		// System.out.println(s[1]);
		// for (int i = 0; i < s.length; i++) {
		// System.out.println(s[i]);
		// }

		// Users users=new Users();
		// users.setOpenid("ojpUv5WynA9EKtU3c-ZYaJ4ibIJU");
		// users.setGender(2);
		// UserInfoService infoService=new UserInfoService();
		// login.setUser(users);
		// UserAccountService account=new UserAccountService();
		// List<Account> accounts=account.getAccounts(openid);
		// int sum=0;
		// for (int i = 0; i < accounts.size(); i++) {
		// System.out.println(accounts.get(i).getAid()+"
		// "+accounts.get(i).getAname()+" "+accounts.get(i).getRest()+"
		// "+accounts.get(i).getUsers().getOpenid());
		// sum=sum+accounts.get(i).getRest();
		// }
		// System.out.println("总资产："+sum);
		// infoService.userInfo(users);
		// AccountAction action=new AccountAction();
		// action.setOpenid(openid);
		// System.out.println(action.togetAccount());
		// List<Account> list=(List<Account>) action.getMap().get("accounts");
		// System.out.println(list.get(0).getUsers().getNickname());
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		AccountDAO dao = (AccountDAO) ac.getBean("AccountDAO");
		// Users user=new Users();
		// user.setOpenid(openid);
		// Account account=new Account();
		// account.setAid(11);
		// account.setAname("工商2593");
		// account.setUsers(user);
		// account.setRest(0);
		// //dao.save(account);
		// UserAccountService service=new UserAccountService();
		// service.updateacc(account);
		// System.out.println(service.addaccount(account));
		//
		// ViewUserSumDAO dao2=(ViewUserSumDAO) ac.getBean("ViewUserSumDAO");
		//
		// ViewUserSum s=new ViewUserSum();
		// s.setOpenid(openid);
		// s.setDate("2019-04");
		// BillsDAO dao3=(BillsDAO) ac.getBean("BillsDAO");
		// List<ViewUserSum> ss=new ArrayList<ViewUserSum>();
		// ss=dao2.findByExample(s);
		// BillsService service=new BillsService();
		// List<Bills> bs=new ArrayList<Bills>();
		// bs=service.findbills(openid, "2019-03");
		// System.out.println(ss.size());
		// for (int i = 0; i < ss.size(); i++) {
		// System.out.print(ss.get(i).getOpenid()+" ");
		// System.out.print(ss.get(i).getDate()+" ");
		// System.out.print(ss.get(i).getLx()+" ");
		// System.out.println(ss.get(i).getSum());
		// }
		// System.out.println(bs.size());
		// for (int i = 0; i < bs.size(); i++) {
		// System.out.print(bs.get(i).getAcct()+" ");
		// System.out.print(bs.get(i).getClass_()+" ");
		// System.out.print(bs.get(i).getLx()+" ");
		// System.out.print(bs.get(i).getMoney()+" ");
		// System.out.println(bs.get(i).getBilldate());
		// }
		Double min = null, max = null;
		String classes = null, seek = null;
		if (min != null && max != null) {
			if (min > max) {
				Double temp = null;
				temp = min;
				min = max;
				max = temp;
			}
		}

		System.out.println("min:" + min + ";max:" + max);
		// String hql1="SELECT * from bills where ";
		// if (min!=null&&max!=null) {
		// hql1=hql1+"money BETWEEN "+min+" AND "+max+" AND ";
		// }
		// else if (min==null&&max!=null) {
		// hql1=hql1+"money <= "+max+" AND ";
		// }
		// else if (min!=null&&max==null) {
		// hql1=hql1+"money >= "+min+" AND ";
		// }
		// if (classes!=null) {
		// hql1=hql1+"class=\""+classes+"\" AND ";
		// }
		// if (seek!=null) {
		// hql1=hql1+"remark LIKE '%"+seek+"%' AND ";
		// }
		// hql1=hql1+"openid='"+openid+"' ORDER BY billdate DESC";
		BillsDAO dao2 = (BillsDAO) ac.getBean("BillsDAO");
		List<Bills> bs = new ArrayList<Bills>();
		bs = dao2.findByItems(min, max, classes, seek, openid);

		System.out.println(bs.size());
		for (int i = 0; i < bs.size(); i++) {
			System.out.print(bs.get(i).getAcct() + " ");
			System.out.print(bs.get(i).getClass_() + " ");
			System.out.print(bs.get(i).getLx() + " ");
			System.out.print(bs.get(i).getMoney() + " ");
			System.out.print(bs.get(i).getRemark() + " ");
			System.out.println(bs.get(i).getBilldate());
		}

	}

}
