package com.jet.movieHexa.application.usecases;

import com.jet.movieHexa.application.dao.MovieDAO;
import com.jet.movieHexa.application.dto.MovieDto;
import com.jet.movieHexa.domain.Movie;
import com.jet.movieHexa.infrastructure.exception.MovieAlreadyExistsException;
import com.jet.movieHexa.infrastructure.exception.MovieNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class MovieUseCase {
    private final MovieDAO movieDAO;
    public String saveMovie(MovieDto newMovieDto) throws MovieAlreadyExistsException {
        //check if movie is already in DB
        var isPresent = movieDAO.findMovieByTitle(newMovieDto.title()).isPresent();
        if(isPresent) {
            throw new MovieAlreadyExistsException("Movies already exist");
        }

        // continue to save movie
        movieDAO.saveMovie(newMovieDto);

        return "Movie Saved Successfully";
    }

    public List<Movie> getAllMovies(){
        return movieDAO.findAllMovies();
    }

    public String updateMovie(Movie movie) throws MovieNotFoundException {
        //check if movie is already in DB
        var isPresent = movieDAO.findMovieByTitle(movie.title()).isPresent();
        if(!isPresent){
            throw new MovieNotFoundException("This movie does not exist");
        }
        movieDAO.updateMovie(movie);
        return "Movie Successfully updated";
    }

    public String deleteMovie(Movie movie){
        //check if movie is already in DB
        var isPresent = movieDAO.findMovieByTitle(movie.title()).isPresent();
        if(!isPresent){
            throw new MovieNotFoundException("This movie does not exist");
        }
        movieDAO.deleteMovie(movie);
        return "Movie Successfully Delete";
    }

    public Movie getMovieByTitle(String movieTitle ){
        return movieDAO.findMovieByTitle(movieTitle).orElseThrow(
                ()-> new MovieNotFoundException("This movie does not exist")
        );
    }
}
