package pract_lesson_.JavaFXCSS;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
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
    @FXML
    private WebView webView;

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
        fileChoose.setTitle("Save/download a file");
        //we need parent pane to pass to restrict other interactions with main scene
        //if pass null in showOpenDialog interactions are available
        //showOpenDialog is to upload a file
        //File file = fileChoose.showOpenDialog(parentGrindPane.getScene().getWindow());
        //showSaveDialog to save a file
        //we can restrict file extension/s for our application
        fileChoose.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text","*.txt"),
                new FileChooser.ExtensionFilter("Adobe PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("Image files", "*.jpg","*.jpeg","*.png"),
                new FileChooser.ExtensionFilter("All files", "*.*")
        );
        File file = fileChoose.showSaveDialog(parentGrindPane.getScene().getWindow());
        //to choose multiple files
//        List<File> file = fileChoose.showOpenMultipleDialog(parentGrindPane.getScene().getWindow());
        if(file != null){
            System.out.println(file.getPath());
        }
        else{
            System.out.println("Please choose a file!");
        }
    }

    @FXML
    public void handleOpenOnActionDirectoryChoose(){
        DirectoryChooser dirChooser = new DirectoryChooser();
        dirChooser.showDialog(parentGrindPane.getScene().getWindow());
    }

    @FXML
    public void handleOnActionLinkClick(){
        //open default browser
//        try {
//            Desktop.getDesktop().browse(new URI("www.google.com"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }

        //to use a webview
        WebEngine webEngine = webView.getEngine();
        webEngine.load("http://www.google.com"); //path with https or http
    }
}
