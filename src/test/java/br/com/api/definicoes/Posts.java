package br.com.api.definicoes;

import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import br.com.api.base.BaseTestes;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


public class Posts extends BaseTestes {
	
	String endPoint = "/posts";
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	
	@Dado("que acesso post")
	public void que_acesso_post() {
		response = request.when().get(APP_BASE_URL + endPoint + "/1");
		}

	@Quando("tem retorno {int}")
	public void tem_retorno(Integer statusCode) {
		json = response.then().statusCode(statusCode);

	}

	@Entao("entao retorno ?")
	public void entao_retorno() {
		
		
	}

	@Entao("entao retorno ?")
	public void a_descricao(Map<String,String> responseFields){
		for (Map.Entry<String, String> field : responseFields.entrySet()) {
			if(StringUtils.isNumeric(field.getValue())){
				json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
			}
			else{
				json.body(field.getKey(), equalTo(field.getValue()));
			}
		}
	}
}
