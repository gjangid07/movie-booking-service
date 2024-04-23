package com.app.moviebooking.resource;

import com.app.moviebooking.model.Booking;
import com.app.moviebooking.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookingResource {

  @Autowired
  private BookingService bookingService;

  @PostMapping("/booking")
  public Booking createBooking(@RequestBody Booking booking){
    return bookingService.createBooking(booking);
  }
}
