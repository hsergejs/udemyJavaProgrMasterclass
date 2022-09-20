package pract_lesson_.JavaFXCSS;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFXApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("javaFXApplication.fxml"));
        //setting another theme
        setUserAgentStylesheet(STYLESHEET_CASPIAN);
        primaryStage.setTitle("Window title");
        primaryStage.setScene(new Scene(root, 600, 250));
        primaryStage.show();
    }

}

