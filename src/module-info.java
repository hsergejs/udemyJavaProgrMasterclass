module udemyJavaProgrMasterclass {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.media;
    requires javafx.base;
    requires javafx.web;
    requires javafx.swing;
    requires javafx.fxml;


    opens pract_lesson_.JavaFX;
    //required to add if different applications need to run in different package, adding each package for javaFX
    opens pract_lesson_.JavaFXToDoList;
    opens pract_lesson_.JavaFXFurther;
}