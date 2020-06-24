package com.echi.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * @Author: ChengXiaoXiao
 * @Date: 2020/6/24 14:50
 */
public class PropertyManager {

	private static volatile PropertyManager propertyManager;

	private static Properties properties = new Properties();

	static {
		try {
			properties.load(PropertyManager.class.getClassLoader().getResourceAsStream("cfg/config.properties"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private PropertyManager(){}

	public static PropertyManager instance(){

		if (propertyManager == null){
			synchronized (PropertyManager.class){
				if (propertyManager == null){
					propertyManager = new PropertyManager();
				}
			}
		}
		return propertyManager;
	}

	public static String get(String key){
		if (properties == null){
			return null;
		}
		return String.valueOf(properties.getProperty(key));
	}

	public static void main(String[] args) {
		System.out.println(PropertyManager.get("initTankCount"));
	}
}
