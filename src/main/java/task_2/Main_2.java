package task_2;

public class Main_2 {
    static Value a =new Value();
    public static void main(String[] args) {
        new Thread(
                new Counter(a)
        ).start();
        new Thread(
                new Printer(a)
        ).start();
    }
}
