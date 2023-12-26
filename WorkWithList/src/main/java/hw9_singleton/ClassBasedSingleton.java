package hw9_singleton;

public class ClassBasedSingleton {
    private static ClassBasedSingleton INSTANCE;
    private String str = "Object is created";

    private ClassBasedSingleton() {
    }

    public static ClassBasedSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ClassBasedSingleton();
        }
        return INSTANCE;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
