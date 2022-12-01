package fc.movie;

public enum SearchType {
    TITLE, DIRECTORS, ACTORS, ROLES, SYNOPSIS;

    public boolean isContainsInMovie(Movie movie, String text) {
        switch (this) {
            case TITLE:
                return movie.isContainedInTitle(text);
            case DIRECTORS:
                return movie.isContainedInDirectors(text);
            case ACTORS:
                return movie.isContainedInActors(text);
            case ROLES:
                return movie.isContainedInRoles(text);
            case SYNOPSIS:
                return movie.isContainedInSynopsis(text);
            default:
                return false;
        }
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
