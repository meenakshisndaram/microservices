package meenakshi.sundaram.moviescatalogservices.model;

public class catalogmovie {
    private String name;
    private int rating;
    private String description;

    public catalogmovie(String name, int rating, String description) {
        this.name = name;
        this.rating = rating;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
