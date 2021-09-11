package com.precisely.api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.stream.Collectors;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class EmailVerificationSample {

	// FIXME Assign your API Key here
	private static String API_KEY = "";

	// FIXME Assign your Secret here
	private static String SECRET = "";

	private static String OAUTH2_TOKEN_URL = "https://api.precisely.com/oauth/token";

	private static String PRECISELY_API_URL = "https://api.precisely.com/";

	private static final String ACCESS_TOKEN = "1ozoaNE7Wh4h0rKkD1DJomXIqNnH";

	private static final String BEARER = "Bearer ";

	private static final String BASIC = "Basic ";

	private static final String CLIENT_CREDENTIALS = "client_credentials";

	private static final String GRANT_TYPE = "grant_type";

	private static final String AUTH_HEADER = "Authorization";

	private static final String COLON = ":";

	private static final String CURRENT_DIRECTORY = "user.dir";

	private static final String EMAIL_REQUEST_SRC = getFileSeparator() + "emailVerificationRequest.json";

	private static String accessToken;

	public static void main(String[] args) {
		acquireAuthToken();

		validateEmailAddress();
	}

	private static void validateEmailAddress() {
		String apiUrl = "/emailverification/v1/validateemailaddress/results.json";
		try {
			processPOSTRequest(buildRequest(EMAIL_REQUEST_SRC), apiUrl);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static Entity<String> buildRequest(String emailRequestSrc) throws IOException {
		String currentDir = System.getProperty(CURRENT_DIRECTORY);
		BufferedReader reader = new BufferedReader(new FileReader(currentDir + emailRequestSrc));
		String jsonRequest = null;

		try {

			jsonRequest = reader.lines().collect(Collectors.joining());

			Entity<String> paramEntity = Entity.entity(jsonRequest, MediaType.APPLICATION_JSON_TYPE);

			return paramEntity;
		} finally {
			reader.close();
		}
	}

	private static void processPOSTRequest(Entity<?> paramEntity, String apiUrl) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(PRECISELY_API_URL + apiUrl);
		Builder builder = target.request(MediaType.APPLICATION_JSON).header(AUTH_HEADER, accessToken);

		System.out.println(builder.post(paramEntity, String.class));

	}

	/**
	 * Acquires OAuth2 token for accessing APIs
	 */
	private static void acquireAuthToken() {
		String authHeader = BASIC
				+ Base64.getEncoder().encodeToString((API_KEY + COLON + SECRET).getBytes(StandardCharsets.UTF_8));

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(OAUTH2_TOKEN_URL);

		Builder builder = target.request().header(AUTH_HEADER, authHeader);
		Form form = new Form();
		form.param(GRANT_TYPE, CLIENT_CREDENTIALS);
		Response response = builder.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED));
		String jsonResponse = response.readEntity(String.class);

		JsonReader jsonReader = Json.createReader(new StringReader(jsonResponse));
		JsonObject jsonObject = jsonReader.readObject();
		jsonReader.close();
		accessToken = jsonObject.getString(ACCESS_TOKEN);
		accessToken = BEARER + accessToken;
	}

	private static String getFileSeparator() {
		StringBuilder pathBuilder = new StringBuilder();
		pathBuilder.append(File.separator).append("src").append(File.separator).append("main").append(File.separator)
				.append("resources").append(File.separator);
		return pathBuilder.toString();
	}
}
