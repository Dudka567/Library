package src.main.javaFiles; 
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class LibraryFactory
{
    protected LinkedHashMap<String,Library> dictionaries;

    public LibraryFactory(FileManager manager) throws IOException
    {
        dictionaries = new LinkedHashMap<>();
        createDictionaries(manager.searchDictionaries(),manager);
    }

    public void createDictionaries(LinkedList<String[]> listDictionaries,FileManager manager)
    {
        for (String[] arg : listDictionaries)
        dictionaries.put(arg[3],new Library(arg[3],arg[2],arg[0],arg[1],manager));
    }
    public LinkedHashMap<String, Library> getDictionaries()
    {
        return dictionaries;
    }

}
