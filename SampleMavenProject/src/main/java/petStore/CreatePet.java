package petStore;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import files.Body;

public class CreatePet {
public static void main(String[] args) {
	RestAssured.baseURI="https://petstore.swagger.io/v2";
	given().header("Content-Type","application/json")
	.body(Body.CreatePet())
	.when().post("/pet")
	.then().log().all().assertThat().statusCode(200);
}
}
