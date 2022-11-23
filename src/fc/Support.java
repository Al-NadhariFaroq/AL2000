package fc;

abstract class Support {
    Movie movie;

    public Support(Movie m) {
        movie = m;
    }

    public Movie getMovie() {
        return movie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        Support support = (Support) o;

        return support.movie.equals(movie);
    }

    @Override
    public String toString() {
        return movie.title;
    }
}
