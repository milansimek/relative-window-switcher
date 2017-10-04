package company.plugin.windowswitcher.manager.window;

import company.plugin.windowswitcher.manager.window.list.WindowList;
import company.plugin.windowswitcher.manager.window.list.WindowListFactory;

import java.util.ArrayList;

public class WindowRetriever {

    private WindowListFactory windowListFactory;
    private WindowList windowList;

    private ArrayList<Window> allWindows;
    private ArrayList<Window> inactiveWindows = new ArrayList();
    private Window activeWindow;

    public WindowRetriever() throws Exception
    {
        this.windowListFactory = new WindowListFactory();
        this.windowList = this.windowListFactory.create();
    }

    public Window getWindowToLeft()
    {
        update();
        Window candidate = null;
        for(Window window: inactiveWindows) {
            //not on left of window
            if(window.getLeft() >= activeWindow.getLeft()) continue;

            //overlapping or touching window: match
            if(window.getRight() >= activeWindow.getLeft()) return window;

            //not overlapping or touching, but good candidate
            if(candidate == null){
                candidate = window;
                continue;
            }

            //compare with other candidate
            if(window.getRight() > candidate.getRight()){
                candidate = window;
            }
        }
        return candidate;
    }

    public Window getWindowToRight()
    {
        update();
        Window candidate = null;
        for(Window window: inactiveWindows) {
            //not on right of window
            if(window.getRight() <= activeWindow.getRight()) continue;

            //overlapping or touching window: match
            if(window.getLeft() <= activeWindow.getRight()) return window;

            //not overlapping or touching, but good candidate
            if(candidate == null){
                candidate = window;
                continue;
            }

            //compare with other candidate
            if(window.getLeft() < candidate.getLeft()){
                candidate = window;
            }
        }
        return candidate;
    }

    public Window getWindowToBottom()
    {
        update();
        Window candidate = null;
        for(Window window: inactiveWindows) {
            //not below window
            if(window.getBottom() >= activeWindow.getBottom()) continue;

            //overlapping or touching window: match
            if(window.getTop() >= activeWindow.getBottom()) return window;

            //not overlapping or touching, but good candidate
            if(candidate == null){
                candidate = window;
                continue;
            }

            //compare with other candidate
            if(window.getTop() > candidate.getTop()){
                candidate = window;
            }
        }
        return candidate;
    }

    private void update()
    {
        retrieveAllWindows();
        updateActiveWindow();
        updateInactiveWindows();
    }

    private void retrieveAllWindows()
    {
        allWindows = windowList.getWindows();
    }

    private void updateActiveWindow()
    {
        for(Window window: allWindows){
            if(window.isActive()) activeWindow = window;
        }
    }

    private void updateInactiveWindows()
    {
        inactiveWindows.clear();
        for(Window window: allWindows){
            if(window.isActive()) continue;
            inactiveWindows.add(window);
        }
    }

}
