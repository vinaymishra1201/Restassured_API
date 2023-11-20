package petStore;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.Body;

public class RequestChaining {

	public static void main(String[] args) {
		//CreatePet
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		String response = given().header("Content-Type","application/json").body(Body.CreatePet())
		.when().post("/pet")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(response);
		
		JsonPath ref=new JsonPath(response); //used to convert to JSON
		Object petId = ref.get("id");
		System.out.println(petId);
		//String name = ref.getString("name");
		//System.out.println(name);
		//String Name1=ref.getString("category.name");
		//System.out.println(Name1);
		
		
		//UpdatePet
		String newName="Scooby";
		given().header("Content-Type","application/json").body("{\r\n" + 
				"  \"id\":"+petId+",\r\n" + 
				"  \"category\": {\r\n" + 
				"    \"id\": 0,\r\n" + 
				"    \"name\": \"string\"\r\n" + 
				"  },\r\n" + 
				"  \"name\": \""+newName+"\",\r\n" + 
				"  \"photoUrls\": [\r\n" + 
				"    \"string\"\r\n" + 
				"  ],\r\n" + 
				"  \"tags\": [\r\n" + 
				"    {\r\n" + 
				"      \"id\": 0,\r\n" + 
				"      \"name\": \"string\"\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  \"status\": \"available\"\r\n" + 
				"}")
		.when().put("/pet")
		.then().log().all().assertThat().statusCode(200).body("name", equalTo(newName));
		
		
		
		//getPet
		String getPetResponse=when().get("/pet/"+petId+"")
			.then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(getPetResponse);
		
		JsonPath ref1=new JsonPath(getPetResponse);
		String ActualName=ref1.getString("name");
		System.out.println(ActualName);
		
		
	}

}