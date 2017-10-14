# relative-window-switcher
Switch windows based on position relative to the current active window using a shortcut key combination.

### --> Work in progress

The window switcher already works when running the Main method in the Manager class.

Hotkeys:

CTRL + ALT + LEFT => Switch to window left of active window   
CTRL + ALT + RIGHT => Switch to window right of active window    
CTRL + ALT + DOWN => Switch to window below active window   
CTRL + ALT + UP => Switch to window above active window


### TODO
* Move to JNA or similar instead of CMDOW which is used now for interaction with Windows 10 window manager. CMDOW execution is slow.
* Optimize algorithm when switching to overlapping windows
* Add GUI where hotkeys can be set
* Add tray icon
* Package as executable
