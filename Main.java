import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] products = {
                "Молоко",
                "Хлеб",
                "Гречневая крупа",
                "Яйца (десяток)",
                "Масло сливочное",
                "Сахар (1кг)",
                "Рис",
                "Куриное филе",
                "Яблоки (1кг)",
                "Картофель (1кг)"
        };
        int[] prices = {50, 14, 80, 90, 120, 60, 75, 250, 100, 40};

        int[] basketCount = new int[products.length];

        System.out.println("\nДоступны следующие товары:\n");
        for (int i = 0; i < products.length; i++) {
            System.out.printf("%d. %s - %d руб/шт\n", (i + 1), products[i], prices[i]);
        }

        while (true) {
            System.out.println("\nДля набора корзины напишите номер товара и через пробел - количество. " +
                    "Например, '7 3'." + "\nНапишите 'Конец' для завершения.");
            String input = scanner.nextLine().trim();

            if ("конец".equalsIgnoreCase(input)) {
                break;
            }

            String[] parts = input.split("\\s+");
            if (parts.length != 2) {
                System.out.println("Введите два числа через пробел (номер и количество).");
                continue;
            }

            try {
                int productNumber = Integer.parseInt(parts[0]);
                int productCount = Integer.parseInt(parts[1]);

                if (productNumber < 1 || productNumber > products.length) {
                    System.out.println("Товара с таким номером нет.");
                    continue;
                }

                if (productCount <= 0) {
                    System.out.println("Количество должно быть больше нуля.");
                    continue;
                }

                basketCount[productNumber - 1] += productCount;

            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не числа. Попробуйте еще раз.");
            }
        }

        System.out.println("\nВаша корзина:");
        int totalSum = 0;

        for (int i = 0; i < products.length; i++) {
            if (basketCount[i] > 0) {
                int sum = basketCount[i] * prices[i];
                totalSum += sum;
                System.out.printf("%s - %d шт (%d руб/шт), всего %d руб\n", products[i], basketCount[i], prices[i], sum);
            }
        }

        System.out.println("Общая стоимость: " + totalSum + " руб");
        scanner.close();
    }
}

