package Resource;

//Enum is a special class in Java which consists of a collection of method or constants 
public enum APIResources {

	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");
	private String resource;
	 APIResources(String resource) //constructor it can be invokes by valueof() method
	{
		this.resource=resource;
		
	}
	public String getResource() {
		return resource;
	}

}
