package test;
import org.testng.annotations.Test;
import data.SearchProduct;
import data.search_dp;

import static io.restassured.RestAssured.*;

public class TestApi_1 {
	private static final String baseURL = "http://searchapi.asos.com/product/search/v1";
	public final static int Ok=200;
	@Test(priority = 1,dataProviderClass=search_dp.class,dataProvider="testsearch_dp")
	public void testSearchProduct(SearchProduct product) {
		System.out.println("Scenario 1 Started : Search city");

		given()
			.headers("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:64.0) Gecko/20100101 Firefox/64.0")
			.when()
			.get(baseURL + "?q=" + product.getProduct() + "&store=" + product.getstore() + "&lang=" + product.getlang() + "&currency=" + product.getcurrency())
			.then()
			.statusCode(200).log().all();
	}
}