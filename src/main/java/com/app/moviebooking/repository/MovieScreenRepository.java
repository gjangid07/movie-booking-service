package com.app.moviebooking.repository;

import com.app.moviebooking.model.MovieScreen;
import com.app.moviebooking.model.Theatre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieScreenRepository extends JpaRepository<MovieScreen, Long> {

  List<MovieScreen> findAllByTheatreId(Long theatreId);
}
