import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        createFolder("/Users/gavri/Games/src", stringBuilder);
        createFolder("/Users/gavri/Games/res", stringBuilder);
        createFolder("/Users/gavri/Games/savegames", stringBuilder);
        createFolder("/Users/gavri/Games/temp", stringBuilder);

        createFolder("/Users/gavri/Games/src/main", stringBuilder);
        createFolder("/Users/gavri/Games/src/test", stringBuilder);

        createFile("/Users/gavri/Games/src/main/Main.java", stringBuilder);
        createFile("/Users/gavri/Games/src/main/Utils.java", stringBuilder);

        createFolder("/Users/gavri/Games/res/drawables", stringBuilder);
        createFolder("/Users/gavri/Games/res/vectors", stringBuilder);
        createFolder("/Users/gavri/Games/res/icons", stringBuilder);

        createFile("/Users/gavri/Games/temp/temp.txt", stringBuilder);

        String logs = stringBuilder.toString();
        System.out.println(logs);
        writeInfoToFile(logs, "/Users/gavri/Games/temp/temp.txt");
    }

    public static void createFolder(String path, StringBuilder stringBuilder) {
        File dir = new File(path);
        if (dir.mkdir()) {
            stringBuilder.append("Директория " + path + " создана\n");
        } else stringBuilder.append("Директорию " + path + " создать не получилось\n");
    }

    public static void createFile(String path, StringBuilder stringBuilder) {
        File file = new File(path);
        try {
            if (file.createNewFile())
                stringBuilder.append("Файл " + path + " создан\n");
            else stringBuilder.append("Файл " + path + " создать не получилось\n");
        } catch (IOException ex) {
            stringBuilder.append(ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    public static void writeInfoToFile(String info, String path) {
        try (FileWriter writer = new FileWriter(new File(path), false)) {
            writer.write(info);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
