package 操作系统;

import java.io.IOException;
import javax.swing.JOptionPane;

public class ProcessKill {
    public static void kill() {
        try {
            // 提示用户确认
            int confirm = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to close Notepad?",
                    "Confirm", JOptionPane.YES_NO_OPTION);


            if (confirm == JOptionPane.YES_OPTION) {

                boolean b = ProcessList.getList().containsKey("notepad.exe");
                if (!b){
                    throw new RuntimeException("记事本进程不存在");
                }

                // 关闭记事本进程
                Runtime.getRuntime().exec("taskkill /f /im notepad.exe");
            }

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}