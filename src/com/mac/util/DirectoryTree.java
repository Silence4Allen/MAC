package com.mac.util;

import java.io.File;

public class DirectoryTree {
    private StringBuilder sb;

    public DirectoryTree() {
        sb = new StringBuilder();
    }

    /**
     * @param startNodeNum:起始节点
     * @param path:起始路径
     */
    public void loop(int startNodeNum, String path) {
        File file = new File(path);
        //  If the file is a directory
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < startNodeNum; i++) {
            temp.append("--|");
        }
        if (file.isDirectory()) {
            startNodeNum++;
            File[] files = file.listFiles();
            if (files != null)
                for (int i = 0; i < files.length; i++) {
                    //  If the file is still a directory
                    if (files[i].isDirectory()) {
                        loop(startNodeNum, files[i].getPath());
                    } else {
                        sb.append(files[i].getPath() + "\r\n");
                    }
                }
        } else {
            sb.append(file.getPath() + "\r\n");
        }
    }

    public String getContents() {
        return sb.toString();
    }
}
