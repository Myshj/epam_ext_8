package task_4;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Main {
    private static long N = 1000000;

    private static final int COUNT_OF_THREADS = 5;
    static class RecursiveSum extends RecursiveTask<Long>{
        long from;
        long to;

        public RecursiveSum(
                long from,
                long to
        ) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if (to - from <= 20){
                return LongStream.range(from, to + 1).sum();
            }
            long mid = (from + to) / 2;
            RecursiveSum leftHalf = new RecursiveSum(from, mid);
            leftHalf.fork();
            RecursiveSum rightHalf = new RecursiveSum(mid + 1, to);
            rightHalf.fork();
            return leftHalf.compute() + rightHalf.compute();
        }
    }
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(COUNT_OF_THREADS);
        long computedSum = pool.invoke(new RecursiveSum(0, N));
        long expectedSum = (N * (N + 1)) / 2;

        System.out.println("Computed sum: " + computedSum);
        System.out.println("Expected sum: " + expectedSum);
    }
}
