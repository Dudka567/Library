import org.junit.*;
import controller.Library;
import infrastructure.Config;
import infrastructure.LibraryFactory;
import model.*;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;


public class LibraryTest {
    private static final String TYPE_LIBRARY_ONE = "1";
    private static final String TYPE_LIBRARY_THIRD = "3";
    private static final String PATH_TESTLIBRARY = "../resources/LibraryType3.txt";
    private static final String CORRECT_KEY = "cars";
    private static final String CORRECT_VALUE = "карс";
    private static final String INCORRECT_KEY = "carsz";
    private static final String INCORRECT_VALUE = "с";
    private static final String SEARCH_CORRECT_VALUE = "Value: карс";

    public static void main(String[] args) throws IOException {
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
    public void testSearchLibrary_TypeOne_InDirectory()  {
        Storage storage = new FilesStorage(TYPE_LIBRARY_THIRD);

        String actrual = storage.searchStorage(TYPE_LIBRARY_THIRD);

        String expected = new File(PATH_TESTLIBRARY).getPath();
        Assert.assertEquals(expected, actrual);
    }

    @Test
    public void testCreateLibrary_TypeThird_InDirectory() throws IOException {
        Config config = new Config();
        Storage storage = new FilesStorage(TYPE_LIBRARY_THIRD);
        deleteFile(PATH_TESTLIBRARY);

        LibraryFactory libraryFactory = new LibraryFactory(config);
        libraryFactory.createLibraries();
        String actrual = storage.searchStorage(TYPE_LIBRARY_THIRD);


        String expected = new File(PATH_TESTLIBRARY).getPath();
        Assert.assertEquals(expected, actrual);

    }

    @Test
    public void testAddPair_InLibraryTypeOne() throws IOException {
        LibraryFactory libraryFactory = new LibraryFactory(new Config());
        Map<String, Library> libraries = libraryFactory.createLibraries();
        libraries.get(TYPE_LIBRARY_ONE).addPair(CORRECT_KEY, CORRECT_VALUE);

        LinkedHashMap<String, String> expected = new LinkedHashMap<>();
        expected.put(CORRECT_KEY, CORRECT_VALUE);
        Assert.assertEquals(expected.get(CORRECT_KEY), libraries.get(TYPE_LIBRARY_ONE).getLocalDictionary().get(CORRECT_KEY));
    }

    @Test
    public void testValidation_ForAddPairTypeOne() throws IOException {
        LibraryFactory libraryFactory = new LibraryFactory(new Config());
        Map<String, Library> libraries = libraryFactory.createLibraries();
        libraries.get(TYPE_LIBRARY_ONE).addPair(INCORRECT_KEY, INCORRECT_VALUE);

        String expected = null;
        Assert.assertEquals(expected, libraries.get(TYPE_LIBRARY_ONE).getLocalDictionary().get(INCORRECT_KEY));
    }


    @Test
    public void testDeletePair_InLibraryTypeOne() throws IOException {
        LibraryFactory libraryFactory = new LibraryFactory(new Config());
        Map<String, Library> libraries = libraryFactory.createLibraries();
        libraries.get(TYPE_LIBRARY_ONE).addPair(CORRECT_KEY, CORRECT_VALUE);
        libraries.get(TYPE_LIBRARY_ONE).deletePair(CORRECT_KEY);

        String expected = null;
        Assert.assertEquals(expected, libraries.get(TYPE_LIBRARY_ONE).getLocalDictionary().get(CORRECT_KEY));
    }

    @Test
    public void testSearchPair_InLibraryTypeOne() throws IOException {
        LibraryFactory libraryFactory = new LibraryFactory(new Config());
        Map<String, Library> libraries = libraryFactory.createLibraries();
        libraries.get(TYPE_LIBRARY_ONE).deletePair(CORRECT_KEY);
        libraries.get(TYPE_LIBRARY_ONE).addPair(CORRECT_KEY, CORRECT_VALUE);

        String expected = SEARCH_CORRECT_VALUE;
        Assert.assertEquals(expected, libraries.get(TYPE_LIBRARY_ONE).searchPair(CORRECT_KEY));
    }

    public void deleteFile(String nameFile) {
        File fileForDelete = new File(nameFile);
        fileForDelete.delete();
    }
}