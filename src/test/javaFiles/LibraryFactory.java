package src.test.javaFiles; 
import java.io.IOException;
import java.util.LinkedHashMap;

public class LibraryFactory
{
    protected LinkedHashMap<String,Library> dictionaries;

    public LibraryFactory(FileManager manager) throws IOException
    {
        dictionaries = new LinkedHashMap<>();
        manager.createDictionaries(dictionaries);
    }

    public LinkedHashMap<String, Library> getDictionaries()
    {
        return dictionaries;
    }

}
