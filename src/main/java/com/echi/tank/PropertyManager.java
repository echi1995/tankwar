package com.echi.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * @Author: ChengXiaoXiao
 * @Date: 2020/6/24 14:50
 */
public class PropertyManager {

	private static volatile Properties properties;

	private PropertyManager(){

	}

	public static String get(String key){
		if (properties == null){
			synchronized (PropertyManager.class){
				if (properties == null){
					properties = new Properties();
					try {
						properties.load(PropertyManager.class.getClassLoader().getResourceAsStream("cfg/config.properties"));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return String.valueOf(properties.getProperty(key));
	}

}
