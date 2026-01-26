package org.LLD.BookMyShow.Model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Show {
    String id;
    Movie movie;
    long startTime;
    Map<String, Seat> seats = new ConcurrentHashMap<>();

    public Show(String id, Movie movie, long startTime) {
        this.id = id;
        this.movie = movie;
        this.startTime = startTime;
    }

    public Map<String, Seat> getSeats() {
        return seats;
    }

    public void setSeats(Map<String, Seat> seats) {
        this.seats = seats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
}
