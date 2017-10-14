package company.plugin.windowswitcher.manager.window.list;

import company.plugin.windowswitcher.manager.system.OperatingSystem;

public class WindowListFactory {

    public WindowList create() throws Exception {
        if(OperatingSystem.isMSWindows()) {
            return new CmdowWindowList();
        }
        throw new Exception("OS " + OperatingSystem.getOS() + "not recognized");
    }


}
