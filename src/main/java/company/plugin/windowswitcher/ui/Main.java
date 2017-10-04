package company.plugin.windowswitcher.ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import arduino.*;

public class Main extends Application {

    private Arduino arduino;
    private SampleController controller;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Hello World");
        controller = loader.getController();
        controller.setStage(primaryStage);
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
//        initArduino();
//        debugArduinoSerial();
    }

    public void initArduino()
    {
        arduino = new Arduino("COM5",9600);
        arduino.openConnection();
    }

    public void debugArduinoSerial()
    {
        Task task = new Task<Void>() {
            @Override public Void call() {
                Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
                while(true){
                    if (isCancelled()) {
                        break;
                    }
                    Platform.runLater(() -> printArduinoSerialInUI());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        };
        new Thread(task).start();
    }

    public void printArduinoSerial()
    {
        String output = readArduinoSerial();
        if (output.isEmpty()) {
            return;
        }
        System.out.println(output);
    }

    public void printArduinoSerialInUI()
    {
        String output = readArduinoSerial();
        if (output.isEmpty()) {
            return;
        }
        controller.helloWorld.setText(output);
    }



    public String readArduinoSerial()
    {
        return arduino.serialRead();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
