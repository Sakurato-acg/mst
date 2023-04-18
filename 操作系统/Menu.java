package 操作系统;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Menu {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("--------菜单--------");
            System.out.println("1.退出程序");
            System.out.println("2.进程列表");
            System.out.println("3.创建记事本进程");
            System.out.println("4.销毁记事本进程");
            System.out.println("--------菜单--------");

            System.out.println("输入序号");
            int i = kb.nextInt();

            try {
                switch (i) {
                    case 1:
                        flag = false;
                        break;
                    case 2:
                        processList();
                        break;
                    case 3:
                        Map<String, String> list = ProcessList.getList();
                        if (list != null) {
                            boolean b = list.containsKey("notepad.exe");
                            if (b) {
                                System.err.println("记事本进程已存在");
                                break;
                            }
                            ProcessRun.create();
                        }
                        break;
                    case 4:
                        ProcessKill.kill();
                        break;

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void processList() throws IOException {
        Map<String, String> map = ProcessList.getList();
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        System.out.println("--------进程列表--------");
        entrySet.forEach(item -> {
            String key = item.getKey();
            String value = item.getValue();
            System.out.printf("进程名:%s\t pid:%s\t\n", key, value);
        });
        System.out.println("--------进程列表--------");
        System.out.println();
        System.out.println();
    }
}
