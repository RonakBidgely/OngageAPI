package com.example.JavaOngageAPI;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.HashMap;

public class PutMethod {

    String name = Properties.getName();
    String password = Properties.getPassword();
    String accountCode = Properties.getAccountCode();

    public static String call(HashMap<String,Object> payload) throws Exception{

        User user = new User(payload);

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(user);
    }

    public void callForSingleUser(HashMap<String, Object> payload) throws Exception {

        String requestBody = call(payload);

        HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .uri(URI.create("https://api.ongage.net/163008/api/v2/contacts/"))
                .header("Content-Type", "application/json")
                .header("X_USERNAME",name)
                .header("X_PASSWORD",password)
                .header("X_ACCOUNT_CODE",accountCode)
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

    public void callForMultipleUser() throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.ofFile(Path.of("/Users/Doshironakatul/Downloads/JavaOngageAPI/input.json")))
                .uri(URI.create("https://api.ongage.net/163008/api/v2/contacts/"))
                .header("Content-Type", "application/json")
                .header("X_USERNAME",name)
                .header("X_PASSWORD",password)
                .header("X_ACCOUNT_CODE",accountCode)
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());
    }



}
