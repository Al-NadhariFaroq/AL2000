package fc;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class BluRayTable {
    private final int NB_MOVIES_MAX = 100;

    Dictionary<Integer, BluRay> blurays;
    List<Integer> idxFreePositions;

    public BluRayTable() {
        blurays = new Hashtable<>();
        idxFreePositions = new ArrayList<>();
        for (int i = 0; i < NB_MOVIES_MAX; i++) {
            idxFreePositions.add(i);
        }
    }

    public int getFreePosition() {
        return idxFreePositions.remove(0);
    }

    public void addFreePosition(int position) {
        idxFreePositions.add(position);
    }

    public void insertBluRay(BluRay bluRay) {
        if (blurays.size() < NB_MOVIES_MAX) {
            blurays.put(getFreePosition(), bluRay);
        }
    }

    public void removeBluRay(BluRay bluRay) {
        Iterator<Integer> idxIt = blurays.keys().asIterator();

        while (idxIt.hasNext()) {
            int idx = idxIt.next();
            BluRay curBluRay = blurays.get(idx);
            if (idx >= 0 && curBluRay.equals(bluRay)) {
                blurays.remove(idx);
                addFreePosition(idx);
            }
        }
    }

    public boolean addBluRay(BluRay bluRay) {
        Iterator<Integer> idxIt = blurays.keys().asIterator();

        while (idxIt.hasNext()) {
            int idx = idxIt.next();
            BluRay curBluRay = blurays.get(idx);
            if (idx < 0 && curBluRay.equals(bluRay)) {
                blurays.remove(idx);
                blurays.put(-idx, bluRay);
                return true;
            }
        }

        return false;
    }

    public BluRay getBluRay(Movie movie) {
        Iterator<Integer> idxIt = blurays.keys().asIterator();

        while (idxIt.hasNext()) {
            int idx = idxIt.next();
            BluRay bluray = blurays.get(idx);
            if (idx >= 0 && bluray.getMovie().equals(movie)) {
                blurays.remove(idx);
                blurays.put(-idx, bluray);
                return bluray;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        Iterator<Integer> idxIt = blurays.keys().asIterator();
        StringBuilder txt = new StringBuilder("");

        while (idxIt.hasNext()) {
            int idx = idxIt.next();
            BluRay bluray = blurays.get(idx);
            txt.append(idx + " : " + bluray + "\n");
        }

        return txt.toString();
    }
}
