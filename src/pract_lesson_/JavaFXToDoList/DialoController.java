package pract_lesson_.JavaFXToDoList;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pract_lesson_.JavaFXToDoList.dataModel.ToDoDataSignletonClass;
import pract_lesson_.JavaFXToDoList.dataModel.ToDoItem;

import java.time.LocalDate;

public class DialoController {
    @FXML
    private TextField descriptionTextField;
    @FXML
    private TextArea detailsTextArea;
    @FXML
    private DatePicker dueDateDatePicker;

    @FXML
    public ToDoItem getDataInput(){
        //changed function return type from void to ToDoItem
        String description = descriptionTextField.getText().trim();
        String details = detailsTextArea.getText().trim();
        LocalDate dueDate = dueDateDatePicker.getValue();

        ToDoItem newItem = new ToDoItem(description,details,dueDate);
        ToDoDataSignletonClass.getInstance().addData(newItem);
        return newItem;
    }
}
