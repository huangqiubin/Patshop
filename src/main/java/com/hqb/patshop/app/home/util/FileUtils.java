package com.hqb.patshop.app.home.util;

import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static void saveMultipartFile(StringBuilder imageBuilder, MultipartFile file) throws IOException {
        String fileName = System.currentTimeMillis() + file.getOriginalFilename();
        imageBuilder.append(fileName).append(",");
        String destFilePath = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
        String destFileName = destFilePath + File.separator + fileName;
        System.out.println("存储路径" + destFileName);
        File destFile = new File(destFileName);
        destFile.getParentFile().mkdirs();
        file.transferTo(destFile);
    }
}
