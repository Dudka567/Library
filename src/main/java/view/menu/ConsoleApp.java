package view.menu;

import view.commands.Action;

import java.util.*;

public class ConsoleApp {
    private static final Integer FIRST_MENU_ITEM_NUMBER = 1;
    private final Map<Integer, String> dictionariesTypes;
    private final Map<Integer, Action> actions;

    public ConsoleApp(List<String> dictionariesTypes, List<Action> actions) {
        this.dictionariesTypes = new HashMap<>();
        initDitcionariesTypes(dictionariesTypes);

        this.actions = new HashMap<>();
        initActions(actions);
    }

    public void initDitcionariesTypes(List<String> dictionariesTypes) {
        for (int dictionaryCounter = 0; dictionaryCounter < dictionariesTypes.size(); dictionaryCounter++) {
            this.dictionariesTypes.put(dictionaryCounter + FIRST_MENU_ITEM_NUMBER, dictionariesTypes.get(dictionaryCounter));
        }
    }

    public void initActions(List<Action> actions) {
        for (int actionCounter = 0; actionCounter < actions.size(); actionCounter++) {
            Action tempAction = actions.get(actionCounter);
            tempAction.setPosition(actionCounter + FIRST_MENU_ITEM_NUMBER);
            this.actions.put(actionCounter + FIRST_MENU_ITEM_NUMBER, tempAction);
        }
    }

    public void work() {
        String userSelect;
        while (true) {
            System.out.println(ConsoleConstants.ASK_ABOUT_TYPE_DICTIONARY);

            for (Integer menuCounter : dictionariesTypes.keySet()) {
                System.out.println(menuCounter + ConsoleConstants.CHAR_POINT + dictionariesTypes.get(menuCounter));
            }


            System.out.print(ConsoleConstants.EXIT + ConsoleConstants.CHAR_FOR_NEXT_LINE + ConsoleConstants.CHOOSE_USER);
            try {
                userSelect = ConsoleConstants.user.next();

                if (userSelect.equals(ConsoleConstants.EXIT_LINE)) {
                    break;
                } else if (dictionariesTypes.containsKey(Integer.parseInt(userSelect))) {
                    workWithLibrary(dictionariesTypes.get(Integer.parseInt(userSelect)));
                } else {
                    System.out.println(ConsoleConstants.NOT_SEARCH);
                }

            } catch (NumberFormatException e) {
                System.out.println(ConsoleConstants.ERROR_TYPE_DATA);
            } 
        }
    }

    public void workWithLibrary(String typeLibrary) {
        int userSelectForDictionary;
        while (true) {
            System.out.print(ConsoleConstants.ASK_ABOUT_OPERATION_DICTIONARY);

            for (Integer actionCounter : actions.keySet()) {
                System.out.print(actions.get(actionCounter).getTitle());
            }

            System.out.print(ConsoleConstants.CHOOSE_USER);
            try {
                userSelectForDictionary = Integer.parseInt(ConsoleConstants.user.next());

                if (actions.get(userSelectForDictionary) == null) {
                    System.out.println(ConsoleConstants.NOT_SEARCH);
                } else if (userSelectForDictionary == actions.size()) {
                    break;
                } else {
                    actions.get(userSelectForDictionary).execute(typeLibrary);
                }

            } catch (NumberFormatException e) {
                System.out.println(ConsoleConstants.ERROR_TYPE_DATA);
            } 
        }

    }


}