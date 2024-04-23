package com.app.moviebooking.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Booking {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private Userr userr;

  @ManyToOne
  private MovieShow movieShow;

  private Date bookingTime;

  private BookingStatus bookingStatus;

  public Booking(Userr userr, MovieShow movieShow, Date bookingTime, BookingStatus bookingStatus) {
    this.userr = userr;
    this.movieShow = movieShow;
    this.bookingTime = bookingTime;
    this.bookingStatus = bookingStatus;
  }

  public Booking() {

  }

  public Userr getUserr() {
    return userr;
  }

  public void setUserr(Userr userr) {
    this.userr = userr;
  }

  public BookingStatus getBookingStatus() {
    return bookingStatus;
  }

  public void setBookingStatus(BookingStatus bookingStatus) {
    this.bookingStatus = bookingStatus;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Userr getUser() {
    return userr;
  }

  public void setUser(Userr userr) {
    this.userr = userr;
  }

  public MovieShow getMovieShow() {
    return movieShow;
  }

  public void setMovieShow(MovieShow movieShow) {
    this.movieShow = movieShow;
  }

  public Date getBookingTime() {
    return bookingTime;
  }

  public void setBookingTime(Date bookingTime) {
    this.bookingTime = bookingTime;
  }
}

