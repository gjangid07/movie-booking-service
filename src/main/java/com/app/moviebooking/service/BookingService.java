package com.app.moviebooking.service;

import com.app.moviebooking.model.Booking;
import com.app.moviebooking.model.BookingSeat;
import com.app.moviebooking.model.BookingStatus;
import com.app.moviebooking.model.MovieScreen;
import com.app.moviebooking.model.MovieShow;
import com.app.moviebooking.model.Seat;
import com.app.moviebooking.model.Userr;
import com.app.moviebooking.repository.BookingRepository;
import com.app.moviebooking.repository.BookingSeatRepository;
import com.app.moviebooking.repository.SeatRepository;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

@Service
public class BookingService {

  @Autowired
  private BookingRepository bookingRepository;

  @Autowired
  private SeatRepository seatRepository;

  @Autowired
  private BookingSeatRepository bookingSeatRepository;

  private static final String PAYMENT_INITIATE_TOPIC = "initiatePayment";
  private static final String BOOKING_COMPLETED_TOPIC = "bookingCompleted";
  private static final String BOOT_STRAP_SERVER = "localhost:9092";

  private static Producer<String, String> paymentInitiationProducer;

  private static Consumer<String, String> bookingCompilitionConsumer;

  static {
    Properties producerProperties = new Properties();
    producerProperties.put("bootstrap.servers", BOOT_STRAP_SERVER);
    producerProperties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    producerProperties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

    Properties consumerProps = new Properties();
    consumerProps.put("bootstrap.servers", BOOT_STRAP_SERVER);
    consumerProps.put("group.id", "booking-consumer-group");
    consumerProps.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    consumerProps.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");


    paymentInitiationProducer = new KafkaProducer<>(producerProperties);
    bookingCompilitionConsumer = new KafkaConsumer<String, String>(consumerProps);
    bookingCompilitionConsumer.subscribe(Collections.singletonList(BOOKING_COMPLETED_TOPIC));
  }

  public Booking createBooking(Booking booking){
    MovieShow movieShow = booking.getMovieShow();
    Userr user = booking.getUserr();
    MovieScreen movieScreen = movieShow.getMovieScreen();
    List<Seat> seats = seatRepository.findAllByMovieScreenId(movieScreen.getId());
    Seat seat = seats.get(0);

    Booking newBooking = new Booking(user, movieShow, Date.from(Instant.now()), BookingStatus.BOOKING_CREATED);
    Booking bookingCreated = bookingRepository.save(newBooking);

    publishPaymentInitiateEvent(newBooking);
    Booking completedBooking = awaitTillPaymentIsNotCompleted(newBooking);
    BookingSeat bookingSeat = new BookingSeat(bookingCreated, seat);
    bookingSeatRepository.save(bookingSeat);

    return completedBooking;
  }

  private Booking awaitTillPaymentIsNotCompleted(Booking newBooking) {
    Booking completedBooking = null;
    try {
      boolean isBookingCompleted=false;
      while (!isBookingCompleted) {
        ConsumerRecords<String, String> bookingCompilitionRecords = bookingCompilitionConsumer.poll(Duration.ofMillis(100));
        for (ConsumerRecord<String, String> consumerRecord : bookingCompilitionRecords.records(BOOKING_COMPLETED_TOPIC)) {
          if (consumerRecord.key().equals(newBooking.getId().toString())) {
            System.out.println("Payment for booking ID: " + newBooking.getId() + " done. Setting it Booking Complete");
            newBooking.setBookingStatus(BookingStatus.BOOKING_COMPLETED);
            completedBooking = bookingRepository.save(newBooking);
            isBookingCompleted=true;
            break;
          }
        }
      }
    }catch (Exception e){
      e.printStackTrace();
    }finally {
      bookingCompilitionConsumer.close();
    }
    return completedBooking;
  }

  private void publishPaymentInitiateEvent(Booking newBooking) {
    try {
      ProducerRecord<String, String> record = new ProducerRecord<>(PAYMENT_INITIATE_TOPIC, newBooking.getId().toString(), "100");
      paymentInitiationProducer.send(record);
    }catch (Exception e) {
      e.printStackTrace();
    } finally {
      paymentInitiationProducer.close();
    }
  }
}
