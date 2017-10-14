package company.plugin.windowswitcher.manager.system;

public class OperatingSystem {

    public static boolean isMSWindows()
    {
        return getOS().contains("Windows");
    }

    public static String getOS()
    {
        return System.getProperty("os.name");
    }

}
