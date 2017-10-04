package company.plugin.windowswitcher.manager.switcher;

import company.plugin.windowswitcher.manager.system.win.Cmdow;
import company.plugin.windowswitcher.manager.window.Window;

public class CmdowSwitcher implements Switcher {

    public void switchToWindow(Window window)
    {
        long startTime = System.currentTimeMillis();
        Cmdow.switchToWindowHandle(window.getHandle());
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("switchToWindow");
        System.out.println(elapsedTime);
    }

}
