import store.Product;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WritingFiles {
    public static void main(String[] args) throws IOException {
        List<Product> products = new ArrayList<>();
        Product milk = new Product("молоко", 79);
        products.add(milk);
        Product iceCream = new Product("мороженое", 95);
        products.add(iceCream);
        Product bread = new Product("хлеб", 60);
        products.add(bread);

//        String path = "data/products.txt";

//        FileOutputStream outputStream = new FileOutputStream(path);
//        products.forEach(product -> {
//            try {
//                outputStream.write(product.toString().getBytes());
//                outputStream.write("\n".getBytes());
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        outputStream.flush();
//        outputStream.close();

//        StringBuilder productsList = new StringBuilder();
//        for(Product product : products) {
//            productsList.append(product);
//            productsList.append("\n");
//        }
//        Files.writeString(Paths.get(path), productsList);
    }
}
