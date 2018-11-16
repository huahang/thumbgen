package im.huahang.thumbgen;

import org.apache.commons.lang3.ArrayUtils;

import java.io.File;

public class ThumbGen {
    static public void main(final String[] args) {
        /* parse input */
        if (ArrayUtils.isEmpty(args)) {
            System.err.println("thumbgen [input directory]");
            System.exit(1);
            return;
        }
        File directory = new File(args[0]);
        if (!directory.isDirectory()) {
            System.err.println("" + args[0] + " is not a directory");
            System.exit(1);
            return;
        }
        if (!directory.isDirectory()) {
            System.err.println("Invalid input path: " + directory);
            System.exit(1);
            return;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                continue;
            }
            String filename = file.getAbsolutePath();
            String extension = getExtensionFromFilename(filename).toLowerCase();
            if (!extension.equalsIgnoreCase("jpg") && !extension.equalsIgnoreCase("jpeg")) {
                continue;
            }
            String command = CONVERT_COMMAND + " " + filename + " " + filename;
            System.out.println(command);
        }
    }

    static private String getExtensionFromFilename(final String filename) {
        String[] splits = filename.split("\\.");
        if (splits.length < 2) {
            return "";
        }
        return splits[splits.length - 1];
    }

    static private final String CONVERT_COMMAND = "convert -resize 4000x4000 -quality 90";
}
