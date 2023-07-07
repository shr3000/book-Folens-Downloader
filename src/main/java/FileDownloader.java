import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class FileDownloader {
    public static void main(String[] args) {
        String url = "https://www.folens.ie/sites/default/files/bulk_upload/ActiveMaths/AM3_TB_EBOOK/files/pages/tablet/";
        String destinationFolder = "D:/bookmath/";

        int totalFiles = 630;
        int bufferSize = 1024;

        for (int i = 1; i <= totalFiles; i++) {
            String fileName = i + ".jpg";
            String fileUrl = url + fileName;

            try (BufferedInputStream inputStream = new BufferedInputStream(new URL(fileUrl).openStream());
                 FileOutputStream fileOutputStream = new FileOutputStream(destinationFolder + fileName)) {

                byte[] dataBuffer = new byte[bufferSize];
                int bytesRead;
                while ((bytesRead = inputStream.read(dataBuffer, 0, bufferSize)) != -1) {
                    fileOutputStream.write(dataBuffer, 0, bytesRead);
                }

                System.out.println("Downloaded: " + fileName);
            } catch (IOException e) {
                System.err.println("Error downloading file: " + fileName);
                e.printStackTrace();
            }
        }

        System.out.println("All files downloaded successfully.");
    }
}

