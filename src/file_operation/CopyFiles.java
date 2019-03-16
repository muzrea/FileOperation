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

    public void copyFolder(String targetFilePath, String copyFilePath) {
        try {
            File copyFile = new File(copyFilePath);
            copyFile.mkdirs();
            File targetFile = new File(targetFilePath);
            String[] files = targetFile.list();
            File temp = null;
            for (int i = 0; i < files.length; i++) {
                if (targetFilePath.endsWith(File.separator)) {
                    temp = new File(targetFilePath + files[i]);
                } else {
                    temp = new File(targetFilePath + File.separator + files[i]);
                }
                if (temp.isFile()) {
                    FileInputStream inputStream = new FileInputStream(temp);
                    FileOutputStream outputStream = new FileOutputStream(copyFilePath + "/" + (temp.getName()).toString());
                    byte[] newByteData = new byte[1024 * 5];
                    byte text = 0;
                    int len;
                    while ((len = inputStream.read(newByteData)) != -1) {
                        outputStream.write(newByteData, 0, len);
                    }
                    outputStream.flush();
                    outputStream.close();
                    inputStream.close();
                }
                if (temp.isDirectory()) {
                    copyFolder(targetFilePath + "/" + files[i], copyFilePath + "/" + files[i]);
                }
            }

        } catch (Exception e) {
            System.out.println("复制文件夹出错");
            e.printStackTrace();
        }
    }
}
