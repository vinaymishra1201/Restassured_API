package github;

import io.restassured.RestAssured;
import static  io.restassured.RestAssured.*;

import files.Body;
public class CreateRepo {
public static void main(String[] args) {
	RestAssured.baseURI="https://api.github.com";
	given().header("Content-Type","application/json").body(Body.CreatePet())
	.header("Authorization","Bearer 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")
	.when().post("/user/repos")
	.then().log().all().assertThat().statusCode(201).header("server", "GitHub.com");
}
}
