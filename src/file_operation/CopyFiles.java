package file_operation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyFiles {
    public void copyFile(String targetFilePath, String copyFilePath) {
        File targetFile = new File(targetFilePath);
        if (targetFile.exists()) {
            try {
                FileInputStream targetFis = new FileInputStream(targetFilePath);
                FileOutputStream copyFos = new FileOutputStream(copyFilePath);
                byte[] buffer = new byte[1444];
                int length;
                byte byteData;
                byte targetText = 0;
                while ((byteData = (byte) targetFis.read()) != -1) {
                    targetText += byteData;
                    copyFos.write(buffer, 0, byteData);
                }
                targetFis.close();
            } catch (Exception e) {
                System.out.println("复制单个文件错误");
                e.printStackTrace();
            }
        }
    }
}
