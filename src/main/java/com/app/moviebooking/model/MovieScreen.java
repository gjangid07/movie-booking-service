package com.app.moviebooking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MovieScreen {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private Theatre theatre;

  private int screenNumber;
  private int capacity;

  public MovieScreen(Long id, Theatre theatre, int screenNumber, int capacity) {
    this.id = id;
    this.theatre = theatre;
    this.screenNumber = screenNumber;
    this.capacity = capacity;
  }

  public MovieScreen() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Theatre getTheatre() {
    return theatre;
  }

  public void setTheatre(Theatre theatre) {
    this.theatre = theatre;
  }

  public int getScreenNumber() {
    return screenNumber;
  }

  public void setScreenNumber(int screenNumber) {
    this.screenNumber = screenNumber;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }
}
