package com.jet.movieHexa.adapters.out.postgresJdbc;

import com.jet.movieHexa.adapters.out.postgresJdbc.entities.MovieEntity;
import com.jet.movieHexa.adapters.out.postgresJdbc.repositories.MoviesRepository;
import com.jet.movieHexa.application.dao.MovieDAO;

import com.jet.movieHexa.application.dto.MovieDto;
import com.jet.movieHexa.domain.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Component
public class MoviesDaoAdapter implements MovieDAO {
    private final MoviesRepository moviesRepository;
    @Override
    public Optional<Movie> findMovieByTitle(String title) {
        return moviesRepository.findMovieByTitle(title);

    }

    @Override
    public List<Movie> findAllMovies() {
        return ((List<MovieEntity>) moviesRepository.findAll())
                .stream()
                .map(movieEntity -> new Movie(
                        movieEntity.id(),
                        movieEntity.title(),
                        movieEntity.description(),
                        movieEntity.releaseDate(),
                        movieEntity.directorName()
                )).toList();

    }

    @Override
    public void saveMovie(MovieDto movie) {
        moviesRepository.save(new MovieEntity(
                null,
                movie.title(),
                movie.description(),
                movie.releaseDate(),
                movie.directorName(),
                null
        ));
    }

    @Override
    public void updateMovie(Movie newMovie) {
        moviesRepository.save(new MovieEntity(
                newMovie.id(),
                newMovie.title(),
                newMovie.description(),
                newMovie.releaseDate(),
                newMovie.directorName(),
                null
        ));
    }

    @Override
    public void deleteMovie(Movie oldMovie) {
    moviesRepository.deleteById(oldMovie.id());
    }
}
