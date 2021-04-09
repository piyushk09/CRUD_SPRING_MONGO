package com.practice.springJPAMongo.configuration;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Rule;
import org.springframework.restdocs.JUnitRestDocumentation;

//import static org.springframework.restdocs.restdocs..documentationConfiguration;

public class Documentation {

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");

    protected RequestSpecification requestSpecification;

//    @Before
//    public void setup()
//    {
//        this.requestSpecification = new RequestSpecBuilder().
//                addFilter(documentationConfiguration(this.restDocumentation)).build();
//    }

    
}
