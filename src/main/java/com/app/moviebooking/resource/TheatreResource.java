package com.app.moviebooking.resource;

import com.app.moviebooking.model.Theatre;
import com.app.moviebooking.service.TheatreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TheatreResource {

  @Autowired
  private TheatreService theatreService;

  @GetMapping("/city/{cityId}/movie/{movieId}/theatres")
  public List<Theatre> getTheatresByCityAndMovie(@PathVariable Long cityId, @PathVariable Long movieId) {
    return theatreService.findTheatresByCityAndMovie(cityId, movieId);
  }
}

