package company.plugin.windowswitcher.manager.hotkeys;

import com.tulskiy.keymaster.common.HotKey;
import company.plugin.windowswitcher.manager.Manager;

public class DownKeyListener extends KeyListener
{
    public DownKeyListener(String hotkey, Manager listener) {
        super(hotkey, listener);
    }

    @Override
    public void onHotKey(HotKey hotKey) {
        listener.switchToBelow();
    }
}
