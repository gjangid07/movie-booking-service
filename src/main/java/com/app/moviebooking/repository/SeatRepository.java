package com.app.moviebooking.repository;

import com.app.moviebooking.model.Seat;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
  List<Seat> findAllByMovieScreenId(Long movieScreenId);
}
