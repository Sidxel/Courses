import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ImageDownloader {
    public static void main(String[] args) {
    String imageUrl = "https://avatars.mds.yandex.net/get-mpic/10483373/2a0000018ab8baf2df45c1073a170be7ef50/300x300"; // URL изображения
    String destinationFile = "C:\\Users\\sidxe\\Downloads\\downloaded_image.jpg"; // Имя файла для сохранения

    try {
        downloadImage(imageUrl, destinationFile);
        System.out.println("Изображение успешно скачано!");
    } catch (IOException e) {
        System.out.println("Ошибка при скачивании изображения: " + e.getMessage());
    }
}

    public static void downloadImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        try (InputStream in = new BufferedInputStream(url.openStream());
             FileOutputStream out = new FileOutputStream(destinationFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer, 0, buffer.length)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}
