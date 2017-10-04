package company.plugin.windowswitcher.manager.switcher;

public class SwitcherFactory {

    public Switcher create() throws Exception {
        if(isMSWindows()) {
            return new CmdowSwitcher();
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
