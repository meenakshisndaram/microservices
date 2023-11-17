package meenakshi.sundaram.moviescatalogservices.Controller;

import meenakshi.sundaram.moviescatalogservices.model.Rating;
import meenakshi.sundaram.moviescatalogservices.model.catalogmovie;
import meenakshi.sundaram.moviescatalogservices.model.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class moviecatalalogcontrollerresdources {
    RestTemplate restTemplate=new RestTemplate();

    @RequestMapping("/{userid}")
    public List<catalogmovie> getcatalog(@PathVariable("userid") String userid){
      List<Rating> ratings= Arrays.asList(new Rating("9087", 9),new Rating("3031", 8));
      return ratings.stream().map(rating -> {

          Movie movie=restTemplate.getForObject("http://localhost:9087/movies/"+rating.getMovieId(),
                  Movie.class);

          return new catalogmovie(movie.getName(),rating.getRating(),"Good movie");
      }).collect(Collectors.toList());
    }
}
