package hw9_singleton;

public enum EnumSingleton {
    MY_INSTANCE;
    int number;
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
