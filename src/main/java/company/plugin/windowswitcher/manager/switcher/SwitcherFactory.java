package company.plugin.windowswitcher.manager.switcher;

import company.plugin.windowswitcher.manager.system.OperatingSystem;

public class SwitcherFactory {

    public Switcher create() throws Exception {
        if(OperatingSystem.isMSWindows()) {
            return new CmdowSwitcher();
        }
        throw new Exception("OS " + OperatingSystem.getOS() + "not recognized");
    }

}
