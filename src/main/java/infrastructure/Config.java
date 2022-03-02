package infrastructure;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Config {
    private static final String CONFIG_DIR = "src/main/resources/LibraryCollection.txt";
    private static final String REGEX_CHAR = ",";

    public List<DictionaryConfig> readConfig() {
        try (
                FileInputStream descriptorPosition = new FileInputStream(CONFIG_DIR);
                BufferedReader readerStream = new BufferedReader(new InputStreamReader(descriptorPosition));
        ) {
            List<DictionaryConfig> listDictionaries = new ArrayList<>();

            while (readerStream.ready()) {
                String configLine = readerStream.readLine();
                listDictionaries.add(new DictionaryConfig(configLine));
            }
            return listDictionaries;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public class DictionaryConfig {

        public String getPatternKey() {
            if (patternKey == null || patternKey.isEmpty()) {
                return new String();
            } else {
                return patternKey;
            }
        }

        public String getPatternValue() {
            if (patternValue == null || patternValue.isEmpty()) {
                return new String();
            } else {
                return patternValue;
            }
        }

        public String getNameDictionary() {
            if (nameDictionary == null || nameDictionary.isEmpty()) {
                return new String();
            } else {
                return nameDictionary;
            }
        }

        public String getPathDictionary() {
            if (pathDictionary == null || pathDictionary.isEmpty()) {
                return new String();
            } else {
                return pathDictionary;
            }
        }

        private String patternKey;
        private String patternValue;
        private String nameDictionary;
        private String pathDictionary;

        public DictionaryConfig(String configLine) {
            String[] tempRead = configLine.split(REGEX_CHAR);
            this.patternKey = tempRead[0];
            this.patternValue = tempRead[1];
            this.nameDictionary = tempRead[2];
            this.pathDictionary = tempRead[3];
        }
    }
}
