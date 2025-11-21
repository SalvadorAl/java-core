package school.sorokin.javacore.oop.libraryCatalog;

import java.util.ArrayList;
import java.util.List;

public class Library {


    private List<Publication> publications = new ArrayList<>();
    public void addPublication(Publication pub){
        publications.add(pub);
        Publication.publicationCount();

    }
    public void listPublications(){
        if (publications.isEmpty()) {
            System.out.println("Каталог пуст.");
            return;
        }
        System.out.println(publications);
    }
    public void searchByAuthor(String author){
        if (publications.isEmpty()) {
            System.out.println("Каталог пуст.");
            return;
        }
        for (Publication pub: publications) {
            if(pub.getAuthor().equalsIgnoreCase(author)){
                System.out.println(pub);
            }
        }

    }

}
