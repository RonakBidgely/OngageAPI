package com.example.JavaOngageAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.util.HashMap;

@SpringBootApplication
public class JavaOngageApiApplication  {

	public static void main(String[] args) {
		SpringApplication.run(JavaOngageApiApplication.class, args);
        PutMethod a = new PutMethod();
        HashMap<String,Object> payload = new HashMap<>();
        payload.put("email","ronakdoshi+100@bidgely.com");
        try {
            a.callForMultipleUser();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
