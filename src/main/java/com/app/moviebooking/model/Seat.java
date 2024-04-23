package com.app.moviebooking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Seat {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private MovieScreen movieScreen;

  private String seatNumber;

  public Seat( String seatNumber, MovieScreen movieScreen) {
    this.seatNumber = seatNumber;
    this.movieScreen = movieScreen;
  }

  public Seat() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public MovieScreen getMovieScreen() {
    return movieScreen;
  }

  public void setMovieScreen(MovieScreen movieScreen) {
    this.movieScreen = movieScreen;
  }

  public String getSeatNumber() {
    return seatNumber;
  }

  public void setSeatNumber(String seatNumber) {
    this.seatNumber = seatNumber;
  }
}

enum SeatStatus{

  RESERVED(false),
  NOT_RESERVED(true);
  final boolean isAvailable;

  SeatStatus(boolean isAvailable){
    this.isAvailable=isAvailable;
  }

  public boolean isAvailable() {
    return isAvailable;
  }
}


