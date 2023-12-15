package phoneBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    public static void main(String[] args) {

        List<Note> usersList = new ArrayList<>();


        usersList.add(new Note("John", "123456"));
        usersList.add(new Note("John", "123456"));
        usersList.add(new Note("John", "1234533"));
        usersList.add(new Note("Pawel", "45677533"));
        usersList.add(new Note("Ilona", "454377533"));
        usersList.add(new Note("Pawel", "45117533"));

        Map<String, String> notes = new HashMap<>();

        for (Note stu : usersList) {
            notes.put(stu.getPhoneNumber(), stu.getName());
        }
        System.out.println(usersList);
        System.out.println(notes);



        String s = "John";

        for(Map.Entry<String, String> entity : notes.entrySet()) {
            if (entity.getValue()==s){
                System.out.println(entity.getKey() + "   " + entity.getValue());

            }

        }

    }
}



