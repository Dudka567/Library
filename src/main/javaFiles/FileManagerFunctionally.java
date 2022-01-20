package src.main.javaFiles; 


import java.io.File;
import java.io.IOException;

public interface FileManagerFunctionally {

    public void readFile(Library library) throws IOException;

    public void writeFile(Library library) throws IOException;

    public void deleteFile(String nameFile);
}
