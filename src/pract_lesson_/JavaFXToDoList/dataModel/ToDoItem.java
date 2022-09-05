package pract_lesson_.JavaFXToDoList.dataModel;

import java.time.LocalDate;

public class ToDoItem {
    private String description;
    private String details;
    private LocalDate dueDate;

    public ToDoItem(String description, String details, LocalDate dueDate) {
        this.description = description;
        this.details = details;
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
