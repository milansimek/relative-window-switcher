package company.plugin.windowswitcher.ui;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SampleController {

    public Label helloWorld;
    private Stage stage;

    public void sayHelloWorld(ActionEvent actionEvent) throws AWTException {
        helloWorld.setText(String.valueOf(stage.getX()));
        altTab();
        actionEvent.getEventType();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void altTab() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.delay(100);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.delay(500);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
