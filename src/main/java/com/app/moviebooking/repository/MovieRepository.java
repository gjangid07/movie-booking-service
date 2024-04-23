package com.app.moviebooking.repository;

import com.app.moviebooking.model.Movie;
import com.app.moviebooking.model.MovieShow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

  List<Movie> findAll();
}
