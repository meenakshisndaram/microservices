package meenakshi.sundaram.moviescatalogservices.Controller;

import meenakshi.sundaram.moviescatalogservices.model.Movie;
import meenakshi.sundaram.moviescatalogservices.model.Rating;
import meenakshi.sundaram.moviescatalogservices.model.catalogmovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/catalog2")
public class moviecatalalogcontrollerresdources2 {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private WebClient.Builder webclientBuilder;
    @RequestMapping("/{userid}")
    public List<catalogmovie> getcatalog(@PathVariable("userid") String userid){
        List<Rating> ratings= Arrays.asList(
                new Rating("9087", 9),
                new Rating("3031", 8));
        return ratings.stream().map(rating -> {

           /* Movie movie=restTemplate.getForObject("http://localhost:9087/movies/"+rating.getMovieId(),
                    Movie.class);*/
            Movie movie=webclientBuilder.build().
                    get().
                    uri("http://localhost:9087/movies/"+rating.getMovieId()).
                    retrieve().
                    bodyToMono(Movie.class).
                    block();

            return new catalogmovie(movie.getName(),rating.getRating(),"Good movie");
        }).collect(Collectors.toList());
    }
}
