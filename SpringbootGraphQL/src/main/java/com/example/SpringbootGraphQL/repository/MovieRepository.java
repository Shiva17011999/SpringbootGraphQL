package com.example.SpringbootGraphQL.repository;

import com.example.SpringbootGraphQL.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    // You can add custom query methods here if needed
}
