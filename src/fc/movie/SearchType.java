package fc.movie;

public enum SearchType {
    TITLE("search in titles"),
    DIRECTORS("search a director"),
    ACTORS("search an actor"),
    ROLES("search a role"),
    SYNOPSIS("search in synopsis");

    private final String description;

    SearchType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

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
        return super.toString().substring(0, 1).toUpperCase() + super.toString().substring(1).toLowerCase();
    }
}
