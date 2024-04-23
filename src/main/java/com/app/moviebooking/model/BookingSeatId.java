package com.app.moviebooking.model;

import java.io.Serializable;
import java.util.Objects;

public class BookingSeatId implements Serializable {

  private Long booking;
  private Long seat;

  public Long getBooking() {
    return booking;
  }

  public void setBooking(Long booking) {
    this.booking = booking;
  }

  public Long getSeat() {
    return seat;
  }

  public void setSeat(Long seat) {
    this.seat = seat;
  }

  public BookingSeatId() {
  }

  public BookingSeatId(Long booking, Long seat) {
    this.booking = booking;
    this.seat = seat;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookingSeatId that = (BookingSeatId) o;
    return Objects.equals(booking, that.booking) && Objects.equals(seat, that.seat);
  }

  @Override
  public int hashCode() {
    return Objects.hash(booking, seat);
  }
}
