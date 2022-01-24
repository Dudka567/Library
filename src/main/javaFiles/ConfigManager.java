package src.main.javaFiles;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class ConfigManager {
    public final static String CHAR_OF_DIRECTORY = "/";
    public final static String EXPANSION = ".txt";
    public final static String SOURCE_DIRECTORY = "../resources";
    public final static String NAME_FILE = "LibraryType";
    public static final String CONFIG_DIR = "../resources/LibraryCollection.txt";
    public static final String REGEX_CHAR = ",";

    public LinkedList<DictionaryConfig> readConfig() throws IOException {
        FileInputStream descriptorPosition = new FileInputStream(CONFIG_DIR);
        descriptorPosition.getChannel().position(0);
        BufferedReader readerStream = new BufferedReader(new InputStreamReader(descriptorPosition));
        LinkedList<DictionaryConfig> listDictionaries = new LinkedList<>();

        while (readerStream.ready()) {
            String configLine = readerStream.readLine();
            listDictionaries.add(new DictionaryConfig(configLine));
        }
        return listDictionaries;
    }

    public File searchLibrary(String expectedNameFile) throws IOException {
        File dir = new File(SOURCE_DIRECTORY);
        ArrayList<File> listFilesInDirectory = new ArrayList<>();
        for (File file : dir.listFiles()) {
            if (file.isFile())
                listFilesInDirectory.add(file);
        }

        for (File file : listFilesInDirectory) {
            if (isCheckedFile(file, expectedNameFile)) {
                return file;
            }
        }
        File file = new File(SOURCE_DIRECTORY + CHAR_OF_DIRECTORY + NAME_FILE + expectedNameFile + EXPANSION);
        FileWriter writer = new FileWriter(file);
        return file;
    }

    public boolean isCheckedFile(File file, String expectedNameFile) throws IOException {
        return file.getName().equals(NAME_FILE + expectedNameFile + EXPANSION);
    }

    class DictionaryConfig {
        String patternKey;
        String patternValue;
        String nameDictionary;
        String typeDictionary;

        public DictionaryConfig(String configLine) {
            String[] tempRead = configLine.split(REGEX_CHAR);
            this.patternKey = tempRead[0];
            this.patternValue = tempRead[1];
            this.nameDictionary = tempRead[2];
            this.typeDictionary = tempRead[3];
        }
    }
}
