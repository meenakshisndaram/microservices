package meenakshi.sundaram.Rating_Data_Service_Application.Resources;

import meenakshi.sundaram.Rating_Data_Service_Application.Module.Rating;
import meenakshi.sundaram.Rating_Data_Service_Application.Module.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingdata")
public class RaingResources {
    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable ("movieId")String movieId){
        return new Rating("Titanic",8);
    }
    @RequestMapping("/user/{userid}")
    public UserRating getRatings(@PathVariable ("userid") String userid){
        List<Rating>ratings= Arrays.asList(
                new Rating("I am legend-7486",9),
                new Rating("Eddie the Eaglee-7952", 9));
        UserRating userrating=new UserRating();
        userrating.setUserrating(ratings);
                return userrating;
    }

}
