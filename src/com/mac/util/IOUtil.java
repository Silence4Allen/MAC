package com.mac.util;

import java.io.*;

public class IOUtil {
    private String defaultPath = "D:\\IOUtilDefaultFile.txt";

    public IOUtil() {
        File file = new File(defaultPath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param path
     * @param fileName
     */
    public void readStreamFile(String path, String fileName) {
        File file = new File(getPath(path, fileName));
        try {
            InputStream is = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(is);
            byte[] bytes = new byte[1024];
            int count = 0;
            int temp = 0;
            bis.read();
            while ((temp = bis.read()) != -1) {
                bytes[count++] = (byte) temp;
            }
            bis.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param path
     * @param fileName
     * @param contents
     */
    public void writeFile(String path, String fileName, String contents, boolean isAppend) {

        File file = new File(getPath(path, fileName));
        FileWriter fw;
        BufferedWriter bw;
        try {
            if (isAppend) {
                fw = new FileWriter(file, true);
                bw = new BufferedWriter(fw);
                bw.append(contents);
            } else {
                fw = new FileWriter(file);
                bw = new BufferedWriter(fw);
                bw.write(contents);
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param path
     * @param fileName
     * @param contents
     * @param isAppend
     */
    public void writeFileByStream(String path, String fileName, String contents, boolean isAppend) {
        File file = new File(getPath(path, fileName));
        FileOutputStream fos;
        try {
            if (isAppend)
                fos = new FileOutputStream(file, true);
            else
                fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            OutputStreamWriter osw = new OutputStreamWriter(bos);
            BufferedWriter bw = new BufferedWriter(osw);
            if (isAppend)
                bw.append(contents + "\r\n");
            else
                bw.write(contents + "\r\n");
            bw.close();
            osw.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getPath(String path, String fileName) {
        String str = null;
        if (path != null && fileName != null) {
            if (path.contains(fileName))
                str = path;
            else
                str = path + "//" + fileName;
        }
        return str;
    }
}
