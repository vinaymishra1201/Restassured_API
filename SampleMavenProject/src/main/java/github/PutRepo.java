package github;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import files.Body;
public class PutRepo {
public static void main(String[] args) {
	
	RestAssured.baseURI="https://api.github.com";
	//String Owner ="vinaymishra1201";
//	String repo="Randam";
	given().header("Content-Type","application/json").body(Body.PutRepo())
	.header("Authorization","Bearer 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")
	.when().put("repos/vinaymishra1201/Randam")
	.then().log().all().assertThat().statusCode(200);
}
}
