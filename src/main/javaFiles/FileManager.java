package src.main.javaFiles; 

import java.io.*;

public class FileManager implements FileManagerFunctionally {
    public final static String SPLIT_CHAR = "-";

    private File dirLibrary;

    public FileManager(File dirLibrary) {
        this.dirLibrary = dirLibrary;
    }

    @Override
    public void readFile(Library library) throws IOException {
        FileInputStream descriptorPosition = new FileInputStream(dirLibrary);
        descriptorPosition.getChannel().position(0);
        BufferedReader readerStream = new BufferedReader(new InputStreamReader(descriptorPosition));
        String[] tempRead = new String[2];

        while (readerStream.ready()) {
            tempRead = readerStream.readLine().split(SPLIT_CHAR);
            library.getLocalDictionary().put(tempRead[0], tempRead[1]);
        }
    }

    @Override
    public void writeFile(Library library) throws IOException {
        BufferedWriter writerStream = new BufferedWriter(new FileWriter(dirLibrary));
        for (String elemKey : library.getLocalDictionary().keySet()) {
            writerStream.write(elemKey + SPLIT_CHAR + library.getLocalDictionary().get(elemKey) + "\n");
            writerStream.flush();
        }
    }

    @Override
    public void deleteFile(String nameFile) {
        File deleteFile = new File(nameFile);
        deleteFile.delete();
    }
}
