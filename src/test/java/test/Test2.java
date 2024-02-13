package test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Test2 {
	@Test
	public void tc1() {
		//get request
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200)
		.body("data.id[0]", equalTo(7)).log().all();
		//log().all() used to get data on console 
		//Creating object for JSONObject to convert string to json(to send some parameters)
		JSONObject js = new JSONObject();
		
		//post request
		js.put("name", "morpheus");
		js.put("job", "zion resident");
		
		given().
		body(js).
		when().
		post("https://reqres.in/api/users").
		then().
		statusCode(201).log().all();
		 
		//put request
		js.put("name", "Vinitha");
		js.put("job", "SDET");
		given().
		body(js).
		when().
		put("https://reqres.in/api/users/2").
		then().
		statusCode(200).log().all();
		
		//delete request
		when().
		delete("https://reqres.in/api/users/2").
		then().
		statusCode(204).log().all();
		
		
		
		
		
	}

}
