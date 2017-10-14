package company.plugin.windowswitcher.manager;

import company.plugin.windowswitcher.manager.hotkeys.DownKeyListener;
import company.plugin.windowswitcher.manager.hotkeys.LeftKeyListener;
import company.plugin.windowswitcher.manager.hotkeys.RightKeyListener;
import company.plugin.windowswitcher.manager.hotkeys.UpKeyListener;
import company.plugin.windowswitcher.manager.switcher.Switcher;
import company.plugin.windowswitcher.manager.switcher.SwitcherFactory;
import company.plugin.windowswitcher.manager.window.*;

public class Manager {

    private SwitcherFactory windowSwitcherFactory;
    private WindowRetriever windowRetriever;
    private Switcher windowSwitcher;

    public static void main(String[] args) {
        try {
            Manager manager = new Manager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Manager() throws Exception
    {
        initKeyListeners();
        initWindowRetriever();
        initWindowSwitcher();
    }

    public WindowRetriever getWindowRetriever() {
        return windowRetriever;
    }

    private void initKeyListeners()
    {
        new LeftKeyListener("control alt LEFT",this);
        new RightKeyListener("control alt RIGHT",this);
        new DownKeyListener("control alt DOWN",this);
        new UpKeyListener("control alt UP",this);
    }

    private void initWindowRetriever() throws Exception {
        windowRetriever = new WindowRetriever();
    }

    private void initWindowSwitcher() throws Exception {
        windowSwitcherFactory = new SwitcherFactory();
        windowSwitcher = windowSwitcherFactory.create();
    }

    public void switchToLeft()
    {
        System.out.println("Time to switch to left");
        long startTime = System.currentTimeMillis();
        windowSwitcher.switchToWindow(
                windowRetriever.getWindowToLeft()
        );
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);
    }

    public void switchToRight()
    {
        windowSwitcher.switchToWindow(
                windowRetriever.getWindowToRight()
        );
        System.out.println("Time to switch to right");
    }

    public void switchToBelow()
    {
        windowSwitcher.switchToWindow(
                windowRetriever.getWindowBelow()
        );
        System.out.println("Time to switch to window below");
    }

    public void switchToAbove()
    {
        windowSwitcher.switchToWindow(
                windowRetriever.getWindowAbove()
        );
        System.out.println("Time to switch to window above");
    }




}
