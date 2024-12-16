package collection.list.test.ex2;

public class ShoppingMain {

    public static void main(String[] args) {

        ShoppingCart shoppingCart = new ShoppingCart();

        Item item1 = new Item("마늘", 2000, 2);
        Item item2 = new Item("상추", 3000, 5);

        shoppingCart.add(item1);
        shoppingCart.add(item2);

        shoppingCart.display();

        System.out.println("총금액: " + shoppingCart.getTotalPrice());

    }
}
