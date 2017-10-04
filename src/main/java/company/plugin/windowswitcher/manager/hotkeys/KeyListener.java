package company.plugin.windowswitcher.manager.hotkeys;

import com.tulskiy.keymaster.common.HotKey;
import com.tulskiy.keymaster.common.HotKeyListener;
import com.tulskiy.keymaster.common.Provider;
import company.plugin.windowswitcher.manager.Manager;

import javax.swing.*;

abstract public class KeyListener implements HotKeyListener
{
    private String hotkey;
    private Provider provider;
    protected Manager listener;

    public KeyListener(String hotkey, Manager listener) {
        this.provider = Provider.getCurrentProvider(false);
        this.listener = listener;
        this.hotkey = hotkey;
        registerHotKey();
    }

    public void registerHotKey()
    {
        provider.register(KeyStroke.getKeyStroke(hotkey), this);
    }

}
