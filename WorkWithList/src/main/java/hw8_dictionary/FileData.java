package hw8_dictionary;

public class FileData {
    private String name;
    private byte size;
    private String path;

    public FileData(String name, byte size, String path) {
        this.name = name;
        this.size = size;
        this.path = path;
    }



    public String getName() {
        return name;
    }

    public byte getSize() {
        return size;
    }

    public String getPath() {
        return path;
    }

    public String toString() {
        return this.name;
    }


}
