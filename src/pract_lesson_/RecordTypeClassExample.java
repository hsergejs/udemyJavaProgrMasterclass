package pract_lesson_;

public record RecordTypeClassExample(String id, String name, String dob, String classList) {
    //is a replacement for the POJO/JavaBean, but more restricted
    //all fields are private and final, same as in header (param part), with same name and type
    //no setters, only getters, but without prefix (e.g. get, is etc.), so it can be access via id(), name() etc.
    // toString implemented
    //that's all implementation, everything is made in auto mode
}
