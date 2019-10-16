import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Hashtags {
	int[] a = {1,2295383,28218,23424977,23424852};
	String ck = "2Xtd4ILUtinfACHehAvCNcbjW";
	String cs = "pIHDmJy9fgKlLVuAgG4AuP5rRkaOy6TtWqxLqjVeJ2MywdcGJp";
	String Token = "839104214-h1Kaf8iJW2FAyXzNCZNicI1a4Xb8BMw7ZkFKGzmJ";
	String TokenSecret = "PTvXawkmrK3EZWeLSSmqtD7hisogRC3nqG48FYzNcLfQy";
	@Test
	public void Trends() {
		for(int i=0 ; i < a.length ; i++) {
		RestAssured.baseURI="https://api.twitter.com/1.1/trends/";
		Response res = given().auth().oauth(ck, cs, Token, TokenSecret).queryParam("id", a[i]).
		when().get("place.json").then().extract().response();
		String str = res.asString();
		System.out.println(str);
		JsonPath js = new JsonPath(str);
		String text = js.get("name").toString();
		System.out.println(text);
		}
	}
}
