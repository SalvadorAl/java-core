package school.sorokin.javacore.oop.libraryCatalog;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Publication> publications = new ArrayList<>();
    public void addPublication(Publication pub){
        publications.add(pub);

    }
    public void listPublications(){
        System.out.println(publications);
    }
    public void searchByAuthor(String author){
        for (Publication pub: publications) {
            if(pub.getAuthor().equalsIgnoreCase(author)){
                System.out.println(pub);
            }
        }

    }

}
