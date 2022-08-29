package pract_lesson_.MobilePhoneChallengeExercise;

import java.util.ArrayList;

public class PhoneContacts {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public PhoneContacts(String number) {
        this.myNumber = number;
        this.myContacts = new ArrayList<>();
    }

    public void printContacts(){
        System.out.println("Contact List:");
        for(int i = 0; i < this.myContacts.size(); i++){
            System.out.println((i+1) + ". " + this.myContacts.get(i).getName() + " -> "
                    + this.myContacts.get(i).getPhoneNumber());
        }
    }

    public boolean addNewContact(Contact contact){
        if(findContact(contact.getName()) >= 0){
            System.out.println("Contact is on file");
            return false;
        }

        this.myContacts.add(contact);
        return true;
    }

    public boolean removeContact(Contact contact){
        int index = findContact(contact);
        if(index < 0){
            System.out.println("Contact not found");
            return false;
        }

        this.myContacts.remove(index);
        System.out.println("Contact removed");
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int index = findContact(oldContact);
        if(index < 0){
            System.out.println("Contact not found");
            return false;
        }

        if(findContact(newContact.getName()) > -1){
            System.out.println("Contact with that name already exists");
            return false;
        }

        this.myContacts.set(index, newContact);
        System.out.println("Contact updated");
        return true;
    }

    public Contact queryContact(String name){
        int index = findContact(name);
        if(index > -1){
            return this.myContacts.get(index);
        }

        return null;
    }

    private int findContact(String name){
        for(int i = 0; i<this.myContacts.size(); i++){
            if(this.myContacts.get(i).getName().equals(name)){
                return i;
            }
        }

        return -1;
    }

    private int findContact(Contact contact){
        return this.myContacts.indexOf(contact);
    }
}
