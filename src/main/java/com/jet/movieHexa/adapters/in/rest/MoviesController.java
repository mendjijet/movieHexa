package com.jet.movieHexa.adapters.in.rest;

import com.jet.movieHexa.application.dto.MovieDto;
import com.jet.movieHexa.application.usecases.MovieUseCase;
import com.jet.movieHexa.domain.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MoviesController {
    private final MovieUseCase movieUseCase;

    @GetMapping
    public ResponseEntity<?> getAllMovies() {
        return ResponseEntity.ok(movieUseCase.getAllMovies());
    }

    @GetMapping("/{title}")
    public ResponseEntity<?> getMovieByTitle(@PathVariable("title") String title) {
        return ResponseEntity.ok(movieUseCase.getMovieByTitle(title));
    }

    @PostMapping
    public ResponseEntity<?> saveMovie(@RequestBody MovieDto movieDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieUseCase.saveMovie(movieDto));
    }

    @PutMapping
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieUseCase.updateMovie(movie));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteMovie(@RequestBody Movie movie) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieUseCase.deleteMovie(movie));
    }

    //delete I leave it for you to practice lol
}
