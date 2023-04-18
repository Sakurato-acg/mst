import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProcessList {
    public static void main(String[] args) {
        try {
            // 获取内存中运行进程列表
            Process process = Runtime.getRuntime().exec("tasklist.exe /fo csv /nh");

            // 读取进程列表输出
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = reader.readLine() ;//读取第1行
            while (line != null) {
                // 分割进程名和进程ID
            	String [] parts = line.split(",");
            	String name = parts[0].replaceAll("\"", "");
            	String pid = parts[1].replaceAll("\"", "");

                // 输出进程的信息
                System.out.println("Process Name: " + name);
                System.out.println("Process ID: " + pid);
                System.out.println();

                // 读取下一行
                line = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
