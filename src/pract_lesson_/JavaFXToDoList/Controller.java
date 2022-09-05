package pract_lesson_.JavaFXToDoList;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import pract_lesson_.JavaFXToDoList.dataModel.ToDoItem;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<ToDoItem> toDoItem;
    @FXML
    private ListView<ToDoItem> toDoListView;
    @FXML
    private TextArea toDoDetails;

    public void initialize(){
        toDoItem = new ArrayList<>();

        ToDoItem t1 = new ToDoItem("Code for couple of hours", "Currently doing my ToDo application",
                LocalDate.of(2022, Month.SEPTEMBER,05));
        ToDoItem t2 = new ToDoItem("Collect payment", "Collect payment for one night at hotel",
                LocalDate.of(2022, Month.SEPTEMBER,06));
        ToDoItem t3 = new ToDoItem("Utility bills", "Complete payment for apartment utility bills",
                LocalDate.of(2022, Month.AUGUST,02));

        toDoItem.add(t1);
        toDoItem.add(t2);
        toDoItem.add(t3);

        //set to single selection of item in listView
        toDoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        populateListView();
    }

    private void populateListView(){
        toDoListView.getItems().setAll(toDoItem);
    }

    @FXML
    public void handleClickEventListView(){
        ToDoItem toDoItem = toDoListView.getSelectionModel().getSelectedItem();
        StringBuilder sb = new StringBuilder(toDoItem.getDetails());
        sb.append("\n\n\n\n");
        sb.append("Due date: " + toDoItem.getDueDate());
        sb.append("\n");
        toDoDetails.setText(sb.toString());
    }
}
