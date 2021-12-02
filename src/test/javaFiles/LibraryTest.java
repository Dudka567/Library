package src.test.javaFiles;  

import org.junit.*;

import java.io.IOException;
import java.util.LinkedHashMap;

public class LibraryTest {
    public static final String TYPE_LIBRARY_ONE = "1";
    public static final String TYPE_LIBRARY_THIRD = "3";
    public static final String PATH_TESTLIBRARY = "src\\main\\resources\\LibraryType3.txt";
    public static final String CORRECT_KEY = "cars";
    public static final String CORRECT_VALUE = "карс";
    public static final String INCORRECT_KEY = "carsz";
    public static final String INCORRECT_VALUE = "с";
    public static final String SEARCH_CORRECT_VALUE = "Value:карс";

    @Test
    public void testSearchLibrary_TypeOne_InDirectory() throws IOException
    {
        FileManager manager = new FileManager();
        LibraryFactory libraryFactory = new LibraryFactory(manager);
        libraryFactory.getDictionaries().get(TYPE_LIBRARY_THIRD).setFileDir(manager.searchLibrary(TYPE_LIBRARY_THIRD));

        String expected = PATH_TESTLIBRARY;
        Assert.assertEquals(expected, libraryFactory.getDictionaries().get(TYPE_LIBRARY_THIRD).fileDir.toString());
    }

    @Test
    public void testCreateLibrary_TypeThird_InDirectory() throws IOException
    {
        FileManager manager = new FileManager();
        manager.deleteFile(PATH_TESTLIBRARY);
        LibraryFactory libraryFactory = new LibraryFactory(manager);
        libraryFactory.getDictionaries().get(TYPE_LIBRARY_THIRD).setFileDir(manager.searchLibrary(TYPE_LIBRARY_THIRD));

        String expected = PATH_TESTLIBRARY;
        Assert.assertEquals(expected, libraryFactory.getDictionaries().get(TYPE_LIBRARY_THIRD).fileDir.toString());

    }

    @Test
    public void testReadPairs_IntoLibraryTypeOne() throws IOException
    {
        FileManager manager = new FileManager();
        LibraryFactory libraryFactory = new LibraryFactory(manager);
        libraryFactory.getDictionaries().get(TYPE_LIBRARY_ONE).setFileDir(manager.searchLibrary(TYPE_LIBRARY_ONE));
        libraryFactory.getDictionaries().get(TYPE_LIBRARY_ONE).readPairs();

        String expected = CORRECT_VALUE;
        Assert.assertEquals(expected, libraryFactory.getDictionaries().get(TYPE_LIBRARY_ONE).getDictionary().get(CORRECT_KEY));

    }

    @Test
    public void testAddPair_InLibraryTypeOne() throws IOException
    {
        FileManager manager = new FileManager();
        LibraryFactory libraryFactory = new LibraryFactory(manager);
        libraryFactory.getDictionaries().get(TYPE_LIBRARY_ONE).setFileDir(manager.searchLibrary(TYPE_LIBRARY_ONE));
        libraryFactory.getDictionaries().get(TYPE_LIBRARY_ONE).addPair(CORRECT_KEY,CORRECT_VALUE);

        LinkedHashMap<String,String> expected = new LinkedHashMap<>();
        expected.put(CORRECT_KEY,CORRECT_VALUE);
        Assert.assertEquals(expected.get(CORRECT_KEY), libraryFactory.getDictionaries().get(TYPE_LIBRARY_ONE).getDictionary().get(CORRECT_KEY));
    }

    @Test
    public void testValidation_ForAddPairTypeOne() throws IOException
    {
        FileManager manager = new FileManager();
        LibraryFactory libraryFactory = new LibraryFactory(manager);
        libraryFactory.getDictionaries().get(TYPE_LIBRARY_ONE).setFileDir(manager.searchLibrary(TYPE_LIBRARY_ONE));
        libraryFactory.getDictionaries().get(TYPE_LIBRARY_ONE).addPair(INCORRECT_KEY,INCORRECT_VALUE);

        String expected = null;
        Assert.assertEquals(expected, libraryFactory.getDictionaries().get(TYPE_LIBRARY_ONE).getDictionary().get(INCORRECT_KEY));
    }


    @Test
    public void testDeletePair_InLibraryTypeOne() throws IOException
    {
        FileManager manager = new FileManager();
        LibraryFactory libraryFactory = new LibraryFactory(manager);
        libraryFactory.getDictionaries().get(TYPE_LIBRARY_ONE).setFileDir(manager.searchLibrary(TYPE_LIBRARY_ONE));
        libraryFactory.getDictionaries().get(TYPE_LIBRARY_ONE).addPair(CORRECT_KEY,CORRECT_VALUE);
        libraryFactory.getDictionaries().get(TYPE_LIBRARY_ONE).deletePair(CORRECT_KEY);

        String expected = null;
        Assert.assertEquals(expected, libraryFactory.getDictionaries().get(TYPE_LIBRARY_ONE).getDictionary().get(CORRECT_KEY));
    }

    @Test
    public void testSearchPair_InLibraryTypeOne() throws IOException
    {
        FileManager manager = new FileManager();
        LibraryFactory libraryFactory = new LibraryFactory(manager);
        libraryFactory.getDictionaries().get(TYPE_LIBRARY_ONE).setFileDir(manager.searchLibrary(TYPE_LIBRARY_ONE));
        libraryFactory.getDictionaries().get(TYPE_LIBRARY_ONE).deletePair(CORRECT_KEY);
        libraryFactory.getDictionaries().get(TYPE_LIBRARY_ONE).addPair(CORRECT_KEY,CORRECT_VALUE);

        String expected = SEARCH_CORRECT_VALUE;
        Assert.assertEquals(expected, libraryFactory.getDictionaries().get(TYPE_LIBRARY_ONE).searchPair(CORRECT_KEY));
    }

}

