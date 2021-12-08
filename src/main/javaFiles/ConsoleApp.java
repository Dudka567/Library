package src.main.javaFiles; 
import java.io.IOException;
import java.util.Scanner;

public class ConsoleApp
{
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
    public static final String FIRST_OPERATION = ".Show the contents of the dictionary\n";
    public static final String SECOND_OPERATION = ".Add an entry\n";
    public static final String THIRD_OPERATION = ".Delete an entry\n";
    public static final String FOURTH_OPERATION = ".Search records by key\n";
    public static final String FIFTH_OPERATION = ".Finish working with this dictionary\n";
    public static final String INPUT_KEY = "Enter the key:";
    public static final String INPUT_VALUE = "Enter a value:";
    public static final int CHOOSE_OPERATION_ONE = 1;
    public static final int CHOOSE_OPERATION_TWO = 2;
    public static final int CHOOSE_OPERATION_THREE = 3;
    public static final int CHOOSE_OPERATION_FOUR = 4;
    public static final int CHOOSE_OPERATION_FIFE = 5;
    private boolean exitMainMenu = false;
    private boolean exitLibraryMenu = false;
    private String userSelect;
    private int userSelectForDictionary = 0;
    private FileManager manager;
    private LibraryFactory libraryFactory;
    private Scanner user = new Scanner(System.in);

    public ConsoleApp(FileManager manager, LibraryFactory libraryFactory)
    {
     this.manager = manager;
     this.libraryFactory = libraryFactory;
    }

    public void work() throws IOException
    {
        while (!exitMainMenu)
        {

            System.out.print(ASK_ABOUT_TYPE_DICTIONARY + CHAR_FOR_NEXT_LINE);
            for(String variant : libraryFactory.getDictionaries().keySet())
            {
                System.out.println(variant+CHAR_POINT+libraryFactory.getDictionaries().get(variant).getNameLibrary());
            }
            System.out.print(EXIT+CHAR_FOR_NEXT_LINE+CHOOSE_USER);
            try {
                userSelect = user.next();

                for (String compareLine : libraryFactory.getDictionaries().keySet())
                {
                     if(userSelect.equals(EXIT_LINE))
                    {
                        exitMainMenu = true;
                        break;
                    }
                     else if(libraryFactory.getDictionaries().keySet().contains(compareLine))
                     {
                         for (String Line : libraryFactory.getDictionaries().keySet())
                         {
                             if (userSelect.equals(Line))
                             {
                                 libraryFactory.getDictionaries().get(Line).setFileDir(manager.searchLibrary(Line));
                                 workWithLibrary(libraryFactory.getDictionaries().get(Line));
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

        public void workWithLibrary(Library library) throws IOException {
            while (!exitLibraryMenu) {

                System.out.print(ASK_ABOUT_OPERATION_DICTIONARY+CHOOSE_OPERATION_ONE+FIRST_OPERATION+CHOOSE_OPERATION_TWO+
                        SECOND_OPERATION+CHOOSE_OPERATION_THREE+THIRD_OPERATION+CHOOSE_OPERATION_FOUR+FOURTH_OPERATION
                        +CHOOSE_OPERATION_FIFE+FIFTH_OPERATION+CHOOSE_USER);
                try {
                    userSelectForDictionary = Integer.parseInt(user.next());

                    switch (userSelectForDictionary) {
                        case CHOOSE_OPERATION_ONE:
                        {
                            library.readPairs();
                            for(String lineKey : library.getDictionary().keySet())
                            {
                                System.out.println(KEY+lineKey+CHAR_SPACE+VALUE+library.getDictionary().get(lineKey));
                            }
                            break;
                        }
                        case CHOOSE_OPERATION_TWO:
                        {
                            System.out.print(INPUT_KEY);
                            String tempKey = user.next();
                            System.out.print(INPUT_VALUE);
                            String tempValue = user.next();
                            library.addPair(tempKey, tempValue);break;
                        }
                        case CHOOSE_OPERATION_THREE:
                        {
                            System.out.print(INPUT_KEY);
                            String tempKey = user.next();
                            library.deletePair(tempKey);break;
                        }
                        case CHOOSE_OPERATION_FOUR:
                        {
                            System.out.print(INPUT_KEY);
                            String tempKey = user.next();
                            System.out.println(library.searchPair(tempKey));break;
                        }
                        case CHOOSE_OPERATION_FIFE:
                        {
                            exitLibraryMenu = true;
                            break;
                        }
                        default:
                        {
                            System.out.println(NOT_SEARCH);
                            break;
                        }
                    }
                }
                catch (NumberFormatException e)
                {
                    System.out.println(ERROR_TYPE_DATA);
                } catch (NullPointerException e)
                {
                    System.out.println(ERROR_FIND_PAIRS);
                }
                catch(IOException e)
                {
                    System.out.println(ERROR_NAME_FILE);
                }

            }
            exitLibraryMenu = false;
        }

}