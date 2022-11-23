package fc;

import java.util.Date;

public class Movie {
    String title;
    Date date;
    String synopsis;
    int rate;
    String[] directors;
    String[] actors;
    String[] themes;

    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String[] getDirectors() {
        return directors;
    }

    public void setDirectors(String[] directors) {
        this.directors = directors;
    }

    public String[] getActors() {
        return actors;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }

    public String[] getThemes() {
        return themes;
    }

    public void setThemes(String[] themes) {
        this.themes = themes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        Movie movie = (Movie) o;

        if (movie.title == title && movie.date == date && movie.synopsis == synopsis && movie.directors == directors && movie.actors == actors && movie.themes == themes) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return title;
    }
}
