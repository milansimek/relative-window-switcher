package company.plugin.windowswitcher.manager.system.win;

import java.util.ArrayList;

public class Cmdow {

    public static final int HANDLE = 0;
    public static final int IS_ACTIVE = 4;
    public static final int LEFT = 7;
    public static final int TOP = 8;
    public static final int WIDTH = 9;
    public static final int HEIGHT = 10;

    public static void main(String[] args)
    {
        for(String line: getWindowList())
        {
            System.out.println(line);
        }
    }

    public static final ArrayList<String> getWindowList()
    {
        return runCommand("/t /p /b");
    }

    public static final void switchToWindowHandle(String handle)
    {
        runCommandNoReturn(handle + " /ACT");
    }

    public static final ArrayList<String> runCommand(String args)
    {
        return Cmd.exec(String.format("%s %s", cmdowExePath(), args));
    }

    public static final void runCommandNoReturn(String args)
    {
        Cmd.execNoReturn(String.format("%s %s", cmdowExePath(), args));
    }

    private static String cmdowExePath()
    {
        return (projectSourcePath() + cmdowExePathInProject()).toLowerCase();

    }

    private static String projectSourcePath() {
        return System.getProperty("user.dir") + "\\src\\main\\java\\";
    }

    private static String cmdowExePathInProject()
    {
        return Cmdow.class.getName().replace(".", "\\") + ".exe";
    }
}
