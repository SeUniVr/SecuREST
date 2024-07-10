package ErrorFuzzer;

import static io.restassured.RestAssured.*;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.common.mapper.TypeRef;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.json.*;
import org.junit.jupiter.api.*;
//import org.junit.runners.*;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Order(2447)
public class v2Name_20230205204102380{

String baseURL ="https://restcountries.com";

	private void test0() throws JSONException{
		//OPERATION 1
		//Parameter initialization
		Object request1_path_capital = "E";
		//Build request
 		RequestSpecification request1 = RestAssured.given();
		request1.pathParam("capital" , request1_path_capital);
		//Build Response
		Response response1 = request1.when().get(baseURL+"/v2/capital/{capital}");
		String response1_response_body = response1.getBody().asString();

		Assertions.assertTrue(response1.getStatusCode()<=299,"StatusCode not 2xx for previous operation.");
		//OPERATION 0
		//Parameter initialization
		Object request0_query_fullText = "NMI";
		Object request0_path_name = JsonPath.read(response1_response_body , "$[3]['name']");
		//Build request
 		RequestSpecification request0 = RestAssured.given();
		request0.pathParam("name" , request0_path_name);
		request0.queryParam("fullText" , request0_query_fullText);
		//Build Response
		Response response0 = request0.when().get(baseURL+"/v2/name/{name}");
		String response0_response_body = response0.getBody().asString();

		Assertions.assertFalse(response0.getStatusCode()<=299,"StatusCode 2xx: The test sequence was not executed successfully.");
		Assertions.assertFalse(response0.getStatusCode()>=500,"StatusCode 5xx: The test sequence was not executed successfully.");
	}
	@Test
	public void test_v2Name_20230205204102380()  throws JSONException{
		test0();
	}
}
