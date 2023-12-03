import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

public class FileReaderWriter {
    public static void main(String[] args) throws IOException {
        String text = """
                INFO: Starting JuniorCrudServiceApplication using Java 17.0.7
                DEBUG: User admin created
                WARNING: User admin created with warnings
                DEBUG: User user created
                INFO: Starting JuniorCrudService
                ERROR: something happen""";


        File file = new File("src/main/java/files/log.txt");
        if (file.exists()) {
            file.delete();
        }

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(text);
        fileWriter.flush();
        fileWriter.close();
        System.out.println("-------------------------------");
        System.out.println("Read all logs:");
        System.out.println("-------------------------------");
        List<String> strings = FileUtils.readLines(file, Charset.defaultCharset());

        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println("------------------------------");
        Collections.sort(strings);
        String requiredLog1 = "INFO";
        String requiredLog2 = "DEBUG";
        System.out.println("Read only "+requiredLog1+" and "+requiredLog2+" logs:");
        System.out.println("------------------------------");
        printRequiredLog(strings, requiredLog1, requiredLog2);
    }
    public static void printRequiredLog(List<String> strings, String s1, String s2) {
        for (String string : strings) {
            if (string.startsWith(s1) || string.startsWith(s2)) {
                System.out.println(string);
            }
        }
    }
}
