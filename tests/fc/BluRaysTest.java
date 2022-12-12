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
                         0,
                         Rating.G,
                         0f,
                         null,
                         null,
                         null,
                         "",
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

        BluRayManagement bluRayManagement = new BluRayManagement();
        bluRayManagement.addBluRay(new BluRay(0, avatar));
        bluRayManagement.addBluRay(new BluRay(0, harryPotter));
        bluRayManagement.addBluRay(new BluRay(0, laCiteDeLaPeur));
        bluRayManagement.addBluRay(new BluRay(1, avatar));
        bluRayManagement.addBluRay(new BluRay(2, avatar));
        bluRayManagement.addBluRay(new BluRay(1, harryPotter));
        bluRayManagement.addBluRay(new BluRay(6, laCiteDeLaPeur));
        bluRayManagement.addBluRay(new BluRay(0, toyStory));
        System.out.println(bluRayManagement);

        bluRayManagement.addBluRay(new BluRay(0, oldBoy));
        BluRay avatarBluRay = bluRayManagement.getBluRayFromMovie(avatar);
        bluRayManagement.rentBluRay(avatarBluRay);
        BluRay toyStoryBluRay = bluRayManagement.getBluRayFromMovie(toyStory);
        bluRayManagement.rentBluRay(toyStoryBluRay);
        System.out.println(bluRayManagement);

        bluRayManagement.returnBluRay(toyStoryBluRay);
        bluRayManagement.returnBluRay(avatarBluRay);
        bluRayManagement.removeBluRay(new BluRay(1, harryPotter));
        System.out.println(bluRayManagement);
    }
}
