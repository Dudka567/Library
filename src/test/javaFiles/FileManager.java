package src.test.javaFiles; 
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;


public class FileManager {
    public final static String NAME_FILE = "LibraryType";
    public final static String SOURCE_DIRECTORY = "/Library/src/test/resources";
    public final static String NAME_FILE_DICTIONARIES = "LibraryCollection.txt";
    public final static String CHAR_OF_DIRECTORY = "/";
    public final static String EXPANSION = ".txt";

    public boolean checkFile(File file, String expectedNameFile) throws IOException
    {

        if(file.getName().equals(NAME_FILE+expectedNameFile+EXPANSION))
            return true;
        else
            return false;
    }


    public File searchLibrary(String expectedNameFile) throws IOException
    {
                File dir = new File(SOURCE_DIRECTORY);
                ArrayList<File> listFilesInDirectory = new ArrayList<>();
                for (File file : dir.listFiles())
                {
                    if (file.isFile())
                        listFilesInDirectory.add(file);
                }

                for(File file : listFilesInDirectory)
                {
                    if(checkFile(file, expectedNameFile))
                    {
                        return file;
                    }
                }
        File file = new File( SOURCE_DIRECTORY+CHAR_OF_DIRECTORY+NAME_FILE+expectedNameFile+EXPANSION);
        FileWriter writer = new FileWriter (file);
        return file;
    }

    public void createDictionaries(LinkedHashMap<String,Library> dictionaries) throws IOException
    {
        FileInputStream descriptorPosition = new FileInputStream(SOURCE_DIRECTORY+CHAR_OF_DIRECTORY+NAME_FILE_DICTIONARIES);
        descriptorPosition.getChannel().position(0);
        BufferedReader readerStream = new BufferedReader(new InputStreamReader(descriptorPosition));
        String[] tempRead = new String[4];

        while (readerStream.ready())
        {
            tempRead = readerStream.readLine().split(Library.REGEX_CHAR);
            dictionaries.put(tempRead[3],new Library(tempRead[3],tempRead[2],tempRead[0],tempRead[1],this));
        }
    }

    public void readFile(Library library) throws IOException
    {
        FileInputStream descriptorPosition = new FileInputStream(library.fileDir);
        descriptorPosition.getChannel().position(0);
        BufferedReader readerStream = new BufferedReader(new InputStreamReader(descriptorPosition));
        String[] tempRead = new String[2];

        while (readerStream.ready())
        {
            tempRead = readerStream.readLine().split(Library.SPLIT_CHAR);
            library.getDictionary().put(tempRead[0], tempRead[1]);
        }
    }

    public void writeFile(Library library) throws IOException
    {
        BufferedWriter writerStream = new BufferedWriter(new FileWriter(library.fileDir));
        for(String elemKey : library.getDictionary().keySet())
        {
            writerStream.write(elemKey+ Library.SPLIT_CHAR +library.getDictionary().get(elemKey)+"\n");
            writerStream.flush();
        }
    }

    public void deleteFile(String nameFile)
    {
        File deleteFile = new File(nameFile);
        deleteFile.delete();
    }

}

