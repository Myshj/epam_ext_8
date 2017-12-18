package task_1;

public class Main_1 {
    public static void main(String[] args) {
        new Thread(new Runnable(){
            public void run(){
                for (int i = 10; i > 0; i--){
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Bomb!");
            }
        }).start();
    }

}
