package ExcelTest;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ExcelDrivenTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,Object> jsonAsMap=new HashMap();
		jsonAsMap.put("name","Learn Appium Automation with Java");
		jsonAsMap.put("isbn","dmufhfhfj");
		jsonAsMap.put("aisle","288575");
		jsonAsMap.put("author","John foe");
		

		RestAssured.baseURI="http://216.10.245.166";
		String response=given().log().all().header("Content-Type","application/json").
		body(jsonAsMap).when()
		.post("/Library/Addbook.php").then().log().all().
		statusCode(200).extract().response().asString();
		JsonPath js1=new JsonPath(response);
		String id=js1.get("ID");
		System.out.println(id);

	}

}
