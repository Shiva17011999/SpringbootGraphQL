package com.example.SpringbootGraphQL;

import com.example.SpringbootGraphQL.graphql.MovieSchemaBuilder;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootGraphQlApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringbootGraphQlApplication.class, args);
	}

	@Autowired
	private MovieSchemaBuilder schemaBuilder;

	@Bean
	public GraphQL graphQL() {
		GraphQLSchema schema = schemaBuilder.buildSchema();
		return GraphQL.newGraphQL(schema).build();
	}

}
