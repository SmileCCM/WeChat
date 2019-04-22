package com.ssh.util;

import java.util.HashMap;
import java.util.Map;

public class JsonResult {
    private String result;
    private Map<String, Object> map = new HashMap<String, Object>();
    
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
    public String getTest() {
		return "我是后端服务器，你连到我了~~";
	}
}
