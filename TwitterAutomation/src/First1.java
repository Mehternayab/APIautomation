import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class First1 {
	String ck = "2Xtd4ILUtinfACHehAvCNcbjW";
	String cs = "pIHDmJy9fgKlLVuAgG4AuP5rRkaOy6TtWqxLqjVeJ2MywdcGJp";
	String Token = "839104214-h1Kaf8iJW2FAyXzNCZNicI1a4Xb8BMw7ZkFKGzmJ";
	String TokenSecret = "PTvXawkmrK3EZWeLSSmqtD7hisogRC3nqG48FYzNcLfQy";
	@Test
	public void TestPost() {
		RestAssured.baseURI="https://api.twitter.com/1.1/statuses/";
		Response res = given().auth().oauth(ck, cs, Token, TokenSecret).
		when().get("home_timeline.json").then().extract().response();
		String str = res.asString();
		System.out.println(str);
		JsonPath js = new JsonPath(str);
		String id = js.get("id").toString();
		System.out.println(id);
		String name = js.get("text").toString();
		System.out.println(name);
	}

}
