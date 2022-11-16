package db;

import java.sql.SQLException;
import java.util.Scanner;

public class TestBD {

    public static void main(String args[]) {
        Session session = new Session();
        session.open();

        try {
            /* User Menu */
            System.out.println("Welcome to CyberVideo");
            Scanner sc = new Scanner(System.in);
            int choice;
            do {
                System.out.println("What do you want to do ?");
                System.out.println("[1] add a movie ?");
                System.out.println("[2] show all movies ?");
                System.out.println("[3] show cards ?");
                choice = sc.nextInt();
                switch(choice){
                    case 1:
                        System.out.flush();
                        addMovie();
                        break;
                    case 2:
                        System.out.flush();
                        showMovies();
                        break;
                    case 3:
                        System.out.flush();
                        showCards();
                        break;
                }
            } while(choice != 0);
            sc.close();
            System.out.println("bye.");

        } catch (SQLException e) {
            System.err.println("failed");
            System.out.println("Error stack");
            e.printStackTrace(System.err);
            System.out.println("error message");
            System.out.println(e.getMessage());
            System.out.println("Error code");
            System.out.println(e.getErrorCode());
        }

        session.close();
    }

    private static void showCards() throws SQLException{
        System.out.println("no cards found");

    }

    private static void addMovie() throws SQLException{
        System.out.println("no movie to add");
    }

    private static void showMovies() throws SQLException{
        System.out.println("no movies found");
    }

}


