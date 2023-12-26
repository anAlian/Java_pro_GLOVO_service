package hw9_singleton;

public class Main {
    public static void main(String[] args) {
        System.out.println("----Class-based singleton----");
        ClassBasedSingleton instance1 = ClassBasedSingleton.getInstance();
        System.out.println(instance1.getStr());
        ClassBasedSingleton instance2 = ClassBasedSingleton.getInstance();
        instance2.setStr("New object is created");
        System.out.println(instance1.getStr());
        System.out.println(instance2.getStr());

        System.out.println("-------Enum singleton-------");
        EnumSingleton enumInstance1 = EnumSingleton.MY_INSTANCE;
        EnumSingleton enumInstance2 = EnumSingleton.MY_INSTANCE;
        System.out.println(enumInstance1.getNumber());
        enumInstance2.setNumber(20);
        System.out.println(enumInstance1.getNumber());
        System.out.println(enumInstance2.getNumber());

        System.out.println("----Thread safe singleton----");
        ThreadSafeSingleton threadSafeSingleton1 = ThreadSafeSingleton.getMyInstance();
        System.out.println(threadSafeSingleton1.getStr());
        ThreadSafeSingleton threadSafeSingleton2 = ThreadSafeSingleton.getMyInstance();
        threadSafeSingleton2.setStr("New object");
        System.out.println(threadSafeSingleton1.getStr());
        System.out.println(threadSafeSingleton2.getStr());

    }
}
