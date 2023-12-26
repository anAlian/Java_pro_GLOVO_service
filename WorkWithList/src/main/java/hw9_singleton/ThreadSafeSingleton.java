package hw9_singleton;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton myInstance;
    private String str = "Thread-safe singleton Object is created";

    private ThreadSafeSingleton() {
    }

    public static synchronized ThreadSafeSingleton getMyInstance() {
        if (myInstance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (myInstance == null) {
                    myInstance = new ThreadSafeSingleton();
                }
            }
        }
        return myInstance;
    }

//    public static synchronized ThreadSafeSingleton getMyInstance() {
//        ThreadSafeSingleton localRef =myInstance;
//        if (localRef == null) {
//            synchronized (ThreadSafeSingleton.class) {
//                localRef=myInstance;
//                if (localRef == null) {
//                    myInstance =localRef= new ThreadSafeSingleton();
//                }
//            }
//        }
//        return localRef;
//    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
