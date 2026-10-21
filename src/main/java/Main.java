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
            System.out.println("3 Завершити роботу");
            System.out.print("Оберіть дію: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    try {
                        System.out.print("Назва: ");
                        String name = scanner.nextLine();
                        System.out.print("Розмір: ");
                        String size = scanner.nextLine();
                        System.out.print("Ціна: ");
                        double price = Double.parseDouble(scanner.nextLine());
                        System.out.print("Колір: ");
                        String color = scanner.nextLine();
                        Clothes newClothes = new Clothes(name, size, price, color);
                        wardrobe.add(newClothes);
                        System.out.println("Об'єкт успішно створено та додано");
                    } catch (NumberFormatException e) {
                        System.out.println("Ціна повинна бути числовим значенням");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Помилка валідації: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Невідома помилка: " + e.getMessage());
                    }
                    break;
                case "2":
                    if (wardrobe.isEmpty()) {
                        System.out.println("Спочатку додайте об'єкти");
                    } else {
                        System.out.println("\nУсі об'єкти");
                        for (Clothes item : wardrobe) {
                            System.out.println(item.toString());
                        }
                    }
                    break;
                case "3":
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