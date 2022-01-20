package src.main.javaFiles; 

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

public interface ConfigManagerFunctionally {
    public LinkedList<String[]> readConfig() throws IOException;

    public File searchLibrary(String expectedNameFile) throws IOException;

    public boolean isCheckedFile(File file, String expectedNameFile) throws IOException;
}
