package github;

import io.restassured.RestAssured;
import static  io.restassured.RestAssured.*;
public class GetRepo {
public static void main(String[] args) {
	RestAssured.baseURI="https://api.github.com";
	String Owner="vinaymishra1201";
	String repo="Randam";
	given().header("Authorization","Bearer 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")
	.when().get("/repos/"+Owner+"/"+repo+"")
	.then().log().all().assertThat().statusCode(200).header("server", "GitHub.com");
	
	
	
	
}
}
