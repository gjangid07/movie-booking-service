package com.app.moviebooking.repository;

import com.app.moviebooking.model.BookingSeat;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingSeatRepository extends JpaRepository<BookingSeat, Long> {

}
