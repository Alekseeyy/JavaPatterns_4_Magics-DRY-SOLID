import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Basket basket = fullBasket();
        printCheck(basket);
    }

    private static Basket fullBasket() {
        Basket basket = new Basket();

        while (true) {
            printBasketHint();

            String operation = scanner.nextLine();
            switch (operation) {
                case "+":
                    String code = getProductCode();
                    basket.addProduct(code);
                    break;
                case "-":
                    String code1 = getProductCode();
                    basket.deleteProduct(code1);
                    break;
                default:
                    return basket;
            }
        }
    }

    private static void printBasketHint() {
        System.out.println("Введите одно из следующих значений:");
        System.out.println("'+' - чтобы добавить товар");
        System.out.println("'-' - чтобы удалить товар");
        System.out.println("любое другое значение, чтобы завершить покупки и перейти к оплате");
    }

    private static String getProductCode() {
        System.out.println("Ассортимент магазина:");
        ShopUtils.printAllProducts();
        System.out.println("Введите код товара:");
        return scanner.nextLine();
    }

    private static void printCheck(Basket basket) {
        printCheckHint();

        CheckCounterService checkCounterService;
        String operation = scanner.nextLine();
        switch (operation) {
            case "1":
                checkCounterService = new CashMachine();
                break;
            case "2":
                checkCounterService = new OnlineShoppingSystem();
                break;
            default:
                System.out.println("Покупки отменены");
                return;
        }
        int totalSum = checkCounterService.getTotalSum(basket);
        if (totalSum == 0) {
            System.out.println("Вы ничего не купили");
        } else if ("1".equals(operation)) {
            System.out.println("Общая сумма покупок: " + totalSum + " руб.");
        } else if ("2".equals(operation)) {
            System.out.println("Общая сумма покупок: " + totalSum + " руб.\n" +
                    "(Скидка 10% + Доставка 1000 руб.)");
        }
    }

    private static void printCheckHint() {
        System.out.println("Где вы хотите купить товары? Введите:");
        System.out.println("'1' - если хотите купить товары в нашем магазине в Москве");
        System.out.println("'2' - если хотите заказать товары в интернет-магазине");
        System.out.println("любое другое значение, чтобы отменить покупки");
    }
}
