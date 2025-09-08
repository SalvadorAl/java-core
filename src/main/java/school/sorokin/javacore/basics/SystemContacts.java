package school.sorokin.javacore.basics;

import java.util.Scanner;

public class SystemContacts {
    private static final int MAX_CONTACTS = 100;
    private static String[] names = new String[MAX_CONTACTS];
    private static String[] phoneNumbers = new String[MAX_CONTACTS];
    private static int contactCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в Систему Учёта Контактов!");

        boolean running = false;

        while (!running) {
            // Отображение меню
            System.out.println("\n МЕНЮ ");
            System.out.println("1. Добавить контакт");
            System.out.println("2. Просмотреть контакты");
            System.out.println("3. Найти контакт");
            System.out.println("4. Удалить контакт");
            System.out.println("5. Выйти");
            System.out.print("Выберите опцию (1-5): ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Пожалуйста, введите число от 1 до 5.");
                continue;
            }

            switch (choice) {
                case 1 -> addContact();
                case 2 -> viewAllContacts();
                case 3 -> searchContact();
                case 4 -> deleteContact();
                case 5 -> {
                    running = true;
                    System.out.println("До свидания! Спасибо за использование системы.");
                }
                default -> System.out.println("Ошибка: Неверный выбор. Пожалуйста, выберите опцию от 1 до 5.");
            }
        }

        scanner.close();
    }

    // Добавление контакта
    private static void addContact() {
        if (contactCount >= MAX_CONTACTS) {
            System.out.println("Ошибка: Достигнуто максимальное количество контактов (" + MAX_CONTACTS + ").");
            return;
        }

        System.out.print("Введите имя: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Ошибка: Имя не может быть пустым.");
            return;
        }

        System.out.print("Введите номер телефона: ");
        String phone = scanner.nextLine().trim();
        if (phone.isEmpty()) {
            System.out.println("Ошибка: Номер телефона не может быть пустым.");
            return;
        }

        names[contactCount] = name;
        phoneNumbers[contactCount] = phone;
        contactCount++;

        System.out.println("Контакт '" + name + "' успешно добавлен!");
    }

    // Просмотр всех контактов
    private static void viewAllContacts() {
        if (contactCount == 0) {
            System.out.println("Список контактов пуст.");
        } else {
            System.out.println("\n=== ВАШИ КОНТАКТЫ ===");
            for (int i = 0; i < contactCount; i++) {
                System.out.println((i + 1) + ". " + names[i] + " - " + phoneNumbers[i]);
            }
        }
    }

    // Поиск контакта
    private static void searchContact() {
        System.out.print("Введите имя для поиска: ");
        String searchName = scanner.nextLine().trim();

        boolean found = false;
        for (int i = 0; i < contactCount; i++) {
            if (names[i].equalsIgnoreCase(searchName)) {
                System.out.println("Телефон " + names[i] + ": " + phoneNumbers[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Контакт с именем '" + searchName + "' не найден.");
        }
    }

    // Удаление контакта
    private static void deleteContact() {
        System.out.print("Введите имя для удаления: ");
        String deleteName = scanner.nextLine().trim();

        int deleteIndex = -1;
        for (int i = 0; i < contactCount; i++) {
            if (names[i].equalsIgnoreCase(deleteName)) {
                deleteIndex = i;
                break;
            }
        }

        if (deleteIndex == -1) {
            System.out.println("Контакт с именем '" + deleteName + "' не найден.");
        } else {

            for (int i = deleteIndex; i < contactCount - 1; i++) {
                names[i] = names[i + 1];
                phoneNumbers[i] = phoneNumbers[i + 1];
            }

            names[contactCount - 1] = null;
            phoneNumbers[contactCount - 1] = null;

            contactCount--;
            System.out.println("Контакт '" + deleteName + "' успешно удален!");
        }
    }
}
