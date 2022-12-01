package fc.test;

import fc.support.BluRay;
import fc.support.BluRayDatabase;
import fc.movie.Movie;
import fc.movie.Rating;

import java.util.Calendar;

public class TestBluRayDatabase {

    private static Movie createMovie(String title) {
        return new Movie(title,
                         Calendar.getInstance(),
                         null,
                         null,
                         null,
                         "",
                         Rating.G,
                         0f,
                         "",
                         "https://media.wdwnt.com/2022/11/avatar-the-way-of-water-poster-960x1200.jpg"
        );
    }

    public static void main(String[] args) {
        Movie avatar = createMovie("Avatar");
        Movie harryPotter = createMovie("Harry Potter");
        Movie laCiteDeLaPeur = createMovie("La Cite de la peur");
        Movie toyStory = createMovie("Toy Story");
        Movie oldBoy = createMovie("Old Boy");

        BluRayDatabase bluRays = new BluRayDatabase();
        bluRays.addBluRay(new BluRay(0, avatar));
        bluRays.addBluRay(new BluRay(0, harryPotter));
        bluRays.addBluRay(new BluRay(0, laCiteDeLaPeur));
        bluRays.addBluRay(new BluRay(1, avatar));
        bluRays.addBluRay(new BluRay(2, avatar));
        bluRays.addBluRay(new BluRay(1, harryPotter));
        bluRays.addBluRay(new BluRay(6, laCiteDeLaPeur));
        bluRays.addBluRay(new BluRay(0, toyStory));
        System.out.println(bluRays);

        bluRays.addBluRay(new BluRay(0, oldBoy));
        BluRay avatarBluRay = bluRays.getBluRayFromMovie(avatar);
        bluRays.rentBluRay(avatarBluRay);
        BluRay toyStoryBluRay = bluRays.getBluRayFromMovie(toyStory);
        bluRays.rentBluRay(toyStoryBluRay);
        System.out.println(bluRays);

        bluRays.returnBluRay(toyStoryBluRay);
        bluRays.returnBluRay(avatarBluRay);
        bluRays.removeBluRay(new BluRay(1, harryPotter));
        System.out.println(bluRays);
    }
}
