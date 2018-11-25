package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	Properties props=null;
	FileInputStream inputstream=new FileInputStream(System.getProperty("user.dir")+"//config.properties");
	
	public ReadPropertyFile() throws IOException {
		
		props=new Properties();
		props.load(inputstream);
		
	}
	
	public String getURL()
	{
		return props.getProperty("url");
	}
	
	public String getPincode()
	{
		return props.getProperty("pincode");
	}
}
