package com.hlb.base.core.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * 
 * <pre> 
 * 描述：配置对象工具类
 * 构建组：base-core
 * 作者：weekend
 * 邮箱:  38051676@qq.com
 * 日期:2016-8-16 下午13:47:10
 * 版权：kiso
 * </pre>
 */
public class PropertiesUtil {
	
	/**
	 * 根据路径读取配置对象
	 * @param path
	 * @return 
	 * Properties
	 * @exception 
	 * @since  1.0.0
	 */
	public static Properties loadProperties(String path){
		Properties properties = null;
		InputStream is = null;
		BufferedReader bReader = null;
		try {
			properties = new Properties();
			is = new FileInputStream(path);
			bReader = new BufferedReader(new  InputStreamReader(is,"utf-8"));
			properties.load(bReader);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bReader.close();
				is.close();
			} catch (Exception e) {
			}
		}	
		return properties;
	}
	
	/**
	 * 将源配置对象的值集合合并到目标配置对象中
	 * @param srcProperties
	 * @param destProperties 
	 * void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void mergeTo(Properties srcProperties,Properties destProperties){
		for(Iterator<Map.Entry<Object,Object>> iterator = srcProperties.entrySet().iterator();iterator.hasNext();){
			Map.Entry<Object, Object> entry = iterator.next();
			destProperties.put(entry.getKey(), entry.getValue());
		}
	}
}
