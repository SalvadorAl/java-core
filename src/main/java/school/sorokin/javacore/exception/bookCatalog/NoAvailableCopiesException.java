package school.sorokin.javacore.exception.bookCatalog;

public class NoAvailableCopiesException extends RuntimeException {
    public NoAvailableCopiesException(String message){
        super(message);
    }
}
