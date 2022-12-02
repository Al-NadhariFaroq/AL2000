package fc;

import fc.movie.Movie;
import fc.support.BluRay;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class BluRays {
    public static final int RENTED = -1;
    public static final int NB_MOVIES_MAX = 100;

    private final Map<BluRay, Integer> bluRays;
    private final Queue<Integer> freePositions;

    BluRays() {
        bluRays = new Hashtable<>();
        freePositions = new PriorityQueue<>();
        updateFromDatabase();
    }

    public BluRay getBluRayFromMovie(Movie movie) {
        for (BluRay bluRay : bluRays.keySet()) {
            if (movie.equals(bluRay.getMovie())) {
                return bluRay;
            }
        }
        return null;
    }

    public int getPosition(BluRay bluRay) {
        return bluRays.get(bluRay);
    }

    public Set<BluRay> getBluRays() {
        return bluRays.keySet();
    }

    public Set<BluRay> getAvailableBluRays() {
        HashSet<BluRay> availableBluRays = new HashSet<>();
        bluRays.forEach((bluRay, position) -> {
            if (position == RENTED) {
                availableBluRays.add(bluRay);
            }
        });
        return availableBluRays;
    }

    public Set<BluRay> getUnavailableBluRays() {
        HashSet<BluRay> unavailableBluRays = new HashSet<>();
        bluRays.forEach((bluRay, position) -> {
            if (position != RENTED) {
                unavailableBluRays.add(bluRay);
            }
        });
        return unavailableBluRays;
    }

    public void addBluRay(BluRay bluRay) throws IllegalStateException, IllegalArgumentException {
        validateOperation(bluRay, 0);
        Integer position = freePositions.poll();
        bluRays.put(bluRay, position);
        dbManagement.createBluRay(bluRay, position == null ? -2 : position);
    }

    public void removeBluRay(BluRay bluRay) throws IllegalArgumentException {
        validateOperation(bluRay, 1);
        freePositions.add(bluRays.remove(bluRay));
        dbManagement.deleteBluRay(bluRay);
    }

    public void rentBluRay(BluRay bluRay) throws IllegalArgumentException {
        freePositions.add(validateOperation(bluRay, 2));
        bluRays.replace(bluRay, RENTED);
        dbManagement.updateBluRay(bluRay, RENTED);
    }

    public void returnBluRay(BluRay bluRay) throws IllegalArgumentException {
        validateOperation(bluRay, 3);
        Integer position = freePositions.poll();
        bluRays.replace(bluRay, position);
        dbManagement.updateBluRay(bluRay, position == null ? -2 : position);
    }

    private Integer validateOperation(BluRay bluRay, int op) throws IllegalArgumentException, IllegalStateException {
        if (op == 0 && bluRays.size() == NB_MOVIES_MAX) {
            throw new IllegalStateException("Impossible to insert a Blu-ray: database full");
        }
        Integer position = bluRays.get(bluRay);
        if (op == 0 && position != null) {
            throw new IllegalArgumentException("Invalid blu-ray value: already in database");
        }
        if (op != 0 && position == null) {
            throw new IllegalArgumentException("Invalid blu-ray value: not in database");
        }
        if ((op == 1 || op == 2) && position == RENTED) {
            throw new IllegalArgumentException("Invalid blu-ray value: currently rented");
        }
        if (op == 3 && position != RENTED) {
            throw new IllegalArgumentException("Invalid blu-ray value: not rented");
        }
        return position;
    }

    public void updateFromDatabase() {
        bluRays.clear();
        bluRays.putAll(dbManagement.readAllBluRays());

        for (int position = 0; position < NB_MOVIES_MAX; position++) {
            if (!bluRays.containsValue(position)) {
                freePositions.add(position);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder();
        bluRays.forEach((bluRay, position) -> txt.append(bluRay)
                                                 .append(" : ")
                                                 .append(position == RENTED ? "rented" : position)
                                                 .append("\n"));
        return txt.toString();
    }
}
