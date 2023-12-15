package org.example;

public class test {
    public static void main(String[] args) {
        String abc= "MyDearDearFriends";
        System.out.println(abc.charAt(4));
        System.out.println(abc.contains("ear"));
        System.out.println(abc.endsWith("ds"));
        System.out.println(abc.indexOf('y'));
        System.out.println(abc.lastIndexOf('e'));
        char [] array1= abc.toCharArray();
        System.out.println(array1);
//        for (int i=0; i<array1.length;i++){
//            System.out.println(array1[i]);
//        }
        System.out.println(abc.intern());
    }
}
