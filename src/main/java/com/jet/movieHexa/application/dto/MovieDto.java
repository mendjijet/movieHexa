package com.jet.movieHexa.application.dto;

import java.time.LocalDate;

public record MovieDto(
        String title,
        String description,
        LocalDate releaseDate,
        String directorName
) {}
