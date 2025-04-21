package parallel.forkjoin;

import parallel.HeavyJob;
import util.MyLogger;

import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

import static util.MyLogger.log;

public class SumTask extends RecursiveTask<Integer> {

    /**
     * ForkJoinPool 의 경우 람다와의 조합이 좋아서 주로 람다랑 사용됨
     * 기본적으로 실무에서 잘 사용하지는 않음 이런게 있다 정도로 인식하고 필요할 때 쓰도록 하자
     * 계산기능 같은 간단한 작업을 빠르게 처리하기 위해서 사용하고 그 외에는 잘 사용하지 않는 것이 좋음
     */

    private static final int THRESHOLD = 4; // 임계값 - 작업의 크기가 클 경우 그 크기가 THRESHOLD 만큼 될 떄 까지 쪼개어 작업

    private final List<Integer> list;

    public SumTask(List<Integer> list) {
        this.list = list;
    }

    @Override
    protected Integer compute() {
        // 작업 범위가 작으면 직접 계산
        if (list.size() < THRESHOLD) {
//        if (list.size() <= THRESHOLD) {
            log("[처리 시작] " + list);
            int sum = list.stream()
                    .mapToInt(HeavyJob::heavyTask)
                    .sum();
            log("[처리 완료] " + list + " -> sum: " + sum);
            return sum;
        } else {
            // 작업 범위가 크면 병렬처리
            int middle = list.size() / 2;
            List<Integer> leftList = list.subList(0, middle);
            List<Integer> rightList = list.subList(middle, list.size());
            log("[분할] " + list + " -> LEFT: " + leftList + ", RIGHT: " + rightList);

            SumTask leftTask = new SumTask(leftList);
            SumTask rightTask = new SumTask(rightList);

            // 왼쪽 작업은 다른 스레드에서 처리
            leftTask.fork();
            // 오른쪽 작업은 현재 쓰레드에서 처리
            Integer rightResult = rightTask.compute();

            // 왼쪽 작업 결과를 기다림
            Integer leftResult = leftTask.join();
            int joinSum = rightResult + leftResult;
            log("LEFT: [" + leftResult + "]  + RIGHT: [" + rightResult + "] -> joinSum: " + joinSum);

            return joinSum;
        }
    }

}
