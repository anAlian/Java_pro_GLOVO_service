package HW2_1;

public class Employees {
    private String name;
    private String position;
    private String email;
    private int phoneNumber;
    private int age;

    public Employees(String name, String position, String email, int phoneNumber, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }


}
