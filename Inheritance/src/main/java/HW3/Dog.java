package HW3;

public class Dog extends Animal{
    final int maxLenRun=500;
    final int maxLenSwim =10;
    public static int numberofobjectsDog=0;
    public Dog(String name) {
        super(name);
        numberofobjectsDog++;
    }

    @Override
    public int getMaxLenRun() {
        return maxLenRun;
    }

    public int getMaxLenSwim() {
        return maxLenSwim;
    }
}
