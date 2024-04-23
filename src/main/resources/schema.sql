CREATE TABLE IF NOT EXISTS userr (
                                    id SERIAL  NOT NULL PRIMARY KEY,
                                    username VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT true
    );

CREATE TABLE IF NOT EXISTS city (
                                    id SERIAL  NOT NULL PRIMARY KEY,
                                    name VARCHAR(100) NOT NULL
    );

CREATE TABLE IF NOT EXISTS movie (
                                         id SERIAL  NOT NULL PRIMARY KEY,
                                         title VARCHAR(255) NOT NULL,
    genre VARCHAR(100),
    release_date DATE,
    description TEXT
    );

    CREATE TABLE IF NOT EXISTS theatre (
                                           id SERIAL  NOT NULL PRIMARY KEY,
                                           name VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    city_id INT,
    FOREIGN KEY (city_id) REFERENCES city(id)
    );

    CREATE TABLE IF NOT EXISTS movie_screen (
                                                id SERIAL  NOT NULL PRIMARY KEY,
                                                theatre_id INT,
                                                screen_number INT,
                                                capacity INT,
                                                FOREIGN KEY (theatre_id) REFERENCES theatre(id)
    );

    CREATE TABLE IF NOT EXISTS movie_show (
                                              id SERIAL  NOT NULL PRIMARY KEY,
                                              movie_id INT,
                                              movie_screen_id INT,
                                              start_time TIMESTAMP,
                                              end_time TIMESTAMP,
                                              FOREIGN KEY (movie_id) REFERENCES movie(id),
    FOREIGN KEY (movie_screen_id) REFERENCES movie_screen(id)
    );

    CREATE TABLE IF NOT EXISTS seat (
                                        id SERIAL  NOT NULL PRIMARY KEY,
                                        movie_screen_id INT,
                                        seat_number VARCHAR(10),
    FOREIGN KEY (movie_screen_id) REFERENCES movie_screen(id)
    );


    CREATE TABLE IF NOT EXISTS booking (
                                           id SERIAL  NOT NULL PRIMARY KEY,
                                           userr_id INT,
                                           movie_show_id INT,
                                           booking_time TIMESTAMP,
                                           FOREIGN KEY (userr_id) REFERENCES userr(id),
    FOREIGN KEY (movie_show_id) REFERENCES movie_show(id)
    );

    CREATE TABLE IF NOT EXISTS booking_seat (
                                                booking_id INT,
                                                seat_id INT,
                                                PRIMARY KEY (booking_id, seat_id),
    FOREIGN KEY (booking_id) REFERENCES booking(id),
    FOREIGN KEY (seat_id) REFERENCES seat(id)
    );

--     CREATE TABLE IF NOT EXISTS payment (
--                                            id SERIAL  NOT NULL PRIMARY KEY,
--                                            booking_id INT,
--                                            amount DECIMAL(10, 2),
--     payment_time TIMESTAMP,
--     FOREIGN KEY (booking_id) REFERENCES booking(id)
--     );


