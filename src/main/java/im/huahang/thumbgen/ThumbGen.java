package im.huahang.thumbgen;

import java.io.File;

public class ThumbGen {
    static public void main(final String[] args) {
        String inputPath = "/Users/huahang/Desktop/JPEG";
        String outputPath = "/Users/huahang/Desktop/thumb";
        File inputDir = new File(inputPath);
        File outputDir = new File(outputPath);
        if (!inputDir.isDirectory()) {
            System.err.println("Invalid input path: " + inputPath);
            System.exit(1);
            return;
        }
        if (outputDir.exists() && !outputDir.isDirectory()) {
            System.err.println("Invalid output path: " + outputPath);
            System.exit(1);
            return;
        }
        outputDir.mkdirs();
        File[] files = inputDir.listFiles();
        for (File file : files) {
            String inputFileName = file.getAbsolutePath();
            String outputFileName = outputPath + "/" + file.getName();
            String command = "convert -resize 4000x4000 -quality 90 " + inputFileName + " " + outputFileName;
            System.out.println(command);
        }
    }
}
