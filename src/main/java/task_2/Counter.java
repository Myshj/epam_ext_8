package task_2;

public class Counter implements Runnable {
    public Value a;

    public Counter(Value a) {
        this.a = a;
    }

    public void run() {

        for (int i = 0; i < 100000; i++) {
            try {
                a.set(a.get() + 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
