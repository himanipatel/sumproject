package com.comcast.sumproject.util;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * ConfigPropertyManager to access properties programmatically
 * 
 * @author Himani Patel
 *
 */
public class ConfigPropertyManager {

	//private static Logger logger = LoggerFactory.getLogger(ConfigPropertyManager.class);
	private static volatile ConfigPropertyManager self = null;
	private static Properties properties = new Properties();

	private ConfigPropertyManager() {
	}

	private void loadProperties() {

		Resource resource = new ClassPathResource("config/config.properties");
		try {
			properties = PropertiesLoaderUtils.loadProperties(resource);
		} catch (IOException e) {
			//logger.error("Exception loading properties file ", properties);
		}
	}

	public static ConfigPropertyManager getInstance() {
		if (self == null) {
			synchronized (ConfigPropertyManager.class) {
				if (self == null) {
					self = new ConfigPropertyManager();
					self.loadProperties();
				}
			}
		}
		return self;
	}

	public Properties getProperties() {
		return properties;
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}
}
