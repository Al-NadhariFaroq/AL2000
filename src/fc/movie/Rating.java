package fc.movie;

public enum Rating {
    G(0, "General audiences"),
    PG(0, "Parental guidance suggested"),
    PG13(13, "Parents strongly cautioned"),
    R(13, "Restricted"),
    NC17(17, "Adults Only"),
    UR(0, "Unrated");

    private final int ageLimit;
    private final String description;

    Rating(int ageLimit, String description) {
        this.ageLimit = ageLimit;
        this.description = description;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return super.toString().replace("1", "-1");
    }
}
