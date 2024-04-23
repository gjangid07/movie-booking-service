FROM openjdk:11.0.15
#RUN apt-get update && \
#    apt-get install -y wget gnupg && \
#    wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | apt-key add - && \
#    echo "deb http://apt.postgresql.org/pub/repos/apt/ $(grep 'VERSION_CODENAME' /etc/os-release | cut -d '=' -f2)-pgdg main" | tee /etc/apt/sources.list.d/pgdg.list && \
#    apt-get update && \
#    apt-get install -y postgresql-14 && \
#    apt-get clean && \
#    rm -rf /var/lib/apt/lists/*
MAINTAINER gjangid gajendralnmiit@gmail.com
EXPOSE 8090
WORKDIR /app
ADD target/movie-booking-service-docker.jar movie-booking-service-docker.jar
ENTRYPOINT ["java", "-jar", "movie-booking-service-docker.jar"]
