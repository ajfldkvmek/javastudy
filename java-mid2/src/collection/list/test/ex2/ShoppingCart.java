package collection.list.test.ex2;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Item> itemList = new ArrayList();
    private int totalPrice = 0;

    public void add(Item item){
        itemList.add(item);
    }

    public void display(){
        for (Item item : itemList) {
            System.out.println(item.getName() + " " + item.getPrice() + " " + item.getTotalPrice());
        }
    }

    public int getTotalPrice(){
        for (Item item : itemList) {
            totalPrice += item.getPrice()*item.getQuantity();
        }
        return totalPrice;
    }
}
