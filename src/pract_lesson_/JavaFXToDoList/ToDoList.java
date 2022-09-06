package pract_lesson_.JavaFXToDoList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pract_lesson_.JavaFXToDoList.dataModel.ToDoDataSignletonClass;

import java.io.IOException;

public class ToDoList extends Application {

    @Override
    public void init() throws Exception {
        try{
            ToDoDataSignletonClass.getInstance().loadDataToListFromFile();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
        primaryStage.setTitle("My Todo List");
        primaryStage.setScene(new Scene(root, 900, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        try{
            ToDoDataSignletonClass.getInstance().saveDataFromListToFile();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
