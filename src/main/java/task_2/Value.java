package task_2;

public class Value {
    int value = 0;

    public synchronized int get() {

        try {
            return value;
        } finally {
            notifyAll();
        }

    }

    public synchronized void set(int value) throws InterruptedException {
        this.value = value;
        wait();
    }
}
