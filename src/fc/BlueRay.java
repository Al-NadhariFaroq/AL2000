package fc;

public class BlueRay extends Dispositif{
    int BlueRayId;
    int location;
    String loadingDate;
    String unloadingDate;

    public BlueRay(){}

    public int getBlueRayId() {
        return BlueRayId;
    }

    public void setBlueRayId(int blueRayId) {
        BlueRayId = blueRayId;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getLoadingDate() {
        return loadingDate;
    }

    public void setLoadingDate(String loadingDate) {
        this.loadingDate = loadingDate;
    }

    public String getUnloadingDate() {
        return unloadingDate;
    }

    public void setUnloadingDate(String unloadingDate) {
        this.unloadingDate = unloadingDate;
    }

    @Override
    void deliverDispositif(){}
}
