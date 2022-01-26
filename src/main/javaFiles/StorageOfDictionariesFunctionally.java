package src.main.javaFiles;

import java.io.File;
import java.util.Map;

public interface StorageOfDictionariesFunctionally {
    void readStorage(Map<String, String> library);

    void writeStorage(Map<String, String> library);

    File searchStorage(String expectedNameFile);

    boolean isCheckedStorage(File file, String expectedNameFile);
}
