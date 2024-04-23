package com.app.moviebooking.repository;

import com.app.moviebooking.model.MovieScreen;
import com.app.moviebooking.model.MovieShow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieShowRepository extends JpaRepository<MovieShow, Long> {

  List<MovieShow> findAllByMovieScreenId(Long movieScreenId);
}
