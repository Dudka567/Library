package src.main.javaFiles; 

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class ConsoleApp implements ConsoleAppFunctionally {
    public static final String ASK_ABOUT_TYPE_DICTIONARY = "What type of dictionary do you want to work with?";
    public static final String ASK_ABOUT_OPERATION_DICTIONARY = "What kind of dictionary operation do you want to perform?\n";
    public static final String CHAR_FOR_NEXT_LINE = "\n";
    public static final String EXIT = "Enter: exit - to close the application";
    public static final String CHOOSE_USER = "Enter the number corresponding to your choice:";
    public static final String CHAR_POINT = ".";
    public static final String EXIT_LINE = "exit";
    public static final String KEY = "Key:";
    public static final String VALUE = "Value:";
    public static final String CHAR_SPACE = " ";
    public static final String NOT_SEARCH = "There is no such answer option.\nPlease try typing again.";
    public static final String ERROR_TYPE_DATA = "Invalid data type.";
    public static final String ERROR_NAME_FILE = "Wrong file name.";
    public static final String ERROR_FIND_PAIRS = "The pair is missing from the dictionary.";
    public static final String INPUT_KEY = "Enter the key:";
    public static final String INPUT_VALUE = "Enter a value:";

    private boolean exitMainMenu = false;
    private boolean exitLibraryMenu = false;
    private String userSelect;
    private int userSelectForDictionary = 0;
    private Scanner user = new Scanner(System.in);

    private LinkedHashMap<String, Library> libraryFactory;


    public ConsoleApp(LibraryFactoryFunctionally libraryFactory) throws IOException {
        this.libraryFactory = libraryFactory.createLibraries();
    }

    @Override
    public void work() throws IOException {
        while (!exitMainMenu) {

            System.out.print(ASK_ABOUT_TYPE_DICTIONARY + CHAR_FOR_NEXT_LINE);
            for (String variant : libraryFactory.keySet()) {
                System.out.println(variant + CHAR_POINT + libraryFactory.get(variant).getNameLibrary());
            }
            System.out.print(EXIT + CHAR_FOR_NEXT_LINE + CHOOSE_USER);
            try {
                userSelect = user.next();

                for (String compareLine : libraryFactory.keySet()) {
                    if (userSelect.equals(EXIT_LINE)) {
                        exitMainMenu = true;
                        break;
                    } else if (libraryFactory.keySet().contains(compareLine)) {
                        for (String Line : libraryFactory.keySet()) {
                            if (userSelect.equals(Line)) {
                                workWithLibrary(libraryFactory.get(Line));
                                break;
                            }
                        }
                        System.out.println(NOT_SEARCH);
                        break;
                    }

                }

            } catch (NumberFormatException e) {
                System.out.println(ERROR_TYPE_DATA);
            } catch (NullPointerException e) {
                System.out.println(ERROR_NAME_FILE);
            }

        }
    }

    @Override
    public void workWithLibrary(Library library) throws IOException {
        while (!exitLibraryMenu) {
            System.out.print(ASK_ABOUT_OPERATION_DICTIONARY);
            for (TypesOperations line : TypesOperations.values()) {
                System.out.print(line.getALLINFO());
            }
            System.out.print(CHOOSE_USER);
            try {
                userSelectForDictionary = Integer.parseInt(user.next());
                TypesOperations type = TypesOperations.fromValue(String.valueOf(userSelectForDictionary));

                switch (type) {
                    case CHOOSE_OPERATION_ONE: {
                        library.readPairs();
                        for (String lineKey : library.getLocalDictionary().keySet()) {
                            System.out.println(KEY + lineKey + CHAR_SPACE + VALUE + library.getLocalDictionary().get(lineKey));
                        }
                        break;
                    }
                    case CHOOSE_OPERATION_TWO: {
                        System.out.print(INPUT_KEY);
                        String tempKey = user.next();
                        System.out.print(INPUT_VALUE);
                        String tempValue = user.next();
                        System.out.println(library.addPair(tempKey, tempValue));
                        break;
                    }
                    case CHOOSE_OPERATION_THREE: {
                        System.out.print(INPUT_KEY);
                        String tempKey = user.next();
                        System.out.println(library.deletePair(tempKey));
                        break;
                    }
                    case CHOOSE_OPERATION_FOUR: {
                        System.out.print(INPUT_KEY);
                        String tempKey = user.next();
                        System.out.println(library.searchPair(tempKey));
                        break;
                    }
                    case CHOOSE_OPERATION_FIFE: {
                        exitLibraryMenu = true;
                        break;
                    }
                    default: {
                        System.out.println(NOT_SEARCH);
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println(ERROR_TYPE_DATA);
            } catch (NullPointerException e) {
                System.out.println(ERROR_FIND_PAIRS);
            } catch (IOException e) {
                System.out.println(ERROR_NAME_FILE);
            }

        }
        exitLibraryMenu = false;

    }


}
