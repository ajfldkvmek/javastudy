package collection.deque.test.ex2.cart;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Product, Integer> cartMap = new HashMap<>();

    public void add(Product product, int addQuantity){
        Integer existQuantity = cartMap.getOrDefault(product, 0);
        cartMap.put(product, existQuantity+addQuantity);
    }

    public void printAll(){
        System.out.println("===모든 상품 출력===");
        for(Map.Entry<Product, Integer> entry : cartMap.entrySet()){
            System.out.println("상품: " + entry.getKey() + ", 수량: " + entry.getValue());
        }
    }

    public void minus(Product product, int minusQuantity){
        Integer existQuantity = cartMap.getOrDefault(product, 0);
        int result = existQuantity-minusQuantity;

        if(result > 0) {
            cartMap.put(product, result);
        } else {
            cartMap.remove(product);
        }
    }

}
