package HW3;

public class Cat extends Animal{
   final int maxLenRun=200;
    public static int numberofobjectsCat=0;

    public Cat(String name) {
        super(name);
        numberofobjectsCat++;
    }

    public int getMaxLenRun() {
        return maxLenRun;
    }

    public void swim (){
        System.out.println(name+ " не вміє плавати ");

    }
}
