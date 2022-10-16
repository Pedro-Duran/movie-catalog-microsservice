package io.goahead.moviecatalogservice.models;

public class CatalogItem {
    private String title;
    private String description;
    private int rating;

    public String getTitle() {
        return title;
    }

    public CatalogItem(String title, String description, int rating) {
        this.title = title;
        this.description = description;
        this.rating = rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getMovieId() { return getMovieId();
    }
}
