package stepDefination;
import static io.restassured.RestAssured.given;
import Resource.APIResources;
import Resource.TestDataBuild;
import Resource.Utility;
import static org.junit.Assert.*;
import java.io.IOException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class StepDefination extends Utility {
	 RequestSpecification res;
	 ResponseSpecification resspec;
	 Response response;
	 TestDataBuild data = new TestDataBuild();
	 static String place_id;
	
	 @Given("Add Place Payload {string} {string} {string}")
	 public void add_Place_Payload(String name, String address, String language) throws IOException {
	
      res=given().spec(requestSpecification()).body(data.AddPlacePayload(name,address,language));
}

	 @When("User calls {string} using {string} Http Request")
	 public void user_calls_using_Http_Request(String Resource, String httpmethod) {
	APIResources resourceapi = APIResources.valueOf(Resource);
	System.out.println(resourceapi.getResource());
	 resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	 if(httpmethod.equalsIgnoreCase("POST")) {
	 response = res.when().post(resourceapi.getResource());
	 }
	 else if(httpmethod.equalsIgnoreCase("GET")){
		 response = res.when().get(resourceapi.getResource()); 
	 }	    
}

@Then("Verifying The Staus Code as {int}")
public void verifying_The_Staus_Code_as(Integer int1) {
    // Write code here that turns the phrase above into concrete actions
	assertEquals(response.statusCode(),200);
	System.out.println(response.statusCode());
   
}

@Then("{string} in Response is {string}")
public void in_Response_is(String Key, String Value) {
   
            assertEquals(getJsonPath(response,Key),Value);       
}
@Then("verify place_ID created maps to {string} using {string}")
public void verify_place_ID_created_maps_to_using(String Expectedname, String resource) throws IOException {
    // Write code here that turns the phrase above into concrete actions
    place_id = getJsonPath(response,"place_id");
	res=given().spec(requestSpecification()).queryParam("place_id",place_id);
	user_calls_using_Http_Request(resource,"GET");
	String actualname=getJsonPath(response,"name");
	assertEquals(actualname,Expectedname);   
}
@Given("Delete Place Payload")
public void delete_Place_Payload() throws IOException {
	res=given().spec(requestSpecification()).body(data.DeletePlacePlayload(place_id));
	
}

}
