package src.main.java.view.menu;

import src.main.java.view.commands.Action;

import java.util.*;

public class ConsoleApp {
    private final Integer MENU_COUNTING = 1;
    private Map<Integer, String> dictionariesTypes;
    private Map<Integer, Action> actions;

    public ConsoleApp(List<String> dictionariesTypes, List<Action> actions) {
        this.dictionariesTypes = new HashMap<>();
        initDitcionariesTypes(dictionariesTypes);

        this.actions = new HashMap<>();
        initActions(actions);
    }

    public void initDitcionariesTypes(List<String> dictionariesTypes) {
        for (int dictionaryCounter = MENU_COUNTING; dictionaryCounter < dictionariesTypes.size() + MENU_COUNTING; dictionaryCounter++) {
            this.dictionariesTypes.put(dictionaryCounter, dictionariesTypes.get(dictionaryCounter - MENU_COUNTING));
        }
    }

    public void initActions(List<Action> actions) {
        for (int actionCounter = MENU_COUNTING; actionCounter < actions.size() + MENU_COUNTING; actionCounter++) {
            Action tempAction = actions.get(actionCounter - MENU_COUNTING);
            tempAction.setPosition(actionCounter);
            this.actions.put(actionCounter, tempAction);
        }
    }

    public void work() {

        boolean exitMainMenu = false;
        String userSelect;
        while (!exitMainMenu) {
            System.out.print(ConsoleConstants.ASK_ABOUT_TYPE_DICTIONARY);

            for (Integer menuCounter : dictionariesTypes.keySet()) {
                System.out.println(menuCounter + ConsoleConstants.CHAR_POINT + dictionariesTypes.get(menuCounter));
            }


            System.out.print(ConsoleConstants.EXIT + ConsoleConstants.CHAR_FOR_NEXT_LINE + ConsoleConstants.CHOOSE_USER);
            try {
                userSelect = ConsoleConstants.user.next();

                if (userSelect.equals(ConsoleConstants.EXIT_LINE)) {
                    exitMainMenu = true;
                    break;
                } else if (dictionariesTypes.containsKey(Integer.parseInt(userSelect))) {
                    workWithLibrary(dictionariesTypes.get(Integer.parseInt(userSelect)));
                } else {
                    System.out.println(ConsoleConstants.NOT_SEARCH);
                }

            } catch (NumberFormatException e) {
                System.out.println(ConsoleConstants.ERROR_TYPE_DATA);
            } catch (NullPointerException e) {
                System.out.println(ConsoleConstants.ERROR_NAME_FILE);
            }
        }
    }

    public void workWithLibrary(String typeLibrary) {
        boolean exitLibraryMenu = false;
        int userSelectForDictionary;
        while (!exitLibraryMenu) {
            System.out.print(ConsoleConstants.ASK_ABOUT_OPERATION_DICTIONARY);

            for (Integer actionCounter : actions.keySet()) {
                System.out.print(actions.get(actionCounter).getPosition() + actions.get(actionCounter).getTitle());
            }

            System.out.print(ConsoleConstants.CHOOSE_USER);
            try {
                userSelectForDictionary = Integer.parseInt(ConsoleConstants.user.next());

                if (actions.get(userSelectForDictionary) == null) {
                    System.out.println(ConsoleConstants.NOT_SEARCH);
                } else if (userSelectForDictionary == actions.size()) {
                    exitLibraryMenu = true;
                } else {
                    actions.get(userSelectForDictionary).execute(typeLibrary);
                }

            } catch (NumberFormatException e) {
                System.out.println(ConsoleConstants.ERROR_TYPE_DATA);
            } catch (NullPointerException e) {
                System.out.println(ConsoleConstants.ERROR_FIND_PAIRS);
            }
        }

    }


}