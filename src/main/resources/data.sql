INSERT INTO userr (username, password, email, phone_number, enabled) VALUES
                                                                        ('user1', 'pass1', 'user1@gmail.com', '12345',  true),
                                                                        ('user2', 'pass2', 'user2@gmail.com', '67890', true);
INSERT INTO city (name) VALUES
                            ('Jaipur'),
                            ('Mathura');

INSERT INTO movie (title, genre, release_date, description) VALUES
                                                                ('Movie1', 'Drama', '1994-10-14  12:34:56', 'movieDetail1'),
                                                                ('Movie2', 'Science Fiction', '2010-07-16  12:34:56', 'movieDetail2');

INSERT INTO theatre (name, location, city_id) VALUES
                                                  ('Theatre A', '12 Shyam Nagar', 1),
                                                  ('Theatre B', '13 Sodala', 1),
                                                  ('Theatre C', 'Vijay Nagar', 2),
                                                  ('Theatre D', 'MurliPura', 2);

INSERT INTO movie_screen (theatre_id, screen_number, capacity) VALUES
                                                                   (1, 1, 100),
                                                                   (2, 1, 150),
                                                                   (3, 1, 50),
                                                                   (4, 1, 75);

INSERT INTO movie_show (movie_id, movie_screen_id, start_time, end_time) VALUES
                                                                             (1, 1, '2024-03-14 18:00:00', '2024-03-14 20:30:00'),
                                                                             (2, 2, '2024-03-15 14:00:00', '2024-03-15 16:30:00'),
                                                                             (1, 3, '2024-03-14 18:00:00', '2024-03-14 20:30:00'),
                                                                             (2, 4, '2024-03-15 14:00:00', '2024-03-15 16:30:00');

INSERT INTO seat (movie_screen_id, seat_number) VALUES
                                                    (1, 'A1'),
                                                    (1, 'A2'),
                                                    (1, 'A3'),
                                                    (2, 'B1'),
                                                    (2, 'B2'),
                                                    (2, 'B3'),
                                                    (3, 'C1'),
                                                    (3, 'C2'),
                                                    (3, 'C3'),
                                                    (4, 'D1'),
                                                    (4, 'D2'),
                                                    (4, 'D3');



INSERT INTO booking (userr_id, movie_show_id, booking_time) VALUES
                                                               (1, 1, '2024-03-13 12:00:00'),
                                                               (2, 2, '2024-03-13 13:00:00');

-- INSERT INTO payment (booking_id, amount, payment_time) VALUES
--                                                            (1, 50.00, '2024-03-13 12:30:00'),
--                                                            (2, 60.00, '2024-03-13 13:30:00');

