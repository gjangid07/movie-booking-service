package com.app.moviebooking.model;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeatPredicate implements Predicate {

  @Override
  public boolean test(Object o) {
    Seat seat = (Seat) o;

    String regex = "^[a-eA-E]";
    Pattern pattern = Pattern.compile(regex);

    Matcher matcher = pattern.matcher(seat.getSeatNumber());
    if(matcher.find()){
      return true;
    }
    return false;
  }
}
