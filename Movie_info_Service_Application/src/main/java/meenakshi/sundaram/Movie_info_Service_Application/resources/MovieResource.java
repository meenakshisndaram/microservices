package meenakshi.sundaram.Movie_info_Service_Application.resources;

import meenakshi.sundaram.Movie_info_Service_Application.movie.movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieResource {
    @RequestMapping("/{movieId}")
    public movie getMovieInfo(@PathVariable ("movieId") String movieId){
        return  new movie("Tita_1","titanic");
    }

}
