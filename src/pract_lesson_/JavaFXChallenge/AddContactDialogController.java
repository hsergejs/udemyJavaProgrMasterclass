package pract_lesson_.JavaFXChallenge;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pract_lesson_.JavaFXChallenge.dataModel.Contact;

public class AddContactDialogController {
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField notesField;

    public Contact getNewContact(){
        String fName = firstNameField.getText();
        String lName = lastNameField.getText();
        String pn = phoneNumberField.getText();
        String note = notesField.getText();

        return new Contact(fName,lName,pn,note);
    }

    public void getContactValue(Contact contact){
        firstNameField.setText(contact.getFirstName());
        lastNameField.setText(contact.getLastName());
        phoneNumberField.setText(contact.getPhoneNumber());
        notesField.setText(contact.getNotes());
    }

    public void updateContact(Contact contact){
        contact.setFirstName(firstNameField.getText());
        contact.setLastName(lastNameField.getText());
        contact.setPhoneNumber(phoneNumberField.getText());
        contact.setNotes(notesField.getText());
    }
}
