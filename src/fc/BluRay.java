package fc;

public class BluRay extends Support {
    int bluRayId;

    public BluRay(Movie movie, int id) {
        super(movie);
        bluRayId = id;
    }

    public int getBluRayId() {
        return bluRayId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        BluRay bluRay = (BluRay) o;

        return bluRay.movie.equals(movie) &&
                bluRay.bluRayId == bluRayId;
    }

    @Override
    public String toString() {
        return movie.title + " " + bluRayId;
    }
}
