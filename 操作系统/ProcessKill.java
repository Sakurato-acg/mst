import java.io.IOException;
import javax.swing.JOptionPane;

public class ProcessKill {
    public static void main(String[] args) {
        try {
            // 提示用户确认
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to close Notepad?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // 关闭记事本进程
                Runtime.getRuntime().exec("taskkill /f /im notepad.exe");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}