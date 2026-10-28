import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Clothes> wardrobe = new ArrayList<>();
        boolean running = true;
        
        while (running) {
            System.out.println("\nМеню");
            System.out.println("1 Створити новий об'єкт");
            System.out.println("2 Вивести інформацію про всі об'єкти");
            System.out.println("3 Створити копію останнього об'єкта");
            System.out.println("4 Завершити роботу");
            System.out.print("Оберіть дію: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    try {
                        System.out.print("Назва: ");
                        String name = scanner.nextLine();
                        // Підказка для введення Enum
                        System.out.print("Розмір (S, M, L, XL, XXL): ");
                        Size size = Size.valueOf(scanner.nextLine().trim().toUpperCase()); 
                        System.out.print("Ціна: ");
                        double price = Double.parseDouble(scanner.nextLine());
                        System.out.print("Колір: ");
                        String color = scanner.nextLine();
                        System.out.print("Назва бренду: ");
                        String brandName = scanner.nextLine();
                        System.out.print("Країна бренду: ");
                        String brandCountry = scanner.nextLine();
                        Brand brand = new Brand(brandName, brandCountry);
                        Clothes newClothes = new Clothes(name, size, price, color, brand);
                        wardrobe.add(newClothes);
                        System.out.println("Об'єкт успішно створено та додано");
                    } catch (NumberFormatException e) {
                        System.out.println("Ціна повинна бути числовим значенням");
                    } catch (IllegalArgumentException e) {
                        // Ця помилка зловить і неправильний розмір (enum), і наші валідації
                        System.out.println("Помилка валідації (можливо, невірний розмір): " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Невідома помилка: " + e.getMessage());
                    }
                    break;
                case "2":
                    if (wardrobe.isEmpty()) {
                        System.out.println("Спочатку додайте об'єкти");
                    } else {
                        // Демонстрація статичного лічильника об'єктів
                        System.out.println("\nУсі об'єкти (Всього об'єктів створено в пам'яті: " + Clothes.getObjectCount() + "):");
                        for (Clothes item : wardrobe) {
                            System.out.println(item.toString());
                        }
                    }
                    break;
                case "3":
                    if (wardrobe.isEmpty()) {
                        System.out.println("Немає об'єктів для копіювання. Спочатку створіть хоча б один");
                    } else {
                        try {
                            Clothes lastItem = wardrobe.get(wardrobe.size() - 1);
                            Clothes copiedItem = new Clothes(lastItem); // Виклик конструктора копіювання
                            wardrobe.add(copiedItem);
                            System.out.println("Копію успішно створено! Загальна кількість об'єктів тепер: " + Clothes.getObjectCount());
                        } catch (Exception e) {
                            System.out.println("Помилка при копіюванні: " + e.getMessage());
                        }
                    }
                    break;
                case "4":
                    running = false;
                    System.out.println("Роботу завершено");
                    break;
                default:
                    System.out.println("Некоректний вибір");
                    break;
            }
        }
        scanner.close();
    }
}