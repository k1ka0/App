package br.com.api.testes;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.proxy;
import static io.restassured.RestAssured.request;
import static org.hamcrest.Matchers.*;

import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;

import br.com.api.base.BaseTestes;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;


public class TestePosts extends BaseTestes {
	
	String endPoint = "/posts";

	
	@Test
	public void SucessoSimples() {
		proxy(APP_PROXY);
		given()
		.when()
			.get(APP_BASE_URL + endPoint + "/1")
		.then()
			.assertThat()
			.statusCode(HttpStatus.SC_OK)
			.body("title", is("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
			.body("body", is("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"))
			;
	}
	
	@Test
	public void SucessoComAssert() {
		proxy(APP_PROXY);
		Response response = request(Method.GET, APP_BASE_URL + endPoint + "/1");
		Assert.assertTrue(response.getStatusCode() == HttpStatus.SC_OK);
	  Assert.assertTrue("O status deve ser 200", response.getStatusCode() == HttpStatus.SC_OK);
	  Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
		ValidatableResponse validacao = response.then();
		validacao.statusCode(HttpStatus.SC_OK);
	}

	@Test
	public void SucessoVariosComandos() {
		proxy(APP_PROXY);
		given()
		.when()
			.get(APP_BASE_URL + endPoint)
		.then()
			.assertThat()
			.body("$", hasSize(100))
			.body("userId.findAll{it == 9}.size()", is(10))
			.body("userId.findAll{it == 9 && it > 5}.size()", is(10))
			.body("findAll{it.userId <= 10 && it.userId > 9}.title", hasItems("aut amet sed","ratione ex tenetur perferendis","beatae soluta recusandae","qui qui voluptates illo iste minima","id minus libero illum nam ad officiis","quaerat velit veniam amet cupiditate aut numquam ut sequi","quas fugiat ut perspiciatis vero provident","laboriosam dolor voluptates","temporibus sit alias delectus eligendi possimus magni","at nam consequatur ea labore ea harum"))
			.body("title.collect{it.toUpperCase()}", hasItem( "AUT AMET SED"))
			.body("title.findAll{it.startsWith('aut amet sed')}.collect{it.toUpperCase()}", hasItem( "AUT AMET SED"))
			.body("title.findAll{it.startsWith('aut amet sed')}.collect{it.toUpperCase()}.toArray()", allOf(arrayContaining("AUT AMET SED"), arrayWithSize(1)))
			;
	}
	
}
