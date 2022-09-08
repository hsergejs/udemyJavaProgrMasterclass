package pract_lesson_.JavaFXToDoList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import pract_lesson_.JavaFXToDoList.dataModel.ToDoDataSignletonClass;
import pract_lesson_.JavaFXToDoList.dataModel.ToDoItem;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class Controller {
    private List<ToDoItem> toDoItem;
    @FXML
    private ListView<ToDoItem> toDoListView;
    @FXML
    private TextArea toDoDetails;
    @FXML
    private Label dueDate;
    @FXML
    private BorderPane mainWindowBorderPane;

    public void initialize(){
//        toDoItem = new ArrayList<>();
//
//        ToDoItem t1 = new ToDoItem("Code for couple of hours", "Currently doing my application",
//                LocalDate.of(2022, Month.SEPTEMBER,05));
//        ToDoItem t2 = new ToDoItem("Collect payment", "Collect payment for one night at hotel",
//                LocalDate.of(2022, Month.SEPTEMBER,06));
//        ToDoItem t3 = new ToDoItem("Utility bills", "Complete payment for apartment utility bills",
//                LocalDate.of(2022, Month.AUGUST,02));
//
//        toDoItem.add(t1);
//        toDoItem.add(t2);
//        toDoItem.add(t3);
//
//        //temp create file to store hardcoded toDoItems
//        ToDoDataSignletonClass.getInstance().setItems(toDoItem);

        //adding listener to listen to any changes (remove mouseListener (#handleClickEventListView))
        toDoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ToDoItem>() {
            @Override
            public void changed(ObservableValue<? extends ToDoItem> observableValue, ToDoItem oldVal, ToDoItem newVal) {
                if(newVal != null){
                    ToDoItem t = toDoListView.getSelectionModel().getSelectedItem();
                    toDoDetails.setText(t.getDetails());
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM d, YYYY");
                    dueDate.setText(dtf.format(t.getDueDate()));
                }
            }
        });
        //set to single selection of item in listView
        toDoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        populateListView();
        //to select and further display first item in list on load
        toDoListView.getSelectionModel().selectFirst();
    }

    @FXML
    public void showDialogNewItem(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainWindowBorderPane.getScene().getWindow());
        //setting title programmatically
        dialog.setTitle("Create new ToDo'ish");
        //start of split approach to load dialog
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("toDoDialog.fxml"));
        try{
            //to get data from dialog pane, use split load approach
//            Parent root = FXMLLoader.load(getClass().getResource("toDoDialog.fxml"));
//            dialog.getDialogPane().setContent(root);
            //use to load dialog
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }
        catch(IOException e){
            System.out.println("Couldn't load the dialog window!");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> resultButtonPress = dialog.showAndWait();
        if(resultButtonPress.isPresent() && resultButtonPress.get() == ButtonType.OK){
            //getting toDoDialogController
            DialoController dialogController = fxmlLoader.getController();
            //load data from form
            //new return new ToDoItem
            ToDoItem newItem = dialogController.getDataInput();
            //hardcoded scene update, reload list of items
            populateListView();
            //highlight newly added item, so it will show up after adding item on the screen
            //select last item
            toDoListView.getSelectionModel().select(newItem);
        }
        else{
            System.out.println("Cancel");
        }
    }
    
    private void populateListView(){
        //set data from singleton class
        toDoListView.getItems().setAll(ToDoDataSignletonClass.getInstance().getItems());
        //toDoListView.getItems().setAll(toDoItem);
    }

    @FXML
    public void handleClickEventListView(){
        ToDoItem toDoItem = toDoListView.getSelectionModel().getSelectedItem();
//        StringBuilder sb = new StringBuilder(toDoItem.getDetails());
//        sb.append("\n\n\n\n");
//        sb.append("Due date: " + toDoItem.getDueDate());
//        sb.append("\n");
//        toDoDetails.setText(sb.toString());

        toDoDetails.setText(toDoItem.getDetails());
        dueDate.setText(toDoItem.getDueDate().toString());
    }
}
