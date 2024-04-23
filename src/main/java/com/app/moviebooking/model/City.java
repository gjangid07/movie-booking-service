package com.app.moviebooking.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class City {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  public City() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object obj) {
    if(obj==null){
      return false;
    }

    if(!obj.getClass().equals(City.class)){
      return false;
    }
    if(obj == this){
      return true;
    }
    City city = (City) obj;

    return Objects.equals(this.id, city.id) && this.name.equals(city.name);
  }

  public int hashCode() {
    int cityName = 0;

    for (int i = 0; i < this.name.length(); i++) {
      cityName = cityName + (int) this.name.charAt(i);
    }

    return (int) (id + cityName);
  }

  public City(Long id, String name) {
    this.id = id;
    this.name = name;
  }
}
