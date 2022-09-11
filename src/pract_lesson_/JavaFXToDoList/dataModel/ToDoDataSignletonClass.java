package pract_lesson_.JavaFXToDoList.dataModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

public class ToDoDataSignletonClass {
    private static ToDoDataSignletonClass instance = new ToDoDataSignletonClass();
    private static String filename = "src/pract_lesson_/JavaFXToDoList/data/ToDoItems.txt";

    //moving to observable to use data binding and update scene automatically
    //private List<ToDoItem> items;
    private ObservableList items;
    private DateTimeFormatter dtf;

    public static ToDoDataSignletonClass getInstance(){
        return instance;
    }

    private ToDoDataSignletonClass() {
        dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public List<ToDoItem> getItems() {
        return items;
    }

    //changed to observable to use data binding
//    public List<ToDoItem> getToDoItemList(){
//        return this.items;
//    }

    public ObservableList<ToDoItem> getToDoItemList(){
        return this.items;
    }

    public void addData(ToDoItem item){
        items.add(item);
    }

      //required only to set data once from hardcoded part
//    public void setItems(List<ToDoItem> items) {
//        this.items = items;
//    }

    public void loadDataToListFromFile() throws Exception {
        //required by javaFX framework as we use in populateListView() setAll()
        //also FXCollections is a copy of the java.utils but optimized to call less gui updates
        items = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);
        String dataRow;
        try{
            while((dataRow = br.readLine()) != null){
                String[] rowRecord = dataRow.split("\t");
                String description = rowRecord[0];
                String details = rowRecord[1];
                String dueDate = rowRecord[2];
                LocalDate date = LocalDate.parse(dueDate,dtf);

                items.add(new ToDoItem(description,details,date));
            }
        }
        finally{
            if(br != null){
                br.close();
            }
        }
    }

    public void saveDataFromListToFile() throws IOException {
        Path path = Paths.get(filename);
        BufferedWriter bwr = Files.newBufferedWriter(path);

        try{
            Iterator<ToDoItem> iterator = items.iterator();
            while(iterator.hasNext()){
                ToDoItem item = iterator.next();
                bwr.write(String.format("%s\t%s\t%s",
                        item.getDescription(),
                        item.getDetails(),
                        item.getDueDate().format(dtf)));
                //set new line
                bwr.newLine();

            }
        }
        finally{
            if(bwr != null){
                bwr.close();
            }
        }
    }

    public void deleteItem(ToDoItem item){
        items.remove(item);
    }
}
