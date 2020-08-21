package Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utility {
	public static RequestSpecification req;
	public RequestSpecification requestSpecification() throws IOException 
	{
		if(req==null)// done so that it runs for each dataset in parametized condition inorder top print log for each dataset
		{
		PrintStream log =new PrintStream(new File("logging.txt"));
	             req=new RequestSpecBuilder().setBaseUri(globalPropertyvalue("baseUrl"))
	                    .addQueryParam("key", "qaclick123")
	                    .addFilter(RequestLoggingFilter.logRequestTo(log))//code for printing logs which accepts print stream obj in args
	                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
	                    .setContentType(ContentType.JSON).build();
	             return req;
	             } 
		return req;
	}
	public static  String globalPropertyvalue(String Property) throws IOException 
	{
		Properties prop = new Properties();
		FileInputStream fis =new FileInputStream("C:\\Users\\Fleek\\eclipse-workspace\\Practice\\APIFramework\\src\\test\\java\\Resource\\GlobalProperties.properties");
		prop.load(fis);
		return prop.getProperty(Property);

	}
	public String getJsonPath(Response response,String Key) 
	{
		 String resp = response.asString();
         System.out.println(resp);
         JsonPath js=new JsonPath(resp);
         return js.get(Key).toString();
		
	}
	
}
