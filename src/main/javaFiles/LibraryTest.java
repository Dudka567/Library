package res.main.javaFiles;  

import org.junit.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.LinkedHashMap;

public class LibraryTest {

    @Test
    public void testSearchFile_ForLibraryTypeOne_InDirectory() throws IOException
    {
        FileManager manager = new FileManager(new LibraryClassTypeOne(1,null));
        LibraryClassTypeOne library = new LibraryClassTypeOne(1, manager.searchLibrary());

        String expected = "src\\main\\resources\\map.txt";
        Assert.assertEquals(expected, library.fileDir.toString());
    }

    @Test
    public void testCreateFile_ForLibraryTestTypeThird_InDirectory() throws IOException
    {
        FileManager manager = new FileManager(new TestLibraryClassTypeThird(3,null));
        TestLibraryClassTypeThird library = new TestLibraryClassTypeThird(3, manager.searchLibrary());

        String expected = "src\\main\\resources\\TempFileLibraryType3.txt";
        Assert.assertEquals(expected, library.fileDir.toString());

    }

    @Test
    public void testAddPair_InLibrary_And_ReadThisPair_FromThisLibrary() throws IOException
    {
        FileManager manager = new FileManager(new LibraryClassTypeOne(1,null));
        LibraryClassTypeOne library = new LibraryClassTypeOne(1, manager.searchLibrary());
        library.addPair("cars","карс");
        library.readPairs(true);

           LinkedHashMap<String,String> expected = new LinkedHashMap<>();
           expected.put("cars","карс");
        Assert.assertEquals(expected.get("cars"), library.getDictionary().get("cars"));
    }

    @Test
    public void testValidation_ForAddPair_InLibrary() throws IOException
    {
        FileManager manager = new FileManager(new LibraryClassTypeOne(1,null));
        LibraryClassTypeOne library = new LibraryClassTypeOne(1, manager.searchLibrary());
        library.addPair("carsa","к");

        String expected = null;
        Assert.assertEquals(expected, library.getDictionary().get("carsa"));
    }

    @Test
    public void testDeletePair_InLibrary() throws IOException
    {
        FileManager manager = new FileManager(new LibraryClassTypeOne(1,null));
        LibraryClassTypeOne library = new LibraryClassTypeOne(1, manager.searchLibrary());
        library.addPair("pair","пэир");
        library.deletePair("pair");

        String expected = null;
        Assert.assertEquals(expected, library.getDictionary().get("pair"));
    }

    @Test
    public void testSearchPair_InLibrary() throws IOException
    {
        FileManager manager = new FileManager(new LibraryClassTypeOne(1,null));
        LibraryClassTypeOne library = new LibraryClassTypeOne(1, manager.searchLibrary());
        library.addPair("sear","сиар");

        String expected = "сиар";
        Assert.assertEquals(expected, library.searchPair("sear"));
    }

}
