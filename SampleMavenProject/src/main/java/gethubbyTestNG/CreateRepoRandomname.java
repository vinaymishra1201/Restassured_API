package gethubbyTestNG;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CreateRepoRandomname {
public static void main(String[] args) {
	RestAssured.baseURI="https://api.github.com";
	Random Randomenum=new Random();
	int min=1;
	int max=1000;
	 String Randomename="MyRepo"+Randomenum.nextInt();
	System.out.println(Randomename);
	Response response=given().header("Content-Type","application/json")
	.body("{\r\n"
			+ "    \"name\": \""+Randomename+"\",\r\n"
			+ "    \"discription\":\"Haii this side vinay mishra\"\r\n"
			+ "}")
	.header("Authorization"," Bearer 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")
	.when().post("/user/repos");
	//.then().log().all().statusCode(201).header("Server", "GitHub.com");
	//System.out.println(response.getHeaders());
	System.out.println("Content type is "+response.header("Content-Type"));
	//System.out.println("Response time is "+response.getTime());
	System.out.println("Responce time is "+response.getTimeIn(TimeUnit.MILLISECONDS));
	
}
}
