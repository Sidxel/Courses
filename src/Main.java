import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "/Users/sortedmap/Desktop/wendingMachine.txt";

//        File file = new File(path);
//        FileInputStream inputStream = new FileInputStream(file);
//        int symbol = 0;
//        byte[] bytes = new byte[(int) file.length()];
//        int i = 0;
//        while((symbol = inputStream.read()) >= 0) {
//            bytes[i++] = (byte) symbol;
//        }
//        String data = new String(bytes);
//        System.out.println(data);
//        inputStream.close();

//        BufferedReader reader =
//            new BufferedReader(new FileReader(path));
//        String line = null;
//        while((line = reader.readLine()) != null) {
//            System.out.println(line);
//        }

//        String data = Files.readString(Paths.get(path));
//        System.out.println(data);

//        List<String> lines = Files.readAllLines(Paths.get(path));
//        lines.forEach(System.out::println);

//        RandomAccessFile accessFile = new RandomAccessFile(path, "r");
//        accessFile.seek(12);
//        String line = accessFile.readLine();
//        System.out.println(line);
    }
}
