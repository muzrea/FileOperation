package file_operation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadWriteFile {
    public static void main(String[] args) {
        File myFile = new File("E:\\java_training_camp\\files\\my_file");
        myFile.mkdir();
        File mytxt = new File("E:\\java_training_camp\\files\\my_file\\mytxt.txt");
        try {
            mytxt.createNewFile();
            String myFileRoute = "E:\\java_training_camp\\files\\my_file\\mytxt.txt";
            FileOutputStream fos = new FileOutputStream(myFileRoute);
            String text = "This is my file";
            byte[] textBytes = text.getBytes();
            fos.write(textBytes);
            fos.flush();
            FileInputStream fis = new FileInputStream(myFileRoute);
            byte byteData;
            while ((byteData = (byte) fis.read()) != -1) {
                System.out.print((char) byteData);
            }
            fos.close();
            fis.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
