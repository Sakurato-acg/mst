class MyRunnable1 implements Runnable {
    private int threadNum;
    private final Object lock;

    public MyRunnable1(int threadNum, Object lock) {
        this.threadNum = threadNum;
        this.lock = lock;
    }

    public void run() {
    	synchronized (lock) {
        for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(threadNum + " ");
                }
                System.out.println();           
            }
        lock.notifyAll();
        
        }
    }
}

public class xc1 {
    public static void main(String[] args) {
        Object lock = new Object();
        for (int i = 0; i < 6; i++) {
            MyRunnable1 runnable = new MyRunnable1(i, lock);
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}
