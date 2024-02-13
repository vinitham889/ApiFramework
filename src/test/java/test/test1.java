package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class test1 {
	@Test
	public void t1() {
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
//		response.getBody();
		//To convert json format to string
//		response.asString();
		//To get status code
//		response.getStatusCode();
		System.out.println(response.getBody());
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}

