package com.ssh.action;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.entity.Users;
import com.ssh.service.UserInfoService;

import javassist.compiler.ast.NewExpr;


public class LoginAction extends ActionSupport implements RequestAware,SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//wxd2dfb5e967c3d332我的appid;53079198543b52b87e55dc3d33d775bc我的appsecret
	private final String appID="wxd2dfb5e967c3d332";
	private final String appSecret="53079198543b52b87e55dc3d33d775bc";
	private String code;
	private String result;
	private Map<String, Object> map;

	private UserInfoService userInfoService= new UserInfoService();	
	private String openid;
	private String nickname;
	private Integer gender;
	private String province;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAppID() {
		return appID;
	}

	public String getAppSecret() {
		return appSecret;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Override
	public String execute() throws Exception {
		return null;
	}

	public String getOpenID() throws Exception {

		System.out.println("this is getOpenID'action,code:"+getCode());
		String url="https://api.weixin.qq.com/sns/jscode2session?appid="+getAppID()+"&secret="+getAppSecret()+"&js_code="+getCode()+"&grant_type=authorization_code";
		URL reqUrl=new URL(url);
		HttpURLConnection openConnection=(HttpURLConnection) reqUrl.openConnection();
		openConnection.setConnectTimeout(10000);
		openConnection.connect();
		
	    InputStream in=openConnection.getInputStream();
	    StringBuilder builder=new StringBuilder();
	    BufferedReader bufreader=new BufferedReader(new InputStreamReader(in));
	    
	    for (String temp = bufreader.readLine(); temp!=null; temp=bufreader.readLine()) {
			builder.append(temp);		
		}	    
	    setResult(builder.toString());
	    System.out.println("getOpenID's RESULT:"+getResult());
	    in.close();
	    openConnection.disconnect();
		return "success";
	}
	public String userInfoupdate() {
		Users user=new Users();
		user.setOpenid(openid);
		user.setNickname(nickname);
		user.setGender(gender);
		user.setProvince(province);
		userInfoService.userInfo(user);
		setResult("update or add user success~~~~~~~");
		System.out.println(getResult());
		return "success";
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO 自动生成的方法存根
		
	}

}
