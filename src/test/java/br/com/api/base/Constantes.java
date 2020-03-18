package br.com.api.base;

import io.restassured.http.ContentType;

public interface Constantes {
	
	String APP_BASE_URL = "https://jsonplaceholder.typicode.com";
	Integer APP_PORT = 443; // http -> use port 80
	String APP_BASE_PATH = "";
	String APP_PROXY = "http://192.168.50.178:80";

	
	ContentType APP_CONTENT_TYPE = ContentType.JSON;
	
	Long MAX_TIMEOUT = 7000L;
}
