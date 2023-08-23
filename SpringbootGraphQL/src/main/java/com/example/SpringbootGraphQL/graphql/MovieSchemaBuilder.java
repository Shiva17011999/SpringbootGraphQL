package com.example.SpringbootGraphQL.graphql;

import graphql.schema.DataFetcher;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import graphql.Scalars;
import org.springframework.stereotype.Component;
import com.example.SpringbootGraphQL.repository.MovieRepository;  // Import your MovieRepository

@Component
public class MovieSchemaBuilder {
    private final MovieRepository movieRepository;  // Inject the MovieRepository here

    public MovieSchemaBuilder(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public GraphQLSchema buildSchema() {
        // Define GraphQL type for movies
        GraphQLObjectType movieType = GraphQLObjectType.newObject()
                .name("Movie")
                .field(field -> field.name("title").type(Scalars.GraphQLString))
                .field(field -> field.name("releaseYear").type(Scalars.GraphQLInt))
                .field(field -> field.name("genre").type(Scalars.GraphQLString))
                .field(field -> field.name("director").type(Scalars.GraphQLString))
                .build();

        // Build GraphQL schema
        return GraphQLSchema.newSchema()
                .query(GraphQLObjectType.newObject()
                        .name("Query")
                        .field(field -> field
                                .name("movie")
                                .type(movieType)
                                .argument(arg -> arg
                                        .name("title")
                                        .type(Scalars.GraphQLString))
                                .dataFetcher(fetchMovieByTitle())))
                .build();
    }

    private DataFetcher fetchMovieByTitle() {
        return environment -> {
            String movieTitle = environment.getArgument("title");
            // Fetch movie by title from MovieRepository
            // Replace the following line with actual logic
            // For example: return movieRepository.findByTitle(movieTitle);
            return null; // Return the fetched movie or null
        };
    }
}