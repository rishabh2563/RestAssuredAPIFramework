package Resource;

import java.util.ArrayList;
import SerializationPojoClasses.AddPlace;
import SerializationPojoClasses.Location;

public class TestDataBuild {
	
	public AddPlace AddPlacePayload(String name,String address,String language) 
	{
		AddPlace ap= new AddPlace();
		Location l=new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		ArrayList<String> a = new ArrayList<String>();
		a.add("shoe park");
		a.add("shop");
		ap.setAccuracy(50);
		ap.setName(name);
		ap.setPhone_number("(+91) 983 893 3937");
		ap.setAddress(address);
		ap.setWebsite("http://google.com");
		ap.setLanguage(language);
		ap.setLocation(l);
		ap.setTypes(a);
		return ap;
	}
	
	public String DeletePlacePlayload(String placeid) {
		
		return "{\r\n\"place_id\":\""+placeid+"\"\r\n}";
	}

}
