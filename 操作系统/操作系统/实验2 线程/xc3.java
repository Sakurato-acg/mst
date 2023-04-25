class MyRunnable3 implements Runnable {
    private int threadNum;
    private final Object lock;

    public MyRunnable3(int threadNum, Object lock) {
        this.threadNum = threadNum;
        this.lock = lock;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            //synchronized (lock) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(threadNum + " ");
                }
                System.out.println();
                //lock.notifyAll();
                /*try {
                    if (i < 9) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/
        }
    }
}

public class xc3 {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread[] threads = new Thread[6];
        for (int i = 0; i < 6; i++) {
            MyRunnable3 runnable = new MyRunnable3(i, lock);
            threads[i] = new Thread(runnable);
            threads[i].start();
            threads[i].join();
        }
    }
}

