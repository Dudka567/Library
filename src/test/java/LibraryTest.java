import org.junit.*;
import controller.Library;
import infrastructure.Config;
import infrastructure.LibraryFactory;
import model.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;



public class LibraryTest {
    private static final Integer GET_TYPE_ONE = 0;
    private static final String TYPE_LIBRARY_ONE = "src/main/resources/1temp.txt";
    private static final String TYPE_LIBRARY_THIRD = "src\\main\\resources\\1temp.txt";
    private static final String PATH_TESTLIBRARY_ONE = "../resources/0temp.txt";
    private static final String PATH_TESTLIBRARY_TWO = "../resources/1temp.txt";
    private static final String CORRECT_KEY = "cars";
    private static final String CORRECT_VALUE = "карс";
    private static final String INCORRECT_VALUE = "с";
    private static final String PAIR_ADDED = "The pair has been added to the dictionary.";
    private static final String INCORRECT_VALUE_FORMAT = "Incorrect value format";
    private static final String PAIR_DELETED = "The pair has been deleted to the dictionary.";
    private static final String PAIR_SEARCHED = "The pair is missing from the dictionary.";

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

        String actual = storage.searchStorage(TYPE_LIBRARY_ONE);

        String expected = new File(TYPE_LIBRARY_ONE).getPath();
        Assert.assertEquals(expected, actual);
        deleteFile(actual);
    }

    @Test
    public void testCreateLibrary_TypeThird_InDirectory(){
        FilesStorage storage = new FilesStorage();
        String actual = storage.searchStorage(TYPE_LIBRARY_THIRD);

        String expected = TYPE_LIBRARY_THIRD;
        Assert.assertEquals(expected, actual);
        deleteFile(actual);
    }

    @Test
    public void testAddPair_InLibraryTypeOne(){
        LibraryFactory libraryFactory = new LibraryFactory(new Config());
        List<Library> dictionaries = libraryFactory.createLibraries();
        List<String> actual = dictionaries.get(GET_TYPE_ONE).addPair(CORRECT_KEY, CORRECT_VALUE);

        List<String> expected = new ArrayList<>();
        expected.add(PAIR_ADDED);

        Assert.assertEquals(expected, actual);
        deleteFile(PATH_TESTLIBRARY_ONE);
        deleteFile(PATH_TESTLIBRARY_TWO);
    }

    @Test
    public void testValidation_ForAddPairTypeOne(){
        LibraryFactory libraryFactory = new LibraryFactory(new Config());
        List<Library> dictionaries = libraryFactory.createLibraries();
        List<String> actual = dictionaries.get(GET_TYPE_ONE).addPair(CORRECT_KEY, INCORRECT_VALUE);

        List<String> expected = new ArrayList<>();
        expected.add(INCORRECT_VALUE_FORMAT);

        Assert.assertEquals(expected, actual);
        deleteFile(PATH_TESTLIBRARY_ONE);
        deleteFile(PATH_TESTLIBRARY_TWO);
    }


    @Test
    public void testDeletePair_InLibraryTypeOne(){
        LibraryFactory libraryFactory = new LibraryFactory(new Config());
        List<Library> dictionaries = libraryFactory.createLibraries();
        dictionaries.get(GET_TYPE_ONE).addPair(CORRECT_KEY, CORRECT_VALUE);
        String actual = dictionaries.get(GET_TYPE_ONE).deletePair(CORRECT_KEY);

        String expected = PAIR_DELETED;
        Assert.assertEquals(expected, actual);
        deleteFile(PATH_TESTLIBRARY_ONE);
        deleteFile(PATH_TESTLIBRARY_TWO);
    }

    @Test
    public void testSearchPair_InLibraryTypeOne(){
        LibraryFactory libraryFactory = new LibraryFactory(new Config());
        List<Library> dictionaries = libraryFactory.createLibraries();
        String actual = dictionaries.get(GET_TYPE_ONE).searchPair(CORRECT_KEY);

        String expected = PAIR_SEARCHED;
        Assert.assertEquals(expected, actual);
        deleteFile(PATH_TESTLIBRARY_ONE);
        deleteFile(PATH_TESTLIBRARY_TWO);
    }

    private void deleteFile(String nameFile) {
        File fileForDelete = new File(nameFile);
        fileForDelete.delete();
    }
}