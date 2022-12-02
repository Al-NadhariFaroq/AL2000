package fc;

import fc.support.BluRay;
import fc.movie.Movie;
import fc.movie.Rating;

import java.util.Calendar;

public class BluRaysTest {

    private static Movie createMovie(String title, int year) {
        Calendar date = Calendar.getInstance();
        date.set(year, Calendar.JANUARY, 1);
        return new Movie(title,
                         date,
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
        Movie avatar = createMovie("Avatar", 2009);
        Movie harryPotter = createMovie("Harry Potter", 2001);
        Movie laCiteDeLaPeur = createMovie("La Cite de la peur", 1994);
        Movie toyStory = createMovie("Toy Story", 1995);
        Movie oldBoy = createMovie("Old Boy", 2003);

        BluRays bluRays = new BluRays();
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
