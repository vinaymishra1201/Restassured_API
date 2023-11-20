package gethubbyTestNG;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateTestng {
	@Test(dataProvider ="Repodata")
	public void Repo(String Reponame) {
		RestAssured.baseURI ="https://api.github.com";
		given().header("Content-Type","application/json")
		.header("Authorization","Bearer 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")
		.body("{\r\n"
				+ "    \"name\": \""+Reponame+"\",\r\n"
				+ "    \"discription\":\"Haii this side vinay mishra\"\r\n"
				+ "}")
		.when().post("user/repos")
		.then().log().all().assertThat().statusCode(201);
	}
@DataProvider(name="Repodata")
public Object [][] Data()
{
	return new Object[][] {{"Repo1"},{"Repo2"},{"Repo3"}};
}

}
