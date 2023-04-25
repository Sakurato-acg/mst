package xiancheng;
class ReadRunnable implements Runnable {
   private int n;

   public ReadRunnable(int n) {
       this.n = n;
   }

   public void run() {
       // read thread
       for (int i = 0; i < 10; i++) {
          // for (int j = 0; j < 8; j++) {
           System.out.println(""+n+n+n+n+n+n+n+n);
          // }
          // System.out.println();
           /*try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}*/
       }
   }
}

public class xiancheng2 
{
   public static void main(String[] args) 
   {
       int i;
       for(i=0;i<5;i++)
       {
          ReadRunnable readRunnable = new ReadRunnable(i);     
          Thread readThread = new Thread(readRunnable);    
          readThread.start();
       }
   }
}


