package 操作系统;

import java.io.IOException;

public class ProcessRun {
    public static void create() {
        try{
            Runtime.getRuntime().exec("notepad.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}