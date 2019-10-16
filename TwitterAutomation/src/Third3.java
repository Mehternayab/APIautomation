import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.util.TypeKey;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

public class Third3 {
	String ck = "2Xtd4ILUtinfACHehAvCNcbjW";
	String cs = "pIHDmJy9fgKlLVuAgG4AuP5rRkaOy6TtWqxLqjVeJ2MywdcGJp";
	String Token = "839104214-h1Kaf8iJW2FAyXzNCZNicI1a4Xb8BMw7ZkFKGzmJ";
	String TokenSecret = "PTvXawkmrK3EZWeLSSmqtD7hisogRC3nqG48FYzNcLfQy";
	@Test
	public void TestPost() {
		RestAssured.baseURI="https://api.twitter.com/1.1/search/";
		Response res = given().auth().oauth(ck, cs, Token, TokenSecret).
		queryParam("q", "#Qualitest").
		when().get("tweets.json").then().extract().response();
		String str = res.asString();
		System.out.println(str);
		//JsonPath js = new JsonPath(str);
		/*String id = js.get("id").toString();
		System.out.println(id);
		/*HashMap<String, String> name1 = js.get("statuses");
		for (String name: name1.keySet()){
	            String key = name.toString();
	            String value = name1.get(name).toString();  
	            System.out.println(key + " " + value);  
		} */
	}
}
