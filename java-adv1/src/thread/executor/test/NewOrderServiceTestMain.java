package thread.executor.test;

import java.util.concurrent.ExecutionException;

public class NewOrderServiceTestMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String orderNo = "asdasdas123";
        NewOrderService newOrderService = new NewOrderService();
        newOrderService.order(orderNo);
    }
}
