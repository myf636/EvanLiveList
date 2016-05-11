package com.EvanMao.Tool;

import android.graphics.Bitmap;
import android.os.Environment;

import com.EvanMao.LiveList.EvanApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class FileUtils {

    private String SDPATH;

    private int FILESIZE = 8 * 1024;

    public String getSDPATH() {
        return SDPATH;
    }

    public FileUtils() {
        if (EvanApp.getInstance().ExistSDCard()) {

            SDPATH = Environment.getExternalStorageDirectory() + "/Insurance/";
            if (!isFileExist(SDPATH)) {
                createDir("");
            }
        } else {
            SDPATH = EvanApp.getInstance().ExFilesPath();
        }
    }

    /**
     * ��SD���ϴ����ļ�
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    public File createFile(String fileName) throws IOException {
        File file = new File(SDPATH + fileName);
        file.createNewFile();
        return file;
    }

    /**
     * ��SD����ɾ���ļ�
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    public boolean deleteFile(String fileName) throws IOException {
        File file = new File(SDPATH + fileName);
        return file.delete();
    }

    /**
     * ��SD���ϴ���Ŀ¼
     *
     * @param dirName
     * @return
     */
    public File createDir(String dirName) {
        File dir = new File(SDPATH + dirName);
        dir.mkdir();
        return dir;
    }

    /**
     * 判断文件是否存在
     *
     * @param fileName
     * @return
     */
    public boolean isFileExist(String fileName) {
        File file = new File(SDPATH + fileName);
        return file.exists();
    }

    /**
     * 获取文件大小
     *
     * @param fileName
     * @return
     */
    public long getFileSize(String fileName) {
        File file = new File(SDPATH + fileName);
        return file.length();
    }

    /**
     * 将inputstream输入流写成文件
     *
     * @param path
     * @param fileName
     * @param input
     * @return
     * @throws IOException
     */
    public File write2FileFromInput(String path, String fileName,
                                    InputStream input) throws IOException {
        File file = null;
        OutputStream output = null;
        {
            createDir(path);
            file = createFile(path + fileName);
            output = new FileOutputStream(file);
            byte[] buffer = new byte[FILESIZE];
            int count = 0;
            while ((count = input.read(buffer, 0, FILESIZE)) > 0) {
                output.write(buffer, 0, count);
            }

            output.close();
        }

        return file;
    }

    public void saveMyBitmap(String bitName, Bitmap mBitmap) throws IOException {
        File f = new File(getSDPATH() + bitName);
        if (isFileExist(bitName)) {
            deleteFile(bitName);
        }
        createFile(bitName);

        FileOutputStream fOut = null;
        try {
            fOut = new FileOutputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        mBitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
        try {
            fOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
