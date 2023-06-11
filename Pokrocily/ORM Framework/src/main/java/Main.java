import DatabaseAccess.Manager;
import Exceptions.AnnotationMissingException;
import Exceptions.EmptyIDException;
import Exceptions.MissingBarAnnotationException;
import Exceptions.MissingIdException;
import Program.Entities.Movie;
import Program.Entities.Person;

import java.sql.SQLException;
import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager();


        try {
            Person person = manager.getEntitByID(0L, Person.class);
            Movie movie = manager.getEntitByID(0L, Movie.class);

            System.out.println(person.getId());
            System.out.println(person.getName());
            System.out.println(person.getSurname());
            System.out.println(person.getAge());
            System.out.println(person.getAddress());

            Movie addMovie = new Movie();
            addMovie.setTitle("Fireproof");
            addMovie.setDirector("Alex Kendrick");
            addMovie.setStarring("Kirk Cameron, Erin Bethea");

            manager.insertEntity(addMovie);



        } catch (AnnotationMissingException | EmptyIDException | MissingBarAnnotationException | MissingIdException | SQLException | InstantiationException | IllegalAccessException exception) {
            exception.printStackTrace();
        }



    }
}
