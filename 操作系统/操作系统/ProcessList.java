package 操作系统;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ProcessList {
    public static Map<String, String> getList()  {
        try {
            // 获取内存中运行进程列表
            Process process = Runtime.getRuntime().exec("tasklist.exe /fo csv /nh");

            // 读取进程列表输出
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = reader.readLine();//读取第1行

            Map<String, String> map = new HashMap<>();

            while (line != null) {
                // 分割进程名和进程ID
                String[] parts = line.split(",");
                String name = parts[0].replaceAll("\"", "");
                String pid = parts[1].replaceAll("\"", "");

                // 输出进程的信息
//                System.out.println("Process Name: " + name);
//                System.out.println("Process ID: " + pid);
//                System.out.println();
                map.put(name, pid);
                // 读取下一行
                line = reader.readLine();
            }
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
