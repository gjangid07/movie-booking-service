package com.app.moviebooking.service;

import com.app.moviebooking.model.Movie;
import com.app.moviebooking.model.MovieScreen;
import com.app.moviebooking.model.MovieShow;
import com.app.moviebooking.model.Theatre;
import com.app.moviebooking.repository.MovieScreenRepository;
import com.app.moviebooking.repository.MovieShowRepository;
import com.app.moviebooking.repository.TheatreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TheatreService {

  @Autowired
  private TheatreRepository theatreRepository;

  @Autowired
  private MovieScreenRepository movieScreenRepository;

  @Autowired
  private MovieShowRepository movieShowRepository;


  public List<Theatre> findTheatresByCityAndMovie(Long cityId, Long movieId) {
    List<Theatre> theatres = theatreRepository.findAllByCityId(cityId);
    List<Theatre> theatresRunningTheMovie = new ArrayList<>();

    theatres.forEach(theatre -> {
      List<MovieScreen> movieScreens = movieScreenRepository.findAllByTheatreId(theatre.getId());
      movieScreens.forEach(movieScreen -> {
        List<MovieShow> movieShows = movieShowRepository.findAllByMovieScreenId(movieScreen.getId());
        movieShows.forEach(movieShow -> {
          if(Objects.equals(movieShow.getMovie().getId(), movieId)){
            theatresRunningTheMovie.add(theatre);
          }
        });
      });
    });
  return theatresRunningTheMovie;
  }
}
