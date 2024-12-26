package thread.executor.test;

import java.util.List;
import java.util.concurrent.*;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class NewOrderService {

    private final ExecutorService es = Executors.newFixedThreadPool(10);

    public void order(String orderNo) throws ExecutionException, InterruptedException {
        InventoryWork iw = new InventoryWork(orderNo);
        ShippingWork sw = new ShippingWork(orderNo);
        AccountingWork aw = new AccountingWork(orderNo);

        //작업 ExecutorService 에 제출

        Future<Boolean> inventoryFuture = es.submit(iw);
        Future<Boolean> shippingFuture = es.submit(sw);
        Future<Boolean> accountFuture = es.submit(aw);

        //작업 완료 waiting
        Boolean inventoryResult = inventoryFuture.get();
        Boolean shippingResult = shippingFuture.get();
        Boolean accountResult = accountFuture.get();

        if(inventoryResult && shippingResult && accountResult) {
            log("모든 주문 완료!");
        } else {
            log("일부 작업 실패");
        }
//        List<Future<Boolean>> fl =
    }

    static class InventoryWork implements Callable<Boolean> {

        private final String orderNo;

        public InventoryWork(String orderNo) {
            this.orderNo = orderNo;
        }

        @Override
        public Boolean call() throws Exception {
            log("장바구니 시스템 업데이트::" + orderNo);
            sleep(1000);
            return true;
        }
    }

    static class ShippingWork implements Callable<Boolean> {

        private String orderNo;

        public ShippingWork(String orderNo) {

            this.orderNo = orderNo;
        }

        @Override
        public Boolean call() throws Exception {
            log("배송 시스템 업데이트::" + orderNo);
            sleep(1000);
            return true;
        }
    }

    static class AccountingWork implements Callable<Boolean> {

        private final String orderNo;

        public AccountingWork(String orderNo) {
            this.orderNo = orderNo;
        }

        @Override
        public Boolean call() throws Exception {
            log("회계 시스템 업데이트::" + orderNo);
            sleep(1000);
            return true;
        }
    }
}
