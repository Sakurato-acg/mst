import java.io.IOException;

public class ProcessRun {
    public static void main(String[] args) {
        try {
            // 运行记事本进程
            Runtime.getRuntime().exec("notepad.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}