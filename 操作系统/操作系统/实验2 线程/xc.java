 class MyRunnable implements Runnable {
    private int threadNum;

    public MyRunnable(int threadNum) {
        this.threadNum = threadNum;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(threadNum + " ");
            }
            System.out.println();
        }
    }
}

public class xc {
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            MyRunnable runnable = new MyRunnable(i);
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}