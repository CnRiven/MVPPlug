package com.riven.mvpplug;

import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.LinkedList;

/**
 * Description: 文件工具类
 * Author: djs
 * Date: 2019/5/28.
 */
public class FileUtil {
    public static String traverseFolder(String path) {
        File file = new File(path);
        if (file.exists()) {
            LinkedList<File> list = new LinkedList<File>();
            File[] files = file.listFiles();
            String file21 = getString(list, files);
            if (file21 != null) return file21;
            File temp_file;
            while (!list.isEmpty()) {
                temp_file = list.removeFirst();
                files = temp_file.listFiles();
                String file2 = getString(list, files);
                if (file2 != null) return file2;
            }
        } else {
            System.out.println("文件不存在!");
        }
        System.out.println("没有发现文件");
        return "";
    }

    @Nullable
    private static String getString(LinkedList<File> list, File[] files) {
        for (File file2 : files) {
            if (file2.isDirectory()) {
                System.out.println("文件夹:" + file2.getAbsolutePath());
                if (file2.getName().endsWith("mvp")){
                    return file2.getAbsolutePath();
                }
                list.add(file2);
            }
        }
        return null;
    }
}
