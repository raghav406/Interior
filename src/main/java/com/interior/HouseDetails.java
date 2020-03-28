package com.interior;

import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicLong;

import com.library.Greeting;
import com.mongodb.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HouseDetails {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        Greeting greeting = null;
        try {
            greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
      /*      MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            DB database = mongoClient.getDB("TheDatabaseName");
            DBCollection collection = database.getCollection("TheCollectionName");
            collection.insert(new BasicDBObject("_id", greeting.getId()).append("content", greeting.getContent()));
*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return greeting;
    }
}
