package company.plugin.windowswitcher.manager.hotkeys;

import com.tulskiy.keymaster.common.HotKey;
import company.plugin.windowswitcher.manager.Manager;

public class RightKeyListener extends KeyListener
{
    public RightKeyListener(String hotkey, Manager listener) {
        super(hotkey, listener);
    }

    @Override
    public void onHotKey(HotKey hotKey) {
        listener.switchToRight();
    }
}
