package meenakshi.sundaram.Rating_Data_Service_Application.Module;

public class Rating {
    private String MovieId;
    private int Rating;

    public Rating(String movieId, int rating) {
        MovieId = movieId;
        Rating = rating;
    }

    public String getMovieId() {
        return MovieId;
    }

    public void setMovieId(String movieId) {
        MovieId = movieId;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }
}
