package com.hlb.app.core.framework.helper;

import java.util.Properties;

import org.springframework.stereotype.Service;

import com.hlb.base.core.helper.SpringHelper;
@Service
public class ConfigHelper implements IConfigHelper{

	private Properties properties = null;   

	public static ConfigHelper getInstance() {
		ConfigHelper configHelper = SpringHelper.getBean(ConfigHelper.class);
		return configHelper;
	}
	
	public void init(){
		properties = new Properties();
	    	try {
	    		properties.load(ConfigHelper.class.getClassLoader().getResourceAsStream("config/app-web.properties"));
	    		/*Properties baseDbProperties = new Properties();
	    		baseDbProperties.load(ConfigHelper.class.getClassLoader().getResourceAsStream("config/base-db.properties"));
	    		PropertiesUtil.mergeTo(baseDbProperties,properties);*/
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public String getParamValue(String paramName){
		if(properties==null){
			init();
		}
		if(properties!=null){
			return properties.getProperty(paramName);
		}
		return "";
	}
	
	
}
