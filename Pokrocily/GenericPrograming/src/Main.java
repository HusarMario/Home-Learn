import Library.Book;
import Library.Library;
import Library.Movie;
import Library.Storebles;

public class Main {

    public static void main(String[] args) {

        Profile profile1 = new Profile("Mario",21);
        Profile profile2 = new Profile("Baska",16);

        Package<Object,Object>  profilePackages = new Package<>();


        profilePackages.addObject(profile2);
        profilePackages.addObject2(profile1);

        //System.out.println(profilePackages.getObject().toString());
        //System.out.println(profilePackages.getObject2().toString());

        Library<Storebles> library = new Library<Storebles>();

        Book book1 = new Book("GoT",2006);
        Book book2 = new Book("GoT2",2008);
        Book book3 = new Book("Got3",2015);

        Movie movie1 = new Movie("Avengers",2008);
        Movie movie2 = new Movie("Avengers 2",2012);
        Movie movie3 = new Movie("Avengers 3", 2018);

        library.addToLibrary(book1);
        library.addToLibrary(movie1);

        library.listLibrary();


    }
}
