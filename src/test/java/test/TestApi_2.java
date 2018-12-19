package test;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TestApi_2 {

	@Test
	public void test_response() {

		/*
		 * Scenario: Valid search request Given a search for "blue jeans" And store as 1
		 * And lang as en-GB And currency as EUR When the response is received Then
		 * status code 200 OK should be returend
		 */
		given().headers("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:64.0) Gecko/20100101 Firefox/64.0")
				.accept(ContentType.JSON)
				.param("q", "blue jeans")
				.param("store", "1")
				.param("lang", "en-GB")
				.param("currency", "EUR")
				.when()
				.get("http://searchapi.asos.com/product/search/v1")
				.then().statusCode(200).log().all();

	}
}