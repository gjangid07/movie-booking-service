package com.app.moviebooking.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@IdClass(BookingSeatId.class)
public class BookingSeat {

  @Id
  @ManyToOne
  @JoinColumn(name = "booking_id", referencedColumnName = "id")
  private Booking booking;

  @Id
  @ManyToOne
  @JoinColumn(name = "seat_id", referencedColumnName = "id")
  private Seat seat;

  public BookingSeat(Booking booking, Seat seat) {
    this.booking = booking;
    this.seat = seat;
  }

  public BookingSeat() {

  }

  public Booking getBooking() {
    return booking;
  }

  public void setBooking(Booking booking) {
    this.booking = booking;
  }

  public Seat getSeat() {
    return seat;
  }

  public void setSeat(Seat seat) {
    this.seat = seat;
  }
}
