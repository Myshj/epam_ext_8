package task_3;

import java.util.HashMap;
import java.util.Map;

public class Main_3 {
    static Map<String, Integer> m = new HashMap<>();
    public static void main(String[] args) {
        for (int thread = 0; thread < 10; thread++) {
            new Thread(
                    () -> {
                        for (int i = 0; i < 1000; i++) {
                            m.put(Thread.currentThread().toString(), i);
                        }
                    }
            ).start();
        }

        for (int thread = 0; thread < 10; thread++) {
            new Thread(
                    () -> {
                        for (int i = 0; i < 1000; i++) {
                            System.out.println(m);
                        }
                    }
            ).start();
        }

    }
}
