package fc.tests;

import fc.BluRay;
import fc.BluRayTable;
import fc.Movie;

public class TestBluRay {
    public static void main(String args[]) {
        BluRayTable blurays = new BluRayTable();
        blurays.insertBluRay(new BluRay(new Movie("Avatar"), 0));
        blurays.insertBluRay(new BluRay(new Movie("Harry Potter"), 0));
        blurays.insertBluRay(new BluRay(new Movie("La Cité de la Peur"), 0));
        blurays.insertBluRay(new BluRay(new Movie("Avatar"), 1));
        blurays.insertBluRay(new BluRay(new Movie("Avatar"), 2));
        blurays.insertBluRay(new BluRay(new Movie("Harry Potter"), 1));
        blurays.insertBluRay(new BluRay(new Movie("Rrrrrrrrrrhhh"), 6));
        blurays.insertBluRay(new BluRay(new Movie("Toy Story"), 0));

        System.out.println(blurays);

        boolean b = blurays.addBluRay(new BluRay(new Movie("Old Boy"), 0));
        System.out.println(b);

        BluRay bluray = blurays.getBluRay(new Movie("Avatar"));
        System.out.println(bluray);

        System.out.println(blurays);

        BluRay bluray2 = blurays.getBluRay(new Movie("Toy Story"));
        System.out.println(bluray2);

        System.out.println(blurays);

        blurays.addBluRay(bluray);
        blurays.addBluRay(bluray2);

        System.out.println(blurays);

        blurays.removeBluRay(new BluRay(new Movie("Harry Potter"), 1));

        System.out.println(blurays);
    }
}
