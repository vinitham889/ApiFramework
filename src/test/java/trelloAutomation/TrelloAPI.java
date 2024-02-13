package trelloAutomation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBodyData;

public class TrelloAPI {
	
	public String baseURL ="https://api.trello.com/";
	public String id;
	@Test(priority =0)
	public void createBoard() {
		Response res =given().header("Content-Type","application/json")
				
		.queryParam("name", "Vinitha")
		.queryParam("key", "3fb45a370f39c5a0a1c5a659ef4273ff")
		.queryParam("token", "ATTA0532a2fec9da671e2ce3ed0608d48b940980cf2b32f2372664a903a5469560df08688E1A")
		.when()
		.post("https://api.trello.com/1/boards/")
		.then()
		.statusCode(200)
		.extract()
		.response();
		System.out.println(res.asPrettyString());
		JsonPath jp = new JsonPath(res.asString());
		 id = jp.get("id");
		System.out.println(id);
		
		}
	@Test(priority =1)
	public void getBoardId() {
		given()
		.queryParam("key","3fb45a370f39c5a0a1c5a659ef4273ff")
		.queryParam("token","ATTA0532a2fec9da671e2ce3ed0608d48b940980cf2b32f2372664a903a5469560df08688E1A")
		.header("Accept","application/json")
		.when()
		.get("https://api.trello.com/1/boards/"+id)
		.then()
		.statusCode(200);
	}
	@Test(priority =2)
	public void putRequest()
	{
		Response res =given()
				
		.queryParam("key","3fb45a370f39c5a0a1c5a659ef4273ff")
		.queryParam("token","ATTA0532a2fec9da671e2ce3ed0608d48b940980cf2b32f2372664a903a5469560df08688E1A")
		.when()
		.put("https://api.trello.com/1/boards/"+id)
		.then()
		.statusCode(200).extract().response();
		System.out.println(res.getBody());
		
	}
	@Test(priority=3)
	public void deleteRequest()
	{
		given()
		.queryParam("key","3fb45a370f39c5a0a1c5a659ef4273ff")
		.queryParam("token","ATTA0532a2fec9da671e2ce3ed0608d48b940980cf2b32f2372664a903a5469560df08688E1A")
		.when()
		.delete("https://api.trello.com/1/boards/"+id)
		.then()
		.statusCode(200);
	}

}
