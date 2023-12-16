package phoneBook;
import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {

        List<Note> usersList = new ArrayList<>();

        usersList.add(new Note("John", "123456"));
        usersList.add(new Note("John", "12345645"));
        usersList.add(new Note("Pawel", "45677533"));
        usersList.add(new Note("Ilona", "454377533"));
        usersList.add(new Note("Petr", "1111533"));
        usersList.add(new Note("Pawel", "45117533"));

        Map<String, String> notes = addNotes(usersList);
        Scanner printName = new Scanner(System.in);
        System.out.println("Enter user name:");
        String name = printName.nextLine();
        System.out.println("First occurrence:");
        find(notes, name);
        System.out.println("-------------");
        System.out.println("All occurrence:");
        findAll(notes, name);

    }
    public static Map<String, String> addNotes(List<Note> usersList) {
        Map<String, String> map = new HashMap<>();
        for (Note stu : usersList) {
            map.put(stu.getPhoneNumber(), stu.getName());
        }
        return map;
    }

    public static void findAll(Map<String, String> map, String s) {
        int countOc = 0;
        for (Map.Entry<String, String> entity : map.entrySet()) {
            if (entity.getValue().equals(s)) {
                System.out.println(entity.getValue() + "   " + entity.getKey());
                countOc++;
            }
        }
        if (countOc == 0) {
            System.out.println("null");
        }
    }
    public static void find(Map<String, String> map, String s) {
        int countOc = 0;
        for (Map.Entry<String, String> entity : map.entrySet()) {
            if (entity.getValue().equals(s)) {
                System.out.println(entity.getValue() + "   " + entity.getKey());
                countOc++;
                break;
            }
        }
        if (countOc == 0) {
            System.out.println("null");
        }
    }
}



