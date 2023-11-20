package gethubbyTestNG;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;
public class Channing {
@Test
public void open()
{
	RestAssured.baseURI="https://api.github.com";
	Random Randomenum=new Random();
	int min=1;
	int max=100;
	String Randomename="MyRepo"+Randomenum.nextInt();
	System.out.println(Randomename);
	given().header("Content-Type","application/json")
	.body("{\r\n"
			+ "    \"name\": \""+Randomename+"\",\r\n"
			+ "    \"discription\":\"Haii this side vinay mishra\"\r\n"
			+ "}")
	.header("Authorization"," Bearer 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")
	.when().post("/user/repos")
	.then().log().all().statusCode(201).header("Server", "GitHub.com");
	//UpdateRepo
	String Owner="vinaymishra1201";
	//String Repo="MyRepo";
	given().header("Content-type","application/json")
	.header("Authorization"," Bearer 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")
	.body("{\r\n"
			+ "   \r\n"
			+ "    \"discription\":\"Updated the repo\"\r\n"
			+ "}")
	.when().patch("/repos/"+Owner+"/"+Randomename+"")
	.then().log().all().assertThat().statusCode(200);
	//delete repos
	//String Ownerr="vinaymishra1201";
	given().header("Content-Type","application/json")
	
	.header("Authorization","Bearer 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")
	.when().delete("repos/"+Owner+"/"+Randomename+"")
	.then().log().all().assertThat().statusCode(204);
	//GetREPO
	given().header("Content -Type","application/json")
	.header("Autherization","application/json")
	.when().get("/repos/"+Owner+"/"+Randomename+"")
	.then().log().all().statusCode(400);
}
}
