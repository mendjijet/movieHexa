package com.jet.movieHexa.application.dao;

import com.jet.movieHexa.application.dto.MovieDto;
import com.jet.movieHexa.domain.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieDAO {
    Optional<Movie> findMovieByTitle(String title);
    List<Movie> findAllMovies();
    void saveMovie(MovieDto movie);
    void updateMovie(Movie newMovie);
    void deleteMovie(Movie oldMovie);
}
