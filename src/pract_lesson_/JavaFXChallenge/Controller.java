package pract_lesson_.JavaFXChallenge;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import pract_lesson_.JavaFXChallenge.dataModel.Contact;
import pract_lesson_.JavaFXChallenge.dataModel.ContactData;

import java.io.IOException;
import java.util.Optional;

public class Controller {
    //columnresizepolicy allow to resize row and cell to occupy full available window size

    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private TableView<Contact> contactsTable;

    private ContactData contactData;

    public void initialize(){
        contactData = new ContactData();
        contactData.loadContacts();
        contactsTable.setItems(contactData.getContactList());
    }
    @FXML
    public void showAddContactDialog(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add new contact");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addContactDialog.fxml"));
        try{
            dialog.getDialogPane().setContent(loader.load());
        }
        catch(IOException e){
            e.printStackTrace();
            return;
        }

        //add buttons
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        //get button press result and open dialog and wait
        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            //get controller to access method and retrieve data from dialog
            AddContactDialogController dialogController = loader.getController();
            Contact newContact = dialogController.getNewContact();
            contactData.saveContact(newContact);
            //load to xml new contacts in the observable list, better solution save on close
            contactData.saveContacts();
        }
        else{
            System.out.println("Cancel");
        }
    }

    @FXML
    public void showEditContactDialog(){
        Contact selectedContact = contactsTable.getSelectionModel().getSelectedItem();
        if(selectedContact == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No contact is selected!");
            alert.setHeaderText(null);
            alert.setContentText("Please choose contact to edit");
            alert.showAndWait();
            return;
        }

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Edit contact");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addContactDialog.fxml"));
        try{
            dialog.getDialogPane().setContent(loader.load());
        }
        catch(IOException e){
            System.out.println("Couldn't load dialog window");
            e.printStackTrace();
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        AddContactDialogController dialogController = loader.getController();
        dialogController.getContactValue(selectedContact);

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            dialogController.updateContact(selectedContact);
            contactData.saveContacts();
        }
    }

    @FXML
    public void deleteContactOnAction(){
        Contact selectedContact = contactsTable.getSelectionModel().getSelectedItem();
        if(selectedContact == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No contact is selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select contact to delete");
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete contact");
        alert.setHeaderText(null);
        alert.setContentText("Please confirm contact deletion for "
                + selectedContact.getFirstName() + " " + selectedContact.getLastName());
        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            contactData.deleteContact(selectedContact);
            contactData.saveContacts();
        }
    }
}
