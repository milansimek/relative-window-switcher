package company.plugin.windowswitcher.manager.window.list;

import company.plugin.windowswitcher.manager.system.win.Cmdow;
import company.plugin.windowswitcher.manager.window.Window;

import java.util.ArrayList;

public class CmdowWindowList implements WindowList
{

    private ArrayList<String> cmdowResult;
    private ArrayList<Window> windows = new ArrayList();

    public static void main(String[] args) {
        CmdowWindowList self = new CmdowWindowList();
        ArrayList windows = self.getWindows();
        String bla = System.getProperty("os.name");
    }

    public CmdowWindowList() {
        startWindowPolling();
    }

    public void startWindowPolling()
    {
        Runnable runnable = () -> {
            String name = Thread.currentThread().getName();
            while(true){
                retrieveWindowsFromCmdow();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public ArrayList<Window> getWindows()
    {
        initWindows();
        return this.windows;
    }

    private void initWindows()
    {
        clearWindows();
        addWindowsFromResult();
    }

    private void clearWindows()
    {
        this.windows.clear();
    }

    private void retrieveWindowsFromCmdow()
    {
        cmdowResult = Cmdow.getWindowList();
    }

    private void addWindowsFromResult()
    {
        for(String line: cmdowResult){
            if(!canAddWindow(line)) continue;
            addWindow(createWindowFromLine(line));
        }
    }

    private boolean canAddWindow(String line)
    {
        String[] data = line.split("\\s+");
        if(data[Cmdow.TOP].equals("0") && data[Cmdow.LEFT].equals("0")){
            return false;
        }
        if(data[Cmdow.TOP].equals("1") && data[Cmdow.LEFT].equals("1")){
            return false;
        }
        return true;
    }

    private void addWindow(Window window)
    {
        this.windows.add(window);
    }

    private Window createWindowFromLine(String line) {
        String[] data = line.split("\\s+");
        return new Window(
                data[Cmdow.HANDLE],
                convertStatusToBool(data[Cmdow.IS_ACTIVE]),
                data[Cmdow.LEFT],
                data[Cmdow.TOP],
                data[Cmdow.WIDTH],
                data[Cmdow.HEIGHT]
        );
    }

    private boolean convertStatusToBool(String status)
    {
        return status.equals("Act");
    }


}
