package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
	HttpClient client = HttpClient.newHttpClient();
	HttpRequest request = HttpRequest.newBuilder()
							.uri(URI.create("http://jsonplaceholder.typicode.com/posts/1"))
							.build();

	// Send request
	HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

	// Parse JSON response
	ObjectMapper mapper = new ObjectMapper();
	Post post = mapper.readValue(response.body(), Post.class);

	// Print parsed data
	System.out.println(post);
    }
}
