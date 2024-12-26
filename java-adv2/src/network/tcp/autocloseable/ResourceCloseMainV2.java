package network.tcp.autocloseable;

public class ResourceCloseMainV2 {

    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("CallException 예외 처리");
            throw new RuntimeException(e);
        } catch (CloseException e) {
            System.out.println("CloseException 예외 처리");
            throw new RuntimeException(e);
        }

    }

    private static void logic() throws CallException, CloseException {
        ResourceV1 resource1 = null;
        ResourceV1 resource2 = null;

        try {
            resource1 = new ResourceV1("resource1");
            resource2 = new ResourceV1("resource2");

            resource1.call();
            resource2.callEx(); //Exception
        } catch(CallException e) {
            System.out.println("ex" + e);
            throw e;
        } finally {
//            System.out.println("자원 정리");
            if (resource2 != null) {
                resource2.closeEx();
                // CallEx 가 발생하고 CloseEx 가 다시 발행하게되면 이전에 발생한 CallEx 에 관한 내용은 사라지게됨
                // 또한 아래 resource1 객체는 또 닿지 못하는 문제가 발생한다!
            }
            if (resource1 != null) {
                resource1.close();
            }
        }
    }
}
