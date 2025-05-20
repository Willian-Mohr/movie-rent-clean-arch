package com.wohr.domain.entities;

public class Movie {
    private Long id;
    private String title;
    private String genre;
    private int releaseYear;
    private boolean available;

    public Movie(Long id, String title, String genre, int releaseYear, boolean available) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
