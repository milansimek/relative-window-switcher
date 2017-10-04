package company.plugin.windowswitcher.manager.window.list;

public class WindowListFactory {

    public WindowList create() throws Exception {
        if(isMSWindows()) {
            return new CmdowWindowList();
        }
        throw new Exception("OS " + getOS() + "not recognized");
    }

    private boolean isMSWindows()
    {
        return getOS().contains("Windows");
    }

    private String getOS()
    {
        return System.getProperty("os.name");
    }

}
