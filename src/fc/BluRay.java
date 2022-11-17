package fc;

public class BluRay extends Support{
    int bluRayId;
    int location;
    String loadingDate;
    String unloadingDate;

    public BluRay(Movie movie, int id){
        super(movie);
        bluRayId = id;
    }

    public int getBluRayId() {
        return bluRayId;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }
}
