package school.sorokin.javacore.exception.bookCatalog;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> catalog = new ArrayList<>();
    public void addBook(Book book) {
        if(book.getAvailableCopies() <= 0) {
            throw new NoAvailableCopiesException("Экземпляров должно быть больше нуля");
        }
        catalog.add(book);
    }

    public void takeBook(String title) { //уменьшает copies
        Book book = findBookOrNull(title);
        if(book == null) {
            throw new ItemNotFoundException("Книга с таким названием не найдена ");
        }
        if(book.getAvailableCopies() <= 0) {
            throw new NoAvailableCopiesException("Экземпляров книги в данный момент нет");
        }
        book.setAvailableCopies(book.getAvailableCopies() - 1);
    }

    public void returnBook(String title) { //увеличивает copies
        Book book = findBookOrNull(title);
        if(book == null) {
            throw new ItemNotFoundException("Книга с таким названием не найдена ");
        }
        book.setAvailableCopies(book.getAvailableCopies() + 1);
    }

    public void getAllBooks() {  //возвращает список всех книг
        if(catalog.isEmpty()) {
            System.out.println("Книг нет");;
        }
        for (Book book: catalog) {
            System.out.println(book);
        }
    }

    private Book findBookOrNull(String title) {
        for (Book book : catalog) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}