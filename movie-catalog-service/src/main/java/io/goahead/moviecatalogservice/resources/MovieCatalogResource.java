package io.goahead.moviecatalogservice.resources;

import io.goahead.moviecatalogservice.models.CatalogItem;
import io.goahead.moviecatalogservice.models.Movie;
import io.goahead.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        List<Rating> ratingsList = Arrays.asList(
                new Rating("1234", 3),
                new Rating("5678", 4)
        );

        return ratingsList.stream()
                .map(rating -> new CatalogItem("Name", "Desc", rating.getRating()))
                .map(rating -> {
                    Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
                    return new CatalogItem(movie.getName(), "Description", rating.getRating());
                })
                .collect(Collectors.toList());

    }}