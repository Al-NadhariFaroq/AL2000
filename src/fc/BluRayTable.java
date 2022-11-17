package fc;

import java.util.ArrayList;
import java.util.List;

public class BluRayTable {
    BluRay blurays[];
    List<Integer> blurayRentals;

    public BluRayTable(){
        blurays = new BluRay[100];
        blurayRentals = new ArrayList<>();
    }

    public int getFreePosition(){
        return blurayRentals.get(0);
    }

    public void addFreePosition(int position){
        blurayRentals.add(position);
    }

    public void addBluRay(BluRay bluRay){
        blurays[getFreePosition()] = bluRay;
    }

    public BluRay getBluRay(Movie movie){
        int i = 0;
        BluRay current;
        do{
            current = blurays[i++];
        }while(current.getMovie() != movie && i < 100);

        return current;
    }
    
}
