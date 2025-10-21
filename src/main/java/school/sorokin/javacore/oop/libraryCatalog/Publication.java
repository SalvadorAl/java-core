package school.sorokin.javacore.oop.libraryCatalog;

import java.util.Objects;

public abstract class Publication {
    private static int publicationCount = 0;
    private String title;
    private String author;
    private int year;

    public Publication(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        publicationCount++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static int getPublicationCount(){
       return publicationCount;
    }

    public abstract String getType();

    @Override
    public String toString(){
        return "Название: " + title + ", Автор: " + author + ", Год выпуска: " + year;
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + year;
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Publication publication = (Publication) obj;
        return (title != null ? title.equals(publication.title) : publication.title == null)
                && (author != null ? author.equals(publication.author) : publication.author == null)
                && year == publication.year;

    }
}
