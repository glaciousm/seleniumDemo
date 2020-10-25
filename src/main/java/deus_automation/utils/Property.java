package deus_automation.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class Property {
	String propFileName = "config.properties";
	public String fastqFileName = "AutomationSample01_R1.fastq";

	public String get(String key) throws FileNotFoundException {
		String property = "";

		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try (InputStream input = loader.getResourceAsStream(propFileName)) {

			Properties prop = new Properties();

			if (input == null) {
				System.out.println("Unable to find config.properties");
				return "";
			}

			prop.load(input);

			property = prop.getProperty(key);

		} catch (IOException ex) {
			throw new FileNotFoundException(
					"property file '" + propFileName + "' not found in the classpath with error " + ex);
		}

		return property;

	}

	public String getFileLocation() {
        URL resource = getClass().getClassLoader().getResource(fastqFileName);
		return resource.getPath().replace("/C:", "C:");
	}

	public String url() {
		String url = "";
		try {
			url = get("url");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return url;
	}

	public String username() {
		String username = "";
		try {
			username = get("username1");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return username;
	}

	public String password() {
		String password = "";
		try {
			password = get("password1");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return password;
	}

}
