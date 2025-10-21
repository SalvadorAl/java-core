package school.sorokin.javacore.oop.libraryCatalog;

import java.util.Scanner;
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Library library = new Library();
    public static void main(String[] args) {


        while (true) {
            // Отображение меню
            System.out.println("\n <Библиотечный каталог> ");
            System.out.println("1. Добавить новую публикацию");
            System.out.println("2. Вывести список всех публикаций");
            System.out.println("3. Поиск публикации по автору");
            System.out.println("4. Вывести общее количество публикаций");
            System.out.println("0. Выход");
            System.out.print("Выберите опцию: ");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    addPublicationMenu();
                    break;
                case "2":
                    library.listPublications();
                    break;
                case "3":
                    System.out.print("Введите автора для поиска: ");
                    String author = scanner.nextLine().trim();
                    library.searchByAuthor(author);
                    break;
                case "4":
                    System.out.println("Общее количество публикаций: " + Publication.getPublicationCount());
                    break;
                case "0":
                    System.out.println("Выход.");
                    return;
                default:
                    System.out.println("Некорректный выбор, попробуйте снова.");
                }

        }
    }
    private static void addPublicationMenu() {
        System.out.println("Выберите тип публикации: 1 — Book, 2 — Magazine, 3 — Newspaper");
        String type = scanner.nextLine().trim();
        switch (type) {
            case "1": addBook(); break;
            case "2": addMagazine(); break;
            case "3": addNewspaper(); break;
            default: System.out.println("Неизвестный тип.");
        }
    }

    private static void addBook() {
        System.out.print("Введите название: ");
        String title = scanner.nextLine().trim();

        System.out.print("Введите автора: ");
        String author = scanner.nextLine().trim();

        int year;
        while (true) {
            System.out.print("Введите год: ");
            String s = scanner.nextLine().trim();
            try { year = Integer.parseInt(s); break; }
            catch (NumberFormatException e) { System.out.println("Ожидается целое число."); }
        }

        System.out.print("Введите ISBN: ");
        String isbn = scanner.nextLine().trim();

        library.addPublication(new Book(title, author, year, isbn));
        System.out.println("Книга добавлена.");
    }

    private static void addMagazine() {
        System.out.print("Введите название: ");
        String title = scanner.nextLine().trim();

        System.out.print("Введите автора: ");
        String author = scanner.nextLine().trim();

        int year;
        while (true) {
            System.out.print("Введите год: ");
            String s = scanner.nextLine().trim();
            try { year = Integer.parseInt(s); break; }
            catch (NumberFormatException e) { System.out.println("Ожидается целое число."); }
        }

        int issue;
        while (true) {
            System.out.print("Введите номер выпуска: ");
            String s = scanner.nextLine().trim();
            try { issue = Integer.parseInt(s); break; }
            catch (NumberFormatException e) { System.out.println("Ожидается целое число."); }
        }

        library.addPublication(new Magazine(title, author, year, issue));
        System.out.println("Журнал добавлен.");
    }

    private static void addNewspaper() {
        System.out.print("Введите название: ");
        String title = scanner.nextLine().trim();

        System.out.print("Введите автора: ");
        String author = scanner.nextLine().trim();

        int year;
        while (true) {
            System.out.print("Введите год: ");
            String s = scanner.nextLine().trim();
            try { year = Integer.parseInt(s); break; }
            catch (NumberFormatException e) { System.out.println("Ожидается целое число."); }
        }

        System.out.print("Введите день публикации (например, Понедельник): ");
        String day = scanner.nextLine().trim();

        library.addPublication(new Newspaper(title, author, year, day));
        System.out.println("Газета добавлена.");
    }
}

