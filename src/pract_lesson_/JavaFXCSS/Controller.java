package pract_lesson_.JavaFXCSS;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;

public class Controller {
    @FXML
    private Label zoomLabel;
    @FXML
    private Button buttonShadow;
    //parent pane for fileChooser
    @FXML
    private GridPane parentGrindPane;

    public void initialize(){
        buttonShadow.setEffect(new DropShadow());
    }

    @FXML
    public void handleMouseEnterEvent(){
        zoomLabel.setScaleX(2.0);
        zoomLabel.setScaleY(2.0);
    }

    @FXML
    public void handleMouseExitEvent(){
        zoomLabel.setScaleX(1.0);
        zoomLabel.setScaleY(1.0);
    }

    @FXML
    public void handleOpenOnActionFileChooser(){
        FileChooser fileChoose = new FileChooser();
        //we need parent pane to pass to restrict other interactions with main scene
        //if pass null interactions are available
        File file = fileChoose.showOpenDialog(parentGrindPane.getScene().getWindow());
        if(file != null){
            System.out.println(file.getPath());
        }
        else{
            System.out.println("Please choose file!");
        }
    }

    @FXML
    public void handleOpenOnActionDirectoryChoose(){
        DirectoryChooser dirChooser = new DirectoryChooser();
        dirChooser.showDialog(parentGrindPane.getScene().getWindow());
    }
}
