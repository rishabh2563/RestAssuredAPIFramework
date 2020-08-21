package stepDefination;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeScenarios() throws IOException {
		//code should work only when placeid is null
		//write code to get placeid
		StepDefination sd= new StepDefination();
		if(StepDefination.place_id==null) {
		sd.add_Place_Payload("Rishabh","World Centre","English");
		sd.user_calls_using_Http_Request("AddPlaceAPI","POST");
		sd.verify_place_ID_created_maps_to_using("Rishabh","GetPlaceAPI");
	}
	}
}
