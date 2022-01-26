package src.main.javaFiles;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StorageOfDictionaries implements StorageOfDictionariesFunctionally {
    private final static String SPLIT_CHAR = "-";
    private static final String EXPANSION = ".txt";
    private static final String SOURCE_DIRECTORY = "src/main/resources";
    private static final String NAME_FILE = "LibraryType";
    private static final String PATTERN_NAME_LIBRARY_FILE = "src/main/resources/LibraryType";

    private File dirLibrary;

    public StorageOfDictionaries(String typeLibrary) {
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

    @Override
    public String searchStorage(String expectedNameFile) {
        try {
            File dir = new File(SOURCE_DIRECTORY);
            List<File> listFilesInDirectory = new ArrayList<>();
            for (File file : dir.listFiles()) {
                if (file.isFile())
                    listFilesInDirectory.add(file);
            }

            for (File file : listFilesInDirectory) {
                if (isCheckedStorage(file, expectedNameFile)) {
                    return file.getPath();
                }
            }
            File file = new File(PATTERN_NAME_LIBRARY_FILE + expectedNameFile + EXPANSION);
            try (FileWriter writer = new FileWriter(file)) {
                return file.getPath();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public boolean isCheckedStorage(File file, String expectedNameFile) {
        return file.getName().equals(NAME_FILE + expectedNameFile + EXPANSION);
    }
}
