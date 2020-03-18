package br.com.api.uteis;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import br.com.api.base.BaseTestes;
import io.restassured.RestAssured;
import io.restassured.specification.FilterableRequestSpecification;

public class AuthTestes extends BaseTestes {

	@Test
	public void naoDeveAcessarSemToken() {
		FilterableRequestSpecification req = (FilterableRequestSpecification) RestAssured.requestSpecification;
		req.removeHeader("Authorization");
		
		given()
		.when()
			.get("/contas")
		.then()
			.statusCode(401)
		;
	}

}
