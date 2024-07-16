package com.example.JavaOngageAPI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class JavaOngageApiApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(JavaOngageApiApplication.class);

    private final PutMethod putMethod;
    private final PostMethod postMethod;

    @Autowired
    public JavaOngageApiApplication(PutMethod putMethod, PostMethod postMethod) {
        this.putMethod = putMethod;
        this.postMethod = postMethod;
    }

    public static void main(String[] args) {
        SpringApplication.run(JavaOngageApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            put();
            post();
        } catch (Exception e) {
            logger.error("Error occurred during application run", e);
            throw e;
        }
    }

    public void put() throws Exception {
        HashMap<String, Object> payload = new HashMap<>();
        payload.put("email", "ronakdoshi+100@bidgely.com");

        try {
            putMethod.callForSingleUser(payload);
            logger.info("PUT operation completed successfully");
        } catch (Exception e) {
            logger.error("Error occurred during PUT operation", e);
            throw new RuntimeException("Error occurred during PUT operation", e);
        }
    }

    public void post() throws Exception {
        try {
            postMethod.callForMultipleUser();
            logger.info("POST operation completed successfully");
        } catch (Exception e) {
            logger.error("Error occurred during POST operation", e);
            throw new RuntimeException("Error occurred during POST operation", e);
        }
    }
}
