package school.sorokin.javacore.exception.bookCatalog;

import java.util.Scanner;

public class CatalogManager {
    private static final Library library = new Library();
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            // Отображение меню
            System.out.println("\n <Книжный каталог> ");
            System.out.println("1. Добавить новую книгу");
            System.out.println("2. Взять книгу");
            System.out.println("3. Вернуть книгу");
            System.out.println("4. Вывести список книг");
            System.out.println("0. Выход");
            System.out.print("Выберите опцию: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Пожалуйста, введите число от 1 до 5.");
                continue;
            }
            Book book;
            switch (choice) {
                case 1 -> {
                    System.out.println("Введите название книги");
                    String title = scanner.nextLine().trim();
                    System.out.println("Введите имя автора");
                    String author = scanner.nextLine().trim();
                    System.out.println("Кол-во копий");
                    int availableCopies;
                    try {
                        availableCopies = scanner.nextInt();
                        scanner.nextLine();
                        book = new Book(title, author, availableCopies);
                        library.addBook(book);
                        System.out.println("Книга добавлена");
                    }
                    catch (NoAvailableCopiesException e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 2 -> {
                    try {
                        System.out.print("Введите название книги: ");
                        String title = scanner.nextLine().trim();
                        library.takeBook(title);
                    } catch (ItemNotFoundException | NoAvailableCopiesException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        System.out.print("Введите название книги: ");
                        String returnBook = scanner.nextLine().trim();
                        library.returnBook(returnBook);
                    } catch (ItemNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 4 -> {
                    library.getAllBooks();
                }
                case 5 -> {
                    System.out.println("Выход.");
                    return;
                }
                default -> System.out.println("Некорректный выбор, попробуйте снова.");
            }

        }

    }
}
