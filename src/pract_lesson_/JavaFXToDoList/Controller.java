package pract_lesson_.JavaFXToDoList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import pract_lesson_.JavaFXToDoList.dataModel.ToDoDataSignletonClass;
import pract_lesson_.JavaFXToDoList.dataModel.ToDoItem;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class Controller {
    private List<ToDoItem> toDoItem;
    @FXML
    private ListView<ToDoItem> toDoListView;
    @FXML
    private TextArea toDoDetails;
    @FXML
    private Label dueDate;

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
