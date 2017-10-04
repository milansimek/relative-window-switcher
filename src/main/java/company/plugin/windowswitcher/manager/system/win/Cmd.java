package company.plugin.windowswitcher.manager.system.win;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Cmd {

    public static ArrayList<String> exec(String command)
    {
        ArrayList<String> result = new ArrayList();
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader=new BufferedReader( new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null){
                result.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void execNoReturn(String command)
    {
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
