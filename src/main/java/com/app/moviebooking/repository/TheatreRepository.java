package com.app.moviebooking.repository;

import com.app.moviebooking.model.Theatre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {

  List<Theatre> findTheatreByCity(Long cityId);

  List<Theatre> findAllByCityId(Long cityId);
}
