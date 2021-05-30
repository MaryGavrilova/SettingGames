import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringBuilder logger = new StringBuilder();
        createFolder("/Users/gavri/Games/src", logger);
        createFolder("/Users/gavri/Games/res", logger);
        createFolder("/Users/gavri/Games/savegames", logger);
        createFolder("/Users/gavri/Games/temp", logger);

        createFolder("/Users/gavri/Games/src/main", logger);
        createFolder("/Users/gavri/Games/src/test", logger);

        createFile("/Users/gavri/Games/src/main/Main.java", logger);
        createFile("/Users/gavri/Games/src/main/Utils.java", logger);

        createFolder("/Users/gavri/Games/res/drawables", logger);
        createFolder("/Users/gavri/Games/res/vectors", logger);
        createFolder("/Users/gavri/Games/res/icons", logger);

        createFile("/Users/gavri/Games/temp/temp.txt", logger);

        String logs = logger.toString();
        System.out.println(logs);
        writeInfoToFile(logs, "/Users/gavri/Games/temp/temp.txt");
    }

    public static void createFolder(String pathOfFolder, StringBuilder logger) {
        File dir = new File(pathOfFolder);
        if (dir.mkdir()) {
            logger.append("Директория " + pathOfFolder + " создана\n");
        } else {
            logger.append("Директорию " + pathOfFolder + " создать не получилось\n");
        }
    }

    public static void createFile(String pathOfFile, StringBuilder logger) {
        File file = new File(pathOfFile);
        try {
            if (file.createNewFile()) {
                logger.append("Файл " + pathOfFile + " создан\n");
            } else {
                logger.append("Файл " + pathOfFile + " создать не получилось\n");
            }
        } catch (IOException ex) {
            logger.append(ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    public static void writeInfoToFile(String info, String pathOfFile) {
        try (FileWriter writer = new FileWriter(new File(pathOfFile), false)) {
            writer.write(info);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
