package src.test.javaFiles;  

import src.main.javaFiles.*;
import org.junit.*;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

public class LibraryTest {
    public static final String TYPE_LIBRARY_ONE = "1";
    public static final String TYPE_LIBRARY_THIRD = "3";
    public static final String PATH_TESTLIBRARY = "..\\resources\\LibraryType3.txt";
    public static final String CORRECT_KEY = "cars";
    public static final String CORRECT_VALUE = "карс";
    public static final String INCORRECT_KEY = "carsz";
    public static final String INCORRECT_VALUE = "с";
    public static final String SEARCH_CORRECT_VALUE = "Value: карс";

 public static void main(String[] args) throws IOException
    {
	LibraryTest tests = new LibraryTest();
        tests.testSearchLibrary_TypeOne_InDirectory();
	tests.testCreateLibrary_TypeThird_InDirectory();
	tests.testAddPair_InLibraryTypeOne();
	tests.testValidation_ForAddPairTypeOne();
	tests.testDeletePair_InLibraryTypeOne();
	tests.testSearchPair_InLibraryTypeOne();
	System.out.println("7 / 7 tests passed successfully");
    }
	
    @Test
    public void testSearchLibrary_TypeOne_InDirectory() throws IOException
    {
        ConfigManagerFunctionally configManager = new ConfigManager();
		
        File actrual = configManager.searchLibrary(TYPE_LIBRARY_THIRD);

        File expected = new File(PATH_TESTLIBRARY);
        Assert.assertEquals(expected, actrual);
    }

    @Test
    public void testCreateLibrary_TypeThird_InDirectory() throws IOException
    {
	ConfigManagerFunctionally configManager = new ConfigManager();
        FileManager fileManager = new FileManager(new File(PATH_TESTLIBRARY));
        fileManager.deleteFile(PATH_TESTLIBRARY);

        LibraryFactory libraryFactory = new LibraryFactory();
        libraryFactory.createLibraries();
        File actrual = configManager.searchLibrary(TYPE_LIBRARY_THIRD);

        File expected = new File(PATH_TESTLIBRARY);
        Assert.assertEquals(expected, actrual);

    }

    @Test
    public void testAddPair_InLibraryTypeOne() throws IOException
    {
        LibraryFactory libraryFactory = new LibraryFactory();
        LinkedHashMap<String, Library> libraries = libraryFactory.createLibraries();
        libraries.get(TYPE_LIBRARY_ONE).addPair(CORRECT_KEY,CORRECT_VALUE);

        LinkedHashMap<String,String> expected = new LinkedHashMap<>();
        expected.put(CORRECT_KEY,CORRECT_VALUE);
        Assert.assertEquals(expected.get(CORRECT_KEY), libraries.get(TYPE_LIBRARY_ONE).getLocalDictionary().get(CORRECT_KEY));
    }

    @Test
    public void testValidation_ForAddPairTypeOne() throws IOException
    {
        LibraryFactory libraryFactory = new LibraryFactory();
        LinkedHashMap<String, Library> libraries = libraryFactory.createLibraries();
        libraries.get(TYPE_LIBRARY_ONE).addPair(INCORRECT_KEY,INCORRECT_VALUE);

        String expected = null;
        Assert.assertEquals(expected, libraries.get(TYPE_LIBRARY_ONE).getLocalDictionary().get(INCORRECT_KEY));
    }


    @Test
    public void testDeletePair_InLibraryTypeOne() throws IOException
    {
        LibraryFactory libraryFactory = new LibraryFactory();
        LinkedHashMap<String, Library> libraries = libraryFactory.createLibraries();
        libraries.get(TYPE_LIBRARY_ONE).addPair(CORRECT_KEY,CORRECT_VALUE);
        libraries.get(TYPE_LIBRARY_ONE).deletePair(CORRECT_KEY);

        String expected = null;
        Assert.assertEquals(expected, libraries.get(TYPE_LIBRARY_ONE).getLocalDictionary().get(CORRECT_KEY));
    }

    @Test
    public void testSearchPair_InLibraryTypeOne() throws IOException
    {
        LibraryFactory libraryFactory = new LibraryFactory();
        LinkedHashMap<String, Library> libraries = libraryFactory.createLibraries();
        libraries.get(TYPE_LIBRARY_ONE).deletePair(CORRECT_KEY);
        libraries.get(TYPE_LIBRARY_ONE).addPair(CORRECT_KEY,CORRECT_VALUE);

        String expected = SEARCH_CORRECT_VALUE;
        Assert.assertEquals(expected, libraries.get(TYPE_LIBRARY_ONE).searchPair(CORRECT_KEY));
    }

}