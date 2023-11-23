package HW2_1;

public class Main {
    public static void main(String[] args) {
        Employees employee1 = new Employees("Ivan Petrenko", "engineer","name@ms.com",33344,27);
        System.out.println(employee1.getName() + " "+employee1.getPosition());
    }
}
