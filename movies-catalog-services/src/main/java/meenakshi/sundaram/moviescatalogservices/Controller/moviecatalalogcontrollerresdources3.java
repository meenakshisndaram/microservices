package meenakshi.sundaram.moviescatalogservices.Controller;

import meenakshi.sundaram.moviescatalogservices.model.Movie;
import meenakshi.sundaram.moviescatalogservices.model.Rating;
import meenakshi.sundaram.moviescatalogservices.model.UserRating;
import meenakshi.sundaram.moviescatalogservices.model.catalogmovie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/catalog3")
public class moviecatalalogcontrollerresdources3 {
    RestTemplate restTemplate=new RestTemplate();
    @RequestMapping("/{userid}")
    public List<catalogmovie> getcatalog(@PathVariable("userid") String userid){
        UserRating ratingss=restTemplate.getForObject("http://localhost:3031/ratingdata/user/"+userid,UserRating.class);
        return ratingss.getUserrating().stream().map(rating -> {

            Movie movie=restTemplate.getForObject("http://localhost:9087/movies/"+rating.getMovieId(),
                    Movie.class);

            return new catalogmovie(movie.getName(),rating.getRating(),"Good movie");
        }).collect(Collectors.toList());
    }
}
