package pract_lesson_.MobilePhoneChallengeExercise;

import java.util.Scanner;

public class MobilePhone extends PhoneContacts {
    private static Scanner scanner;
    private String myNumber;

    public MobilePhone(String myNumber) {
        super(myNumber);
        scanner = new Scanner(System.in);

    }

    public void StartPhone(){
        System.out.println("Loading...");
        useMenu();
    }

    private void printMenu(){
        System.out.println("Available actions: ");
        System.out.println("0 - to shutdown");
        System.out.println("1 - to display all contacts");
        System.out.println("2 - to add a new contact");
        System.out.println("3 - to update a contact");
        System.out.println("4 - to remove a contact");
        System.out.println("5 - to find a contact");
        System.out.println("6 - to display a menu");
        System.out.println("Choose appropriate option");
    }

    private void useMenu(){
        boolean quit = false;
        printMenu();
        while(!quit){
            System.out.println("Choose appropriate option: (6 - to display menu)");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch(option){
                case 0:
                    System.out.println("Shutting down... ");
                    quit = true;
                    break;
                case 1:
                    printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchContact();
                    break;
                case 6:
                    printMenu();
                    break;
            }
        }

    }

    private void addNewContact(){
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phone = scanner.nextLine();
        boolean result = super.addNewContact(Contact.createContact(name,phone)); //also called as factory method
        if(result){
            System.out.println("New contact added");
        }
        else{
            System.out.println("Unable to add new contact");
        }
    }

    private void updateContact(){
        System.out.println("Enter existing name: ");
        String name = scanner.nextLine();
        Contact existingContact = super.queryContact(name);
        if(existingContact == null){
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Enter new name: ");
        name = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phone = scanner.nextLine();
        boolean result = super.updateContact(existingContact,Contact.createContact(name,phone)); //another use of static method in Contact
        if(!result){
            System.out.println("Error updating contact");
        }
    }

    private void removeContact(){
        System.out.println("Enter existing name: ");
        String name = scanner.nextLine();
        Contact existingContact = super.queryContact(name);
        if(existingContact == null){
            System.out.println("Contact not found");
            return;
        }

        boolean result = super.removeContact(existingContact);
        if(!result){
            System.out.println("Error deleting record");
        }
    }

    private void searchContact(){
        System.out.println("Enter existing name: ");
        String name = scanner.nextLine();
        Contact existingContact = super.queryContact(name);
        if(existingContact == null){
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Name: " + existingContact.getName() + " phone number: " + existingContact.getPhoneNumber());
    }
}
