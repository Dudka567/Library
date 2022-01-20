package src.main.javaFiles;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class ConfigManager implements ConfigManagerFunctionally {
    public final static String CHAR_OF_DIRECTORY = "/";
    public final static String EXPANSION = ".txt";
    public final static String SOURCE_DIRECTORY = "../resources";
    public final static String NAME_FILE = "LibraryType";
    public static final String CONFIG_DIR = "../resources/LibraryCollection.txt";
    public static final String REGEX_CHAR = ",";

    @Override
    public LinkedList<String[]> readConfig() throws IOException {
        FileInputStream descriptorPosition = new FileInputStream(CONFIG_DIR);
        descriptorPosition.getChannel().position(0);
        BufferedReader readerStream = new BufferedReader(new InputStreamReader(descriptorPosition));
        String[] tempRead = new String[4];
        LinkedList<String[]> listDictionaries = new LinkedList<>();

        while (readerStream.ready()) {
            tempRead = readerStream.readLine().split(REGEX_CHAR);
            listDictionaries.add(tempRead);
        }
        return listDictionaries;
    }

    @Override
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

    @Override
    public boolean isCheckedFile(File file, String expectedNameFile) throws IOException {
        return file.getName().equals(NAME_FILE + expectedNameFile + EXPANSION);
    }
}
