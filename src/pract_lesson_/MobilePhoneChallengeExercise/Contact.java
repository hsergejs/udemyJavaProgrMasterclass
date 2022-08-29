package pract_lesson_.MobilePhoneChallengeExercise;

public class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    //!!! static not to create a new instance when accessing contact object, use in menu as createContact() in addNewContactLocal();
    //also called as factory method, also can be seen in updateContactLocal()
    public static Contact createContact(String name, String phone){
        return new Contact(name, phone);
    }
}
