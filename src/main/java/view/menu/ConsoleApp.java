package view.menu;

import controller.Library;
import view.commands.Action;

import java.util.Map;


public class ConsoleApp {
    private Map<String, Library> listDictionaries;
    private Map<Integer, Action> listAction;

    public ConsoleApp(Map<String, Library> listDictionaries, Map<Integer, Action> listAction) {
        this.listDictionaries = listDictionaries;
        this.listAction = listAction;
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

    public void workWithLibrary(Library library) {
        boolean exitLibraryMenu = false;
        int userSelectForDictionary;
        while (!exitLibraryMenu) {
            System.out.print(ConsoleConstants.ASK_ABOUT_OPERATION_DICTIONARY);

            for (Action actionInfo : listAction.values()) {
                System.out.print(actionInfo.getINFO());
            }

            System.out.print(ConsoleConstants.CHOOSE_USER);
            try {
                userSelectForDictionary = Integer.parseInt(ConsoleConstants.user.next());

                if (listAction.get(userSelectForDictionary) == null) {
                    System.out.println(ConsoleConstants.NOT_SEARCH);
                } else if (userSelectForDictionary == listAction.size()) {
                    exitLibraryMenu = true;
                }
                listAction.get(userSelectForDictionary).execute(library);

            } catch (NumberFormatException e) {
                System.out.println(ConsoleConstants.ERROR_TYPE_DATA);
            } catch (NullPointerException e) {
                System.out.println(ConsoleConstants.ERROR_FIND_PAIRS);
            }
        }

    }


}