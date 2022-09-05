package pract_lesson_.JavaFX;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField textField;
    @FXML
    private Button hiButton;
    @FXML
    private Button byeButton;
    @FXML
    private Label threadLabel;

    @FXML
    public void initialize() {
        hiButton.setDisable(true);
        byeButton.setDisable(true);
    }

    @FXML
    public void onButtonClick(ActionEvent e){
        if(e.getSource().equals(hiButton)){
            System.out.println("Hi " + textField.getText());
        }
        else if(e.getSource().equals(byeButton)){
            System.out.println("Buy buy " + textField.getText());
        }
        else{
            System.out.println("None buttons are pressed!");
        }

        Runnable task = new Runnable() {
            @Override
            public void run() {
                try{
                    //to debug thread code in javaFX
                    String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background thread";
                    System.out.println("I'm going to sleep on the " + s);
                    Thread.sleep(10000);
                    //Allow to remove thread concurrency and avoid app crash
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background thread";
                            System.out.println("I'm updating label on the " + s);
                            threadLabel.setText("Thread FINISHED");
                        }
                    });
                }
                catch(InterruptedException event){
                    //none
                }
            }
        };

        new Thread(task).start();
    }

    @FXML
    public void handleKeyPress(){
        String fieldValue = textField.getText();
        boolean disableButton = fieldValue.isEmpty() || fieldValue.trim().isEmpty();
        byeButton.setDisable(disableButton);
        hiButton.setDisable(disableButton);
    }
}
