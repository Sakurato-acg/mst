class MyRunnable2 implements Runnable {
    private int threadNum;
    private final Object lock;

    public MyRunnable2(int threadNum, Object lock) {
        this.threadNum = threadNum;
        this.lock = lock;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (lock) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(threadNum + " ");
                }
                System.out.println();
                lock.notifyAll();
                try {
                    if (i < 9) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class xc2 {
    public static void main(String[] args) {
        Object lock = new Object();
        for (int i = 0; i < 6; i++) {
            MyRunnable2 runnable = new MyRunnable2(i, lock);
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}
