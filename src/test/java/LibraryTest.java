import org.junit.*;
import controller.Library;
import infrastructure.Config;
import infrastructure.LibraryFactory;
import model.*;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;


public class LibraryTest {
    private static final String GET_TYPE_ONE = "1";
    private static final String TYPE_LIBRARY_ONE = "../resources/LibraryType1.txt";
    private static final String TYPE_LIBRARY_THIRD = "../resources/LibraryType3.txt";
    private static final String PATH_TESTLIBRARY_ONE = "../resources/0temp.txt";
    private static final String PATH_TESTLIBRARY_TWO = "../resources/1temp.txt";
    private static final String CORRECT_KEY = "cars";
    private static final String CORRECT_VALUE = "карс";
    private static final String INCORRECT_KEY = "carsz";
    private static final String INCORRECT_VALUE = "с";
    private static final String SEARCH_CORRECT_VALUE = "Value: карс";

    public static void main(String[] args){
        LibraryTest tests = new LibraryTest();
        tests.testSearchLibrary_TypeOne_InDirectory();
        tests.testCreateLibrary_TypeThird_InDirectory();
        tests.testAddPair_InLibraryTypeOne();
        tests.testValidation_ForAddPairTypeOne();
        tests.testDeletePair_InLibraryTypeOne();
        tests.testSearchPair_InLibraryTypeOne();
        System.out.println("6 / 6 tests passed successfully");
    }

    @Test
    public void testSearchLibrary_TypeOne_InDirectory()  {
        FilesStorage storage = new FilesStorage(TYPE_LIBRARY_ONE);

        String actrual = storage.searchStorage(TYPE_LIBRARY_ONE);

        String expected = new File(TYPE_LIBRARY_ONE).getPath();
        Assert.assertEquals(expected, actrual);
    }

    @Test
    public void testCreateLibrary_TypeThird_InDirectory(){
        FilesStorage storage = new FilesStorage();
        String actrual = storage.searchStorage(TYPE_LIBRARY_THIRD);

        String expected = new File(PATH_TESTLIBRARY_ONE).getPath();
        Assert.assertEquals(expected, actrual);
        deleteFile(actrual);
    }

    @Test
    public void testAddPair_InLibraryTypeOne(){
        LibraryFactory libraryFactory = new LibraryFactory(new Config());
        Map<String, Library> libraries = libraryFactory.createLibraries();
        libraries.get(GET_TYPE_ONE).addPair(CORRECT_KEY, CORRECT_VALUE);

        LinkedHashMap<String, String> expected = new LinkedHashMap<>();
        expected.put(CORRECT_KEY, CORRECT_VALUE);
        Assert.assertEquals(expected.get(CORRECT_KEY), libraries.get(GET_TYPE_ONE).getLocalDictionary().get(CORRECT_KEY));
        deleteFile(PATH_TESTLIBRARY_ONE);
        deleteFile(PATH_TESTLIBRARY_TWO);
    }

    @Test
    public void testValidation_ForAddPairTypeOne(){
        LibraryFactory libraryFactory = new LibraryFactory(new Config());
        Map<String, Library> libraries = libraryFactory.createLibraries();
        libraries.get(GET_TYPE_ONE).addPair(INCORRECT_KEY, INCORRECT_VALUE);

        String expected = null;
        Assert.assertEquals(expected, libraries.get(GET_TYPE_ONE).getLocalDictionary().get(INCORRECT_KEY));
        deleteFile(PATH_TESTLIBRARY_ONE);
        deleteFile(PATH_TESTLIBRARY_TWO);
    }


    @Test
    public void testDeletePair_InLibraryTypeOne(){
        LibraryFactory libraryFactory = new LibraryFactory(new Config());
        Map<String, Library> libraries = libraryFactory.createLibraries();
        libraries.get(GET_TYPE_ONE).addPair(CORRECT_KEY, CORRECT_VALUE);
        libraries.get(GET_TYPE_ONE).deletePair(CORRECT_KEY);

        String expected = null;
        Assert.assertEquals(expected, libraries.get(GET_TYPE_ONE).getLocalDictionary().get(CORRECT_KEY));
        deleteFile(PATH_TESTLIBRARY_ONE);
        deleteFile(PATH_TESTLIBRARY_TWO);
    }

    @Test
    public void testSearchPair_InLibraryTypeOne(){
        LibraryFactory libraryFactory = new LibraryFactory(new Config());
        Map<String, Library> libraries = libraryFactory.createLibraries();
        libraries.get(GET_TYPE_ONE).deletePair(CORRECT_KEY);
        libraries.get(GET_TYPE_ONE).addPair(CORRECT_KEY, CORRECT_VALUE);

        String expected = SEARCH_CORRECT_VALUE;
        Assert.assertEquals(expected, libraries.get(GET_TYPE_ONE).searchPair(CORRECT_KEY));
        deleteFile(PATH_TESTLIBRARY_ONE);
        deleteFile(PATH_TESTLIBRARY_TWO);
    }

    public void deleteFile(String nameFile) {
        File fileForDelete = new File(nameFile);
        fileForDelete.delete();
    }
}