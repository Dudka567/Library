package src.main.javaFiles;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleApp {
    private Map<String, LibraryFunctionally> listDictionaries;

    public ConsoleApp(LibraryFactory libraryFactory) {
        this.listDictionaries = libraryFactory.createLibraries();
    }

    public void work() {

        boolean exitMainMenu = false;
        String userSelect;
        while (!exitMainMenu) {

            System.out.print(ConsoleConstants.ASK_ABOUT_TYPE_DICTIONARY + ConsoleConstants.CHAR_FOR_NEXT_LINE);
            for (String variant : listDictionaries.keySet()) {
                System.out.println(variant + ConsoleConstants.CHAR_POINT + listDictionaries.get(variant).getNameLibrary());
            }
            System.out.print(ConsoleConstants.EXIT + ConsoleConstants.CHAR_FOR_NEXT_LINE + ConsoleConstants.CHOOSE_USER);
            try {
                userSelect = ConsoleConstants.user.next();

                for (String compareLine : listDictionaries.keySet()) {
                    if (userSelect.equals(ConsoleConstants.EXIT_LINE)) {
                        exitMainMenu = true;
                        break;
                    } else if (listDictionaries.keySet().contains(compareLine)) {
                        for (String Line : listDictionaries.keySet()) {
                            if (userSelect.equals(Line)) {
                                workWithLibrary(listDictionaries.get(Line));
                                break;
                            }
                        }
                        System.out.println(ConsoleConstants.NOT_SEARCH);
                        break;
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println(ConsoleConstants.ERROR_TYPE_DATA);
            } catch (NullPointerException e) {
                System.out.println(ConsoleConstants.ERROR_NAME_FILE);
            }
        }
    }

    public void workWithLibrary(LibraryFunctionally library) {
        boolean exitLibraryMenu = false;
        int userSelectForDictionary;
        while (!exitLibraryMenu) {
            System.out.print(ConsoleConstants.ASK_ABOUT_OPERATION_DICTIONARY);
            for (TypesOperations line : TypesOperations.values()) {
                System.out.print(line.getALLINFO());
            }
            System.out.print(ConsoleConstants.CHOOSE_USER);
            try {
                userSelectForDictionary = Integer.parseInt(ConsoleConstants.user.next());
                TypesOperations type = TypesOperations.fromValue(String.valueOf(userSelectForDictionary));
                Map<String, Action> menuForLibrary = new HashMap<>();
                menuForLibrary.put(TypesOperations.CHOOSE_OPERATION_ONE.getNUMBER(), new ActionReadPairs(library));
                menuForLibrary.put(TypesOperations.CHOOSE_OPERATION_TWO.getNUMBER(), new ActionAddPairs(library));
                menuForLibrary.put(TypesOperations.CHOOSE_OPERATION_THREE.getNUMBER(), new ActionDeletePairs(library));
                menuForLibrary.put(TypesOperations.CHOOSE_OPERATION_FOUR.getNUMBER(), new ActionSearchPair(library));
                menuForLibrary.put(TypesOperations.CHOOSE_OPERATION_FIFE.getNUMBER(), new ActionExitLibrary(this));

                if (menuForLibrary.get(type.getNUMBER()) == null) {
                    System.out.println(ConsoleConstants.NOT_SEARCH);
                } else {
                    menuForLibrary.get(type.getNUMBER()).execute();
                }

            } catch (NumberFormatException e) {
                System.out.println(ConsoleConstants.ERROR_TYPE_DATA);
            } catch (NullPointerException e) {
                System.out.println(ConsoleConstants.ERROR_FIND_PAIRS);
            } catch (IOException e) {
                System.out.println(ConsoleConstants.ERROR_NAME_FILE);
            }

        }

    }


}
