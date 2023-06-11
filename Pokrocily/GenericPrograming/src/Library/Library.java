package Library;

import java.util.ArrayList;

public class Library<P extends Storebles> {

    ArrayList<P> library = new ArrayList<>();

    public void addToLibrary(P create){
        library.add(create);
    }

    public void listLibrary(){
        for(P piece : library){
            System.out.println(piece.toString());
        }
    }


}
