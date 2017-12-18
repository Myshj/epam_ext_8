package task_2;

public class Printer implements Runnable {
    Value value;

    public Printer(Value value) {
        this.value = value;
    }

    public void run() {
        for (int i = 0; i < 100000; i++){
            System.out.println(value.get());
        }
    }
}
