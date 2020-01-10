package com.alc.vccs.ui.util;

import org.springframework.util.StringUtils;

import java.util.UUID;

public class Utils {
    public static String s3Path(String prefix, String fileName) {
        StringBuilder res = new StringBuilder();
        if (!StringUtils.isEmpty(prefix)) {
            res.append(prefix);
            if (!prefix.endsWith("/")) {
                res.append("/");
            }
        }
        res.append(fileName);
        return res.toString();
    }

    public static String fileExtention(String fileName) {
        if (!StringUtils.isEmpty(fileName)) {
            int pos = fileName.lastIndexOf(".");
            if (pos != -1  && pos != fileName.length() -1) {
                return fileName.substring(pos + 1);
            }
        }
        return "unknown";
    }

    public static String addUUIDtoFileName(String fileName) {
        int pos = fileName.lastIndexOf(".");
        String uuid = UUID.randomUUID().toString();
        StringBuilder builder = new StringBuilder();
        if (pos != -1  && pos != fileName.length() -1) {
            builder.append(fileName.substring(0, pos))
                    .append("-")
                    .append(uuid)
                    .append(".")
                    .append(fileName.substring(pos+1));

        } else {
            builder.append(fileName)
                    .append("-")
                    .append(uuid);
        }

        return builder.toString();
    }
}
