package WebHandling;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;


public class PropertiesHandling {

	public static String value;

	public static String getProperty(String key) {
		try {
			Constant.file = new FileInputStream("D:\\Swapnali\\Eclips_Program_RestAPI\\Shutterfly\\Inpute");
			Constant.prop = new Properties();
			Constant.prop.load(Constant.file);
			value = Constant.prop.getProperty(key);
		} catch (IOException e) {
			System.out.println("unable to open object repository");
			e.printStackTrace();
		}
		return value;
	}

	public static String getProperty(String key, String filepath) {
		String value = null;
		try {
			Constant.file = new FileInputStream(filepath);
			Constant.prop = new Properties();
			Constant.prop.load(Constant.file);
			value = Constant.prop.getProperty(filepath);
		} catch (IOException e) {	
			System.out.println(filepath +filepath+"file not found ");
			e.printStackTrace();
			System.out.println("unable to load file " + filepath);
		
		}
		return null;
	}
	
	public static String[] getLocator(String key) throws IOException{
		String[] values = null;
		try {
			Constant.file = new FileInputStream("D:\\Swapnali\\Eclips_Program_RestAPI\\Shutterfly\\Inpute");
			Constant.prop = new Properties();
			Constant.prop.load(Constant.file);

			String part = Constant.prop.getProperty(key);
			
			values= part.split("##");
			System.out.println("locatorType " + values[0]);
			System.out.println("locatorValue " + values[1]);
		} catch (IOException e) {
			System.out.println("unable to open object repository ");
			e.printStackTrace();
		}
		return values;
		
	

		

	}
	
	
}
	
	

