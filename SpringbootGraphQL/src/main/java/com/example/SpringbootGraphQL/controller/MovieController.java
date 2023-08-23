package com.example.SpringbootGraphQL.controller;

import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    private final GraphQL graphQL;

    @Autowired
    public MovieController(GraphQL graphQL) {
        this.graphQL = graphQL;
    }

    // Handle GraphQL queries
    @PostMapping("/graphql")
    public ExecutionResult executeQuery(@RequestBody String query) {
        return graphQL.execute(query);
    }
}
