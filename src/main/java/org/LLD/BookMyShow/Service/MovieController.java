package org.LLD.BookMyShow.Service;

import org.LLD.BookMyShow.Model.Movie;
import org.LLD.BookMyShow.Model.Show;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MovieController {
    // City -> List of Movies
    private Map<String, List<Movie>> cityMovies = new HashMap<>();
    // Movie -> List of Shows
    private Map<String, List<Show>> movieShows = new HashMap<>();

    public void addMovie(String city, Movie movie) {
        cityMovies.computeIfAbsent(city, k -> new ArrayList<>()).add(movie);
    }

    public List<Movie> getMoviesByCity(String city) {
        return cityMovies.getOrDefault(city, new ArrayList<>());
    }
}
