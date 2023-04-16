package com.jstobigdata.jdk17.textblocks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.StringReader;

/**
 * https://www.oracle.com/technical-resources/articles/java/json.html
 * https://openjdk.org/jeps/378
 */
public class JsonExample {

    private String personStr = """
            {
                "name": "John Cena",
                "age": 45,
                "profession": "Wrestler"
            }
            """;

    //https://mkyong.com/java/how-to-convert-java-object-to-from-json-jackson/
    public void parseJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(personStr, Person.class);
        System.out.println(person);
    }
}

record Person(String name, int age, String profession){}