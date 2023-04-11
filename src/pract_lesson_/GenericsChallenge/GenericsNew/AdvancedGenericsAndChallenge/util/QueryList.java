package pract_lesson_.GenericsChallenge.GenericsNew.AdvancedGenericsAndChallenge.util;

import pract_lesson_.GenericsChallenge.GenericsNew.AdvancedGenericsAndChallenge.Model.Student;

import java.util.ArrayList;
import java.util.List;

//use of the multiple types to declare upper bound of the class type
//first class & interface & interface etc
//to use required to implement all types

//public class QueryList <T extends Student & QueryItem>{
public class QueryList <T extends Student & QueryItem> extends ArrayList<T>{
//    private List<T> items;

    public QueryList(List<T> items) {
//        this.items = items;
        super(items);
    }

    public QueryList() {

    }

    //as method is static we can't use class T (type), as it will be unknown at the compile time
    //we make method generic with boundary, then method T (type) is becoming unrelated to class T (type)
    //we can change it to S and it will have no affect
    public static <T extends QueryItem> List<T> getMatches(List<T> items, String field, String value){
        List<T> matches = new ArrayList<>();
        for(var item : items){
            if(item.matchFieldValues(field,value)){
                matches.add(item);
            }
        }
        return matches;
    }

//    public List<T> getMatches(String field, String value){
//        List<T> matches = new ArrayList<>();
//        for(var item : items){
//            if(item.matchFieldValues(field,value)){
//                matches.add(item);
//            }
//        }
//        return matches;
//    }

    public QueryList<T> getMatches(String field, String value){
        QueryList<T> matches = new QueryList<>();
        for(var item : this){
            if(item.matchFieldValues(field,value)){
                matches.add(item);
            }
        }
        return matches;
    }
}
