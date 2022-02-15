package model;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Map;

public class FilesStorage implements Storage {
    private final static String SPLIT_CHAR = "-";
    private static final String EXPANSION = "temp.txt";
    private static final String PATTERN_NAME_LIBRARY_FILE = "src/main/resources/";

    private File dirLibrary;

    public FilesStorage(){}

    public FilesStorage(String typeLibrary) {
        this.dirLibrary = new File(searchStorage(typeLibrary));
    }

    @Override
    public void readStorage(Map<String, String> library) {
        try (
                FileInputStream descriptorPosition = new FileInputStream(dirLibrary);
                BufferedReader readerStream = new BufferedReader(new InputStreamReader(descriptorPosition));
        ) {
            descriptorPosition.getChannel().position(0);
            String[] tempRead = new String[2];

            while (readerStream.ready()) {
                tempRead = readerStream.readLine().split(SPLIT_CHAR);
                library.put(tempRead[0], tempRead[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeStorage(Map<String, String> library) {
        try (
                BufferedWriter writerStream = new BufferedWriter(new FileWriter(dirLibrary));
        ) {
            for (String elemKey : library.keySet()) {
                writerStream.write(elemKey + SPLIT_CHAR + library.get(elemKey) + "\n");
                writerStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String searchStorage(String expectedNameStorage) {
        File dir = new File(expectedNameStorage);
        if (dir.exists() && !dir.isDirectory()) {
            return dir.getPath();
        } else {
            return createStorage(createNameStorage());
        }
    }

    public String createNameStorage() {

        Integer counterName = 0;
        String resultName = "";
        File dir = new File(PATTERN_NAME_LIBRARY_FILE);
        for (File file : dir.listFiles()) {
            if (file.isFile()) {
                String expectedName = counterName + EXPANSION;
                if (file.getName().equals(expectedName)) {
                    counterName++;
                } else {
                    resultName = PATTERN_NAME_LIBRARY_FILE + expectedName;
                    break;
                }
            }
        }
        return resultName;
    }

    public String createStorage(String expectedNameStorage) {
        File dirNewFile = new File(expectedNameStorage);
        try (FileWriter writer = new FileWriter(dirNewFile)) {
            return dirNewFile.getPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dirNewFile.getPath();
    }

}
