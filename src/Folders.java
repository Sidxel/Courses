import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Folders {
    private static List<String> data;

    public static void main(String[] args) throws IOException {

        String path = "/Users/sortedmap/Desktop/folder";
        data = new ArrayList<>();
        searchFiles(path);
        data.forEach(System.out::println);
    }

    public static void searchFiles(String path) throws IOException {
        File folder = new File(path);
        File[] files = folder.listFiles();
        List<File> filesList = Arrays.asList(files);
        filesList.forEach(file -> {
            try {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    String filePath = file.getAbsolutePath();
                    String line = Files.readString(Paths.get(filePath));
                    data.add(line);
                } else if (file.isDirectory()) {
                    searchFiles(file.getAbsolutePath());
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}
